/*
 File:   OMP_MonteCarlo.cpp
 Author: Ryan Williams
 Date:   October 23, 2015, 10:04 AM

 Purpose: Simulate throwing darts at a dart board w r=1.
 Calculate pi from the number of darts that land within the radius.
 Program is written in serial fashion and run in parallel with the
 implementation of OpenMP framework.

 Compiling Command:
 OpenMP --> g++ -std=c++0x -Wall -fopenmp -oOMP_MCarlo monte_carlo_omp.cpp

 Note: October 24, 15: Program is running in a sequential fashion
       and will need to have omp implemented next.
 */

#include "timer.h"
#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include <random>
#include <iostream>
#include <random>
using namespace std;

/* function headers */
long long throwDarts(long long n);
double calcPi();
/* function headers */

// globals
long long NUM_THREADS;
long long NUM_DARTS;
long long NUM_HITS;
timer myTimer;
// globals

int main ( /* int argc, const char * argv[] */ ) {
    long long dartsArr [] = {6400000, 64000000, 640000000};
    long long threads_arr [] = {16, 32, 64};
    for (int j = 0; j < 3; ++j) {
        for(int i = 0; i < 3; ++i){
            NUM_DARTS = dartsArr[i];
            NUM_HITS = 0;
            myTimer.start();
            printf("\nDarts: %lld\n", NUM_DARTS);
            printf("Threads: %lld\n", threads_arr[j]);
            NUM_THREADS = threads_arr[j];

            #pragma omp parallel num_threads(NUM_THREADS) \
                reduction (+:NUM_HITS)
                NUM_HITS += throwDarts(NUM_THREADS);

            printf("Hits: %lld \n", NUM_HITS);
            printf("Pi: %f\n", (float)calcPi());
            printf("Time: %f \n", ((float)myTimer.elapsedTime()/10000000));
        }
    }
    return 0;
}

long long throwDarts(long long n) {
    /* USE OF OMP FUNCTIONALITY FOR THREAD ATTRIBUTES */
    long long my_rank = omp_get_thread_num();
    long long local_thread_count = omp_get_num_threads();
    /* INIT RANDOMS */
    random_device rd1;
    random_device rd2;
    mt19937 mt1(rd1());
    mt19937 mt2(rd2());
    /* INIT VARS */
    long long my_count = 0;
    long long i, my_start, my_end, group_size;
    /* ASSIGN EACH THREAD A PORTION */
    group_size = NUM_DARTS/local_thread_count;
    my_start = my_rank * group_size;
    my_end = my_start + group_size;

    /* PRINT TO TEST APPROPRIATE ALLOCATIONS */
//    printf("Thread: %lld / %lld  ", my_rank, local_thread_count);
//    printf("Start: %lld  End: %lld  ", my_start, my_end);
//    printf("Group: %lld\n", group_size);

    for (i = my_start; i < my_end; ++i) {
        double x, y;
        x = ((double)mt1()/(RAND_MAX))-1;
        y = ((double)mt2()/(RAND_MAX))-1;
        if((x*x)+(y*y) <=1) {
            ++my_count; // LOCAL THREAD COUNT
        }
    }
    return my_count;
    /*
    USE OF REDUCTION INSTEAD OF CRITICAL
    #pragma omp critical
    NUM_HITS += my_count;
    my_count = 0;
    */
}

double calcPi(){
    double myPi =  (4 * (double)NUM_HITS / (double)NUM_DARTS);
    return myPi;
}
