// CS3242 Operating Systems
// Spring 2015
// Project 4: Process Synchronization, Part 1
// Dean Alex Wardlaw, Ryan Williams, and Ryan Wraggs
// Date: 3/17/2015
// File: Project4a.cpp
#include <iostream>
#include <stdlib.h>     // .h for atoi()
#include <unistd.h>     // .h for sleep()
#include <pthread.h>
#include <semaphore.h>

using namespace std;

#define BUFFER_SIZE 5
typedef int buffer_item;
buffer_item buffer[BUFFER_SIZE];
int n;
sem_t *full, *empty;
const char* fullName = "full";
const char* emptyName = "empty";
pthread_attr_t attr;
pthread_t tid;
pthread_mutex_t mutex1;

void initStates();
void *producer(void *param);
void *consumer(void *param);
int insert_item(buffer_item item);
int remove_item(buffer_item *item);

void initStates(){
    n = 0;                          // buffer counter
    sem_unlink(emptyName);          //make sure the semaphores are unlinked.
    sem_unlink(fullName);           //make sure the semaphores are unlinked.
    full = sem_open(fullName, O_CREAT, 0, 0);          // num of filled spots in buffer
    if (full == SEM_FAILED) {       //test to see if semaphore was successfully created.
        perror("sem_open");
        exit(1);
    }
    empty = sem_open(emptyName, O_CREAT, 0, BUFFER_SIZE);   // num of empty spots in buffer
    if (empty == SEM_FAILED) {      //test to see if semaphore was successfully created.
        perror("sem_open");
        exit(1);
    }
    pthread_mutex_init(&mutex1, NULL);  // intit mutex lock
    pthread_attr_init(&attr);       // init thread attributes
}
int insert_item(buffer_item item){
    // requires initialization of 1.mutex, 2.empty, and 3.full
    if(n < BUFFER_SIZE)
    {
        buffer[n] = item;
        n++;
        return 0;   // if successful @ inserting itme into buffer
    }
    else
    {
        return -1;  // if unsuccessful
    }
}

int remove_item(buffer_item *item){
    // requires initialization of 1.mutex, 2.empty, and 3.full
    if(n > 0)
    {
        *item = buffer[(n - 1)];
        n--;
        return 0;   // if successful @ removing OBJ from buffer and place it in item
    }
    else
    {
        return -1; // if unsuccessful
    }
}

void *producer(void *param){
    //
    // alternate between sleeping for rand time and inserting a rand int into buffer
    //
    buffer_item item;
    while(true){
        int nap_time = rand() % 6; // random int between 0 and 5
        sleep(nap_time);
        item = rand();     // insert item into buffer
        sem_wait(empty);
        pthread_mutex_lock(&mutex1);
        if(insert_item(item)){
            printf("Producers insert_item(): report error condition\n");
        }
        else{
            printf("Producer produced %d\n", item);
        }
        pthread_mutex_unlock(&mutex1);
        sem_post(full);
    }
}

void *consumer(void *param){
    //
    // alternate between sleeping and upon awaking, attempt to remove an item from buffer
    //
    buffer_item item;
    while(true){
        int nap_time = rand() % 6; // random int between 0 and 5
        sleep(nap_time);
        sem_wait(full);
        pthread_mutex_lock(&mutex1);
        if(remove_item(&item)){ // note: remove_item() param accepts *item
            printf("Consumers remove_item(); report error condition\n");
        }
        else{
            printf("Consumer consumed %d\n", item);
        }
        pthread_mutex_unlock(&mutex1);
        sem_post(empty);
    }
}

int main(int argc, const char * argv[]) {
    int nap_time, num_prod, num_con, i;
    
    /*
     * *             Section of code below is for running int Terminal               * *
     * * before runnin in terminal, comment out the variables used for XCode testing * *
     
     1. cd Directory_Where_main.cpp_resides
     2. g++ main.cpp
     3. or gcc main.cpp
     4. ./a.out main # # #
     
     */
    
   i = 0;
   do{
       if (argv[i] != NULL){
           printf("Param passed in:%s\t%d\n",argv[i], i);
           // printf("\t%d\n", i);
           i++;
       }
       if(i > 5){
           printf("\nPassed incorrect number of parameters.%d\n", i);
           printf("\nParameters needed:\n\t1. sleep duration (integer)\n\t2. num producer threads (integer)\n\t3. num consumer threads (integer)\n");
           exit(0);
       }
   }while(argv[i] != NULL);
    
    /*
     if(argc != 4){
     printf("Passed incorrect parameters.\n");
     printf("Parameters needed:\n\t1. sleep duration\n\t2. num producer threads\n\t3. num consumer threads\n");
     exit(0);
     }
     */
    
     nap_time = stoi(argv[2]);
     num_prod = stoi(argv[3]);
     num_con = stoi(argv[4]);
     printf("\n\nsleep time:\t%d\tnum producers:\t%d\tnum consumers:\t%d\n\n",nap_time, num_prod,num_con);
    // cout << "argv 1: " << nap_time << "\targv 2: " << num_prod << "\targv 3: " << num_con << endl;
    
    
    // use this for running in Xcode so you dont have to jumb between apps
    // * * ensure that the full terminal section is commented out prior to running this section * *
//     nap_time = 2;
//     num_prod = 5;
//     num_con = 5;
//     
//     cout << "creating threads" << endl;
    
    // initialize variable states and buffer
    initStates();
    // create producer threads
    for(i = 0; i < num_prod; i++){
        pthread_create(&tid, &attr, producer, NULL);
    }
    // create consumer threads
    for(i = 0; i < num_con; i++){
        pthread_create(&tid, &attr, consumer, NULL);
    }
    // sleep for a period of time
    sleep(nap_time);
    
    sem_unlink(emptyName);
    sem_unlink(fullName);
    
//    string s;
//    cin >> s;
    
    // terminate
    exit(0);
}