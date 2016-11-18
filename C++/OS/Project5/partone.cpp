// CS3242 Operating Systems
// Spring 2015
// Project 5: Swapping and Paging, Part 1
// Alex Wardlaw, Ryan Williams, and Ryan Wraggs
// Date: 4/14/2015
// File: PartOne.cpp

#include <iostream>
#include <sstream>
#include <stdio.h>
#include <list>
#include <stdlib.h>     /* srand, rand */
#include <time.h>       /* time for srand */
#include <unistd.h>     /* usleep */
#include <vector>

using namespace std;

#define MAX_PROCESSES 60        // This will not ever change
#define PROCESS_COUNT 60        // useful when debugging to limit # of procs
#define MIN_BURST 10
#define MAX_BURST 2000
#define MIN_MEMORY_PER_PROC 4
#define MAX_MEMORY_PER_PROC 160
#define MAX_MEMORY 1040
#define MAX_BLOCK_PROC_RATIO 0.5
#define ENABLE_COMPACTION 1     // Boolean flag for whether compaction is 1 == on, and 0 == off
#define PRINT_INTERVAL 100      // # of cpu quanta between memory map printouts
#define MAX_QUANTA 2000        // # quanta to run before ending simulation.
#define SLEEP_LENGTH 10000       // Used with the usleep()to slow down sim between
// cycles (makes reading screen in real-time easier!)

//struct for the processes
struct Process
{
    char name;
    int base;               //the first location of memory
    int limit;              //the size of the ammount of memory used
    int burst;              //the burst of cpu cycles that the process needs to complete
    int currentTotalBurst;  //keeps total of bursts while in memory.  necessary because
    //process will need to be swapped out.
}p;

void print();
string NumberToString (int number);
int StringToNumber(string choiceStr);
list<pair<int,int> > FindAllHoles(int size);
void init_mem();
void RemoveProcess(char procName);
void Compact();
int first_fit(int p_size);
int best_fit(int p_size);
int worst_fit(int p_size);
bool InsertProcess(Process p);
void print_stats();

char memArr[MAX_MEMORY];
char charArr[] = {'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','m','n','o','p','q','r','s','t','u','v','w','x','y','&'};

list<Process> inMemory;
list<Process> readyQueue;
list<Process> allProcList;
int choice = 0;
int quanta, mem_used, mem_free, largest_block, smallest_block;



/******************************************************** main ***************************************************************/
int main(void)
{
    srand (time(NULL));     //seed the random number generator.
    string in;
    do{
        cout << "\nChoose a memory allocation type\n1:\tFirst fit\n2:\tBest fit\n3:\tWorst fit\n4:\tExit\n\nUser Input: ";
        cin >> in;
        choice = StringToNumber(in);
        if(choice == 1)
            cout << "You chose: " << choice << " for First Fit" << endl;
        else if(choice == 2)
            cout << "You chose: " << choice << " for Best Fit" << endl;
        else if(choice == 3)
            cout << "You chose: " << choice << " for Worst Fit" << endl;
        else if(choice == 4){
            cout << "You chose: " << choice << endl;
            cout << "\n * * *\tEXIT PROGRAM\t* * *" << endl;
            exit(0);
        }
        else
            cout << "\nInvalid choice. Try again.\n";
    } while(choice != 1 && choice != 2 && choice != 3);
    
    init_mem();
    print();
    
    quanta = 0;
    while (quanta <= MAX_QUANTA)
    {
        for (std::list<Process>::iterator iter = inMemory.begin(); iter != inMemory.end(); ++iter){
            (*iter).currentTotalBurst++;
            
        }
        
        for (std::list<Process>::iterator iter = inMemory.begin(); iter != inMemory.end(); ++iter)
        {
            if(iter->currentTotalBurst >= iter->burst){
                RemoveProcess(iter->name);
                iter++;
                // Compact();
                list<Process>::iterator it;
                do{
                    it = readyQueue.begin();
                } while(InsertProcess(*it));
                
                if(((FindAllHoles(1).size()*1.0000)/(inMemory.size()*1.0000)) >= MAX_BLOCK_PROC_RATIO  && quanta > 0 && ENABLE_COMPACTION == 1){
                    printf("\n\n*\t*\t*\tBLOCKS/PROC RATIO EXCEEDED\t*\t*\t*\n\n");
                    print_stats();
                    print();
                    Compact();
                    // printf("\n\n*\t*\t*\tCOMPACT COMPLETE\t*\t*\t*\n\n");
                    print_stats();
                    print();
                    printf("\n\n*\t*\t*\tCOMPACT COMPLETE\t*\t*\t*\n\n");
                
                }
                break;
            }
        }
        if (quanta % PRINT_INTERVAL == 0)
        {
            print_stats();
            print();
        }
        
        quanta++;
        usleep(SLEEP_LENGTH);
    }
    
    /*RemoveProcess('Z');
     print();
     
     Compact();
     print();*/
    
    return 0;
}

/******************************************************** main ***************************************************************/

void print()
{
    string sixSpaces = "      ";
    string ruler = "----+----|----+----|----+----|----+----|----+----|----+----|----+----|----+----|";
    int rowWidth = 80;
    int i = 0;
    while (i < 1040)
    {
        string numLine;
        string memLine;
        //creates the row with the numbers with the proper spacing.
        for (int counter = 0; counter < rowWidth / 10; counter++)
        {
            string str = NumberToString(i + 9);
            if (str.length() == 1)
                numLine += sixSpaces + "   " + str;
            else if (str.length() == 2)
                numLine += sixSpaces+ "  " + str;
            else if (str.length() == 3)
                numLine += sixSpaces + " " + str;
            else if (str.length() == 4)
                numLine += sixSpaces + str;
            
            i += 10;
        }
        
        printf("%s\n", numLine.c_str());
        printf("%s\n", ruler.c_str());
        
        //creates the line showing whats in memory.
        for (int counter = 0; counter < rowWidth; counter++)
        {
            //add the value if its not null
            if (memArr[((i - rowWidth) + counter)] != NULL)
                memLine += memArr[((i - rowWidth) + counter)];
            //else add a space if it is null
            else
                memLine += " ";
        }
        printf("%s\n", memLine.c_str());
    }
    printf("\n\n");
}

//converts number to string
string NumberToString (int number)
{
    stringstream ss;
    string s;
    ss << number;
    ss >> s;
    return s;
}

int StringToNumber(string choiceStr){
    stringstream ss;
    int choiceInt = -1;
    ss << choiceStr;
    ss >> choiceInt;
    if (ss.fail())
        return -1;
    return choiceInt;
}
//finds a hole of the needed size.  first int is hole location, last int is hole size
list<pair<int,int> > FindAllHoles(int size)
{
    
    // first int=hole location, second int=hole size
    list<pair<int,int> > holeList;
    bool holeFound = false;
    int tmpHoleStart = 0;
    
    for (int i = 0; i < MAX_MEMORY; i++)
    {
        if (memArr[i] != NULL && holeFound){
            if ((i - tmpHoleStart) > size){
                holeList.push_back(make_pair(tmpHoleStart, i - tmpHoleStart));
            }
            holeFound = false;
        }
        else if (memArr[i] == NULL && !holeFound){
            tmpHoleStart = i;
            holeFound = true;
        }
    }
    
    //this is to find the hole that ends at the end of the array
    if (holeFound && (MAX_MEMORY - tmpHoleStart) > size)
        holeList.push_back(make_pair(tmpHoleStart, MAX_MEMORY - tmpHoleStart));
    
    return holeList;
}

void init_mem()
{
    //this part is necessary to weight the size of the processes.
    int totalProcSoFar = 0;
    int count = 0;
    int procToBeCreated = PROCESS_COUNT * .3;
    for (int i = 0; i < procToBeCreated; i++)
    {
        Process p;
        p.name = charArr[count++];
        p.limit = rand() % 4 + 4;
        p.burst = rand() % (MAX_BURST - MIN_BURST) + MIN_BURST;
        allProcList.push_back(p);
    }
    totalProcSoFar += procToBeCreated;
    
    //this part is necessary to weight the size of the processes.
    procToBeCreated = PROCESS_COUNT * .25;
    for (int i = 0; i < procToBeCreated; i++)
    {
        Process p;
        p.name = charArr[count++];
        p.limit = rand() % 9 + 18;
        p.burst = rand() % (MAX_BURST - MIN_BURST) + MIN_BURST;
        allProcList.push_back(p);
    }
    totalProcSoFar += procToBeCreated;
    
    //this part is necessary to weight the size of the processes.
    procToBeCreated = PROCESS_COUNT * .2;
    for (int i = 0; i < procToBeCreated; i++)
    {
        Process p;
        p.name = charArr[count++];
        p.limit = rand() % 19 + 48;
        p.burst = rand() % (MAX_BURST - MIN_BURST) + MIN_BURST;
        allProcList.push_back(p);
    }
    totalProcSoFar += procToBeCreated;
    
    //this part is necessary to weight the size of the processes.
    procToBeCreated = PROCESS_COUNT * .15;
    for (int i = 0; i < procToBeCreated; i++)
    {
        Process p;
        p.name = charArr[count++];
        p.limit = rand() % 49 + 96;
        p.burst = rand() % (MAX_BURST - MIN_BURST) + MIN_BURST;
        allProcList.push_back(p);
    }
    totalProcSoFar += procToBeCreated;
    
    //this part is necessary to weight the size of the processes.
    for (int i = 0; i < (PROCESS_COUNT - totalProcSoFar); i++)
    {
        Process p;
        p.name = charArr[i];
        p.limit = 30;
        p.burst = rand() % (MAX_BURST - MIN_BURST) + MIN_BURST;
        allProcList.push_back(p);
    }
    
    count = 0;
    largest_block = 0;
    smallest_block = MAX_MEMORY;
    
    //professor specified that the first 120 spaces were used by the kernel, '@'
    for (count; count < 120; count++)
        memArr[count] = '@';
    
    //need a vector to use the [index] operator
    vector<Process> procVec;
    for (std::list<Process>::iterator iter = allProcList.begin(); iter != allProcList.end(); ++iter)
    {
        procVec.push_back(*iter);
    }
    
    //this loop randomly selects a process to be added to memory or to the ready queue
    while (procVec.size() > 0)
    {
        int i = rand() % procVec.size();
        Process p = procVec[i];
        if ((count + p.limit) < MAX_MEMORY)
        {
            for (int i = 0; i < p.limit; i++)
                memArr[count + i] = p.name;
            count += p.limit;
            
            //            // setting largest block var
            //            if(p.limit > largest_block)
            //                largest_block = p.limit;
            //
            //            // setting smallest block var
            //            if(p.limit < smallest_block)
            //                smallest_block = p.limit;
            
            inMemory.push_back(p);
            mem_used = count;
        }
        else
        {
            readyQueue.push_back(p);
        }
        procVec.erase(procVec.begin() + i);
    }
    mem_free = MAX_MEMORY - mem_used;
}

void RemoveProcess(char procName)
{
    for (list<Process>::iterator iter = inMemory.begin(); iter != inMemory.end(); ++iter)
    {
        // search for process passed in as prodName
        if (iter->name == procName)
        {
            iter->currentTotalBurst = 0;
            // check if process being removed is currently largest or smallest in mem
            // if so, then reset and re-define new largest / smallest
            
            if(iter->limit == largest_block){
                largest_block = 4;
                for(list<Process>::iterator it = inMemory.begin(); it != inMemory.end(); ++it){
                    if(it->limit > largest_block)
                        largest_block = it->limit;
                }
            }
            if(iter->limit == smallest_block){
                smallest_block = MAX_MEMORY;
                for(list<Process>::iterator it = inMemory.begin(); it != inMemory.end(); ++it){
                    if(it->limit < smallest_block)
                        smallest_block = it->limit;
                }
            }
            
            readyQueue.push_back(*iter);
            inMemory.erase(iter);
            
            //now remove the characters from the array
            for (int i = 0; i < MAX_MEMORY; i++)
            {
                if (memArr[i] == procName){
                    memArr[i] = NULL;
                    mem_used--;
                    mem_free++;
                    
                }
            }
            break;
        }
    }
}

// removes holes in mem that are unused/fragmentation "defrag"
void Compact()
{
    // ENABLE_COMPACTION boolean flag for whether compaction is 1 == on, and 0 == off
    if (ENABLE_COMPACTION == 1)
    {
        bool holesFound = false;
        list<pair<int,int> > holelist = FindAllHoles(1);
        
        if ((holelist.begin()->first + holelist.begin()->second) != MAX_MEMORY)
            holesFound = true;
        
        while (holesFound)
        {
            pair<int,int> p = holelist.front();
            for (int i = p.first; i < (MAX_MEMORY - p.second); i++)
            {
                memArr[i] = memArr[i + p.second];
            }
            
            holelist.clear();
            holelist = FindAllHoles(1);
            
            if ((holelist.begin()->first + holelist.begin()->second) == MAX_MEMORY)
                holesFound = false;
        }
    }
}

// passing in p.limit (size of process)
int FirstFit(int p_size)
{
    list<pair<int,int> > holelist = FindAllHoles(p_size);
    if (holelist.begin() != holelist.end())
        return holelist.begin()->first;
    return -1;
}

// passing in p.limit (size of process)
int BestFit(int p_size)
{
    list<pair<int,int> > holelist = FindAllHoles(p_size);
    
    int tmpLocation = -1;
    int tmpSize = MAX_MEMORY;
    for (list<pair<int,int> >::iterator iter = holelist.begin(); iter != holelist.end(); ++iter)
    {
        if (iter->second < tmpSize)
        {
            tmpSize = iter->second;
            tmpLocation = iter->first;
        }
    }
    return tmpLocation;
}

// passing in p.limit (size of process)
int WorstFit(int p_size)
{
    list<pair<int,int> > holelist = FindAllHoles(p_size);
    
    int tmpLocation = -1;
    int tmpSize = 0;
    for (list<pair<int,int> >::iterator iter = holelist.begin(); iter != holelist.end(); ++iter)
    {
        if (iter->second > tmpSize)
        {
            tmpSize = iter->second;
            tmpLocation = iter->first;
        }
    }
    return tmpLocation;
}

bool InsertProcess(Process p)
{
    int location = -1;
    switch(choice)
    {
        case 1:
            location = FirstFit(p.limit);
            break;
        case 2:
            location = BestFit(p.limit);
            break;
        case 3:
            location = WorstFit(p.limit);
            break;
            
    }
    if (location < 120 || (location+p.limit) > MAX_MEMORY)
        return false;
    
    //add into memory array
    for (int i = location; i < (location + p.limit); i++)
    {
        memArr[i] = p.name;
        mem_used++;
        mem_free--;
    }
    
    for (std::list<Process>::const_iterator iter = readyQueue.begin(); iter != readyQueue.end(); ++iter)
    {
        if (iter->name == p.name)
        {
            inMemory.push_back(*iter);
            if(iter->limit > largest_block){
                largest_block = iter->limit;
            }
            if(iter->limit < smallest_block){
                smallest_block = iter->limit;
            }
            readyQueue.erase(iter);
        }
    }
    return true;
}

void print_stats(){
    int loaded = (int)inMemory.size();       // num processes in memory
    int unloaded = (int)readyQueue.size();   // num processes in ready queue
    double free = 0.0;
    double used = 0.0;
    double mem_ratio = 0.0000;
    int free_blocks = (int)FindAllHoles(1).size();
    used = ((mem_used*1.00)/(MAX_MEMORY*1.00))*100;
    free = ((mem_free*1.0)/(MAX_MEMORY*1.0))*100;
    mem_ratio = (free_blocks*1.0000)/(loaded*1.0000);

    //    printf("LOADED:\t\tUNLOADED:\t\t\n");
    printf("QUANTA ELAPSED:%i\t\tSYSTEM MEMORY: %i\t\tMAX PROCESSES: %i\n", quanta, MAX_MEMORY, MAX_PROCESSES);
    printf("USED MEM: %db - (%.1f%%)\tFREE MEM: %db - (%.1f%%)\nLOADED: %d - (%.1f%%)\t\tUNLOADED: %d - (%.1f%%)\t\tFREE BLOCKS:\t%d\t\n"
           ,mem_used,used,mem_free,free,loaded,((loaded*1.00)/(allProcList.size()*1.00))*100, unloaded,((unloaded*1.00)/(allProcList.size()*1.00))*100,free_blocks);
    printf("LARGEST: %db\t\t\tSMALLEST: %db\t\t\tBLOCKS/PROCS RATIO: %.4f\n\n", largest_block, smallest_block, mem_ratio);
}