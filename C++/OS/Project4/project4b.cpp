// CS3242 Operating Systems
// Spring 2015
// Project 4: Process Synchronization, Part 2
// Dean Alex Wardlaw, Ryan Williams, and Ryan Wraggs
// Date: 3/17/2015
// File: Project4b.cpp

#include <iostream>
#include <stdlib.h>
#include <unistd.h>
#include <fstream>
#include <sys/shm.h>
#include <sys/mman.h>
#include <pthread.h>
#include <semaphore.h>

using namespace std;

//used to get the current working directory to determine where to put the number file.
char *getcwd(char *buf, size_t size);

void performFork();
void selectSort(int start, int end, int unsortedStart);
void* threadFunct(void* param);
void bubbleSort(int arrSize);

//this number must be divisile by 10 or else it wont get sorted right.
const int arSize = 10000;
const int numThreads = 4;
int threadNum;
int* unsortedArr, *sortedArr, *nextAvailArrIdx;
int nextChildStartIdx;
sem_t *parent, *child;
const char* parentName = "parent";
const char* childName = "child";

int main(void)
{
    
    int arrNums[arSize - 1];
    
    //int iter = 0;
    string filePath;
    filePath = ("/Users/jameswilliams/CodeRepo/C++/OS/Project4/numbers10k.txt");
    //string filePath = ("/Users/jameswilliams/Dropbox/School By Term/Spring 15/Operating Syst./Group Projects/Project3/numbers.txt");
    string numberIn;
    
    ifstream myfile (filePath);
    
    printf("reading file.\n");
    
    if (myfile.is_open()){
        int i = 0;
        while (myfile.good()){
            getline(myfile, numberIn);
            if (i >= arSize)
                break;
            
            arrNums[i] = stoi(numberIn);
            
            //increment i
            i++;
        }
        myfile.close();
    }
    else
    {
        printf("cound not open file: \n");
        //used to get the current working directory to determine where to put the number file.
        char cwd[1024];
        if (getcwd(cwd, sizeof(cwd)) != NULL)
            printf("please ensure a copy of the file <numbers10k.txt> is located in the directory: %s\n", cwd);
        //cout << "please ensure a copy of the file <numbers10k.txt> is located in the directory: " << cwd << endl;
        
        else
            perror("getcwd() error");
        
        exit(0);
    }
    
    unsortedArr = (int *) mmap(NULL, arSize*sizeof(int), PROT_READ | PROT_WRITE,
                               MAP_SHARED | MAP_ANON, -1, 0);
    sortedArr = (int *) mmap(NULL, arSize*sizeof(int), PROT_READ | PROT_WRITE,
                             MAP_SHARED | MAP_ANON, -1, 0);
    nextAvailArrIdx = (int *) mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE,
                                   MAP_SHARED | MAP_ANON, -1, 0);
    int tmp = 0;
    *nextAvailArrIdx = tmp;
    
    for (int i = 0; i < arSize; i++)
    {
        unsortedArr[i] = arrNums[i];
    }
    
    nextChildStartIdx = 0;
    
    printf("creating children\n");
    
    sem_unlink(parentName);          //make sure the semaphores are unlinked.
    sem_unlink(childName);           //make sure the semaphores are unlinked.
    parent = sem_open(parentName, O_CREAT, 0, 0);          // num of filled spots in buffer
    if (parent == SEM_FAILED) {       //test to see if semaphore was successfully created.
        perror("sem_open");
        exit(1);
    }
    child = sem_open(childName, O_CREAT, 0, 1);   // num of empty spots in buffer
    if (child == SEM_FAILED) {      //test to see if semaphore was successfully created.
        perror("sem_open");
        exit(1);
    }
    pthread_t thread1, thread2, thread3, thread4;
    pthread_t threads[] = {thread1, thread2, thread3, thread4};
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    
    threadNum = 0;
    
    for(int i = 0; i < numThreads; i++){
        pthread_create(&threads[i], &attr, threadFunct, NULL);
    }
    
    while (*nextAvailArrIdx < arSize)
    {
        sem_wait(parent);
        // printf("parent sorting\n");
        bubbleSort(*nextAvailArrIdx);
        sem_post(child);
    }
    
    printf("\n\tSorting complete.\n\n* * Sorted Array Below * *\n\n");

    for (int i = 0; i < arSize; i++)
    {
        printf("i:\t%i\t\tArr Val:  %i\n", i, sortedArr[i]);
    }
    
    sem_unlink(parentName);         //make sure the semaphores are unlinked.
    sem_unlink(childName);          //make sure the semaphores are unlinked.
    
}

void* threadFunct(void* param)
{
    int number = threadNum++;
    int endNum = nextChildStartIdx + (arSize/numThreads);
    int startNum = nextChildStartIdx;
    nextChildStartIdx = endNum;
    
    printf("thread %i will be sorting indexes %i to %i\n", number, startNum, endNum-1);
    
    for (int i = startNum; i < (endNum - 1); i += 10)
    {
        sem_wait(child);
        printf("(Sorting) - Thread number:\t%i\n", number);
        selectSort(*nextAvailArrIdx, *nextAvailArrIdx + 10, i);
        sem_post(parent);
    }
    return 0;
}

void selectSort(int start, int end, int unsortedStart)
{
    //pos_min is short for position of min
    int pos_min,temp;
    
    for (int i = start; i < end; i++) {
        sortedArr[i] = unsortedArr[unsortedStart + (i % 10)];
    }
    
    for (int i = start; i < end; i++)
    {
        pos_min = i;//set pos_min to the current index of array
        
        for (int j=i+1; j < end; j++)
        {
            if (sortedArr[j] < sortedArr[pos_min])
                pos_min=j;
            //pos_min will keep track of the index that min is in, this is needed when a swap happens
        }
        
        //if pos_min no longer equals i than a smaller value must have been found, so a swap must occur
        if (pos_min != i)
        {
            temp = sortedArr[i];
            sortedArr[i] = sortedArr[pos_min];
            sortedArr[pos_min] = temp;
        }
    }
    
    *nextAvailArrIdx += 10;
}

void bubbleSort(int arrSize)
{
    bool swapped = true;
    int j = 0;
    int tmp;
    while (swapped) {
        swapped = false;
        j++;
        for (int i = 0; i < arrSize - j; i++) {
            if (sortedArr[i] > sortedArr[i + 1]) {
                tmp = sortedArr[i];
                sortedArr[i] = sortedArr[i + 1];
                sortedArr[i + 1] = tmp;
                swapped = true;
            }
        }
    }
}
