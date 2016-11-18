//
//  parttwo.cpp
//

#include <stdio.h>
#include <iostream>
#include <time.h>
#include <stdlib.h>
#include <utility>
#include <set>
#include <math.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/mman.h>

using namespace std;

class timer {
private:
    unsigned long begTime;

public:
    void start()
    {
        begTime = clock();
    }

    unsigned long elapsedTime()
    {
        return ((unsigned long) clock() - begTime);
    }
};



//number of darts to throw.
uint NUM_DARTS;
int NUM_THREADS[] = {1,2,10};
int NUM_DARTS_ON_TRIAL[] = {2500,1000000,10000000};
uint *NUM_HITS;

void performFork(int thread_count);
void throwDarts(uint num, set< pair < double, double > > & darts);
uint CalculateHits(set<pair<double, double>> darts);

//with threading
/* Mar1 update: changed the num_threads to an array for iterations on required num threads (1,2,10) */
int main()
{
    for (int j = 0; j < 3; j++){
        NUM_DARTS = NUM_DARTS_ON_TRIAL[j];
        //seed the random generator so it is truly random
        srand ((unsigned int)time(NULL));

        //shared uint
        NUM_HITS = (uint *) mmap(NULL, sizeof *NUM_HITS, PROT_READ | PROT_WRITE,
                                 MAP_SHARED | MAP_ANON, -1, 0);

        // enter number of darts and threads
        cout << "Number of darts to throw: " << NUM_DARTS << "\t\tNumber of threads: " << NUM_THREADS[j] << endl;
        // cin >> NUM_DARTS;
        // cin >> NUM_THREADS[j];

        cout << endl << "START" << endl;
        timer t;
        t.start();

        //i = 1 because if there is only 1 thread, the parent thread can throw the darts
        for (int i = 1; i < NUM_THREADS[j]; i++)
        {
            performFork(NUM_THREADS[j]);
        }

        // necessary because parent thread will also throw darts
        //declared set locally so there is no chance of shared values between parent and child
        set<pair<double, double>> darts;

        uint dartsToThrow = NUM_DARTS / NUM_THREADS[j];
        throwDarts(dartsToThrow, darts);

        uint hits = CalculateHits(darts);
        *NUM_HITS += hits;

        cout << "parent pid: \t" << getpid() << " done." << endl;
        cout << "parent pid: \t" << getpid() << " darts thrown: \t" << dartsToThrow << " hits: \t" << hits << endl;

        //didnt have the patience to figure out wait()
        for (int j = 0; j < 1000000; j++);

        cout << "finished." << endl;
        unsigned long timeTaken = t.elapsedTime();

        cout << "HITS: \t" << *NUM_HITS << "\t\tDarts Thrown: \t" << dartsToThrow << "\npi = " << 4 * (double)*NUM_HITS / NUM_DARTS << "\t\tElapsed time: " << timeTaken << "\n" << endl;
    }
}

void performFork(int thread_count)
{
    int num_thread = thread_count;
    pid_t pid0;
    pid0 = fork();

    if (pid0 < 0)
    {
        // error encountered
        fprintf(stderr, "Fork failed.\n");
        return;
    }
    else if ((pid0 == 0) || (pid0 == 1))
    {
        // child process
        cout << "Child pid: \t\t" << getpid() << "\nStart throwing darts." << endl;

        //set used so duplicates are not allowed. contains the (x,y) coords of the dart throw.
        set<pair<double, double>> darts;

        uint dartsToThrow = NUM_DARTS / num_thread;
        throwDarts(dartsToThrow, darts);

        uint hits = CalculateHits(darts);
        //record hits to shared memory.
        *NUM_HITS += hits;

        cout << "Child pid: \t\t" << getpid() << " done." << endl;
        cout << "Parent pid: \t" << getpid() << endl;

        //necessary so child threads do not run again in the enclosing for loop
        exit(0);
    }
    else
    {
        cout << "Parent pid: \t" << getpid() << "\nStart throwing darts." << endl;
        //parent throws its darts after performFork() because if done inside this method
        //at least one child and the parent would run even if only 1 thread was specified.
    }
}

//takes in set by reference so that it can add items to the set
void throwDarts(uint num, set < pair < double, double > > & darts)
{
    //this loop throws the specified number of darts
    for (uint i = 0; i < num; i++)
    {
        double x, y;

        //generates a random double between 0 and 1
        x = ((double)rand()/RAND_MAX);
        y = ((double)rand()/RAND_MAX);
        pair<double,double> p (x,y);
        darts.insert(p);
    }
}

uint CalculateHits(set<pair<double, double>> darts)
{
    int hits = 0;

    // cout << darts.size() << endl;

    //iterates through the set
    for (set<pair<double,double>>::iterator it = darts.begin() ; it != darts.end(); it++)
    {
        //squares the values
        double x = pow (get<0>(*it), 2);
        double y = pow (get<1>(*it), 2);

        //sums x squared and y squared then checks to see if it is less than the radius squared
        if ((x+y) < 1)
            hits++;
    }
    return hits;
}
