/*
 
 approx_pi_darts.cpp
 Parallel_HW5
 Created by James Williams on 9/22/15.
 
 Purpose: simulate throwing darts within a square at random locations.
 the darts will approximate the value of pi, by calculating the
 total darts in circle/total darts thrown.
 
 The program will be using pthreads and will use the sitmo_prng_engine to produce
 all random numbers.

*/

//#include <random>
//#include <pthread.h>
//#include <iostream>
//#include <stdlib.h>
//#include <stdio.h>
//#include "timer.h"
//
//int main(){
//    
//    std::random_device rd;
//    std::mt19937 mt(rd());
//    std::uniform_int_distribution<int> dist(0,99);// inclusive
//    for (int i = 0; i < 1024; ++i) {
//        std::cout << dist(mt) << " ";
//    }
//}

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define NUM_THREADS 5



void *throwDarts(void *arg)
{
    pthread_exit((void*) 0);
}

int main ()
{
    pthread_t* thread_handles;
    
    for(long i=0; i < NUM_THREADS; i++){
        pthread_create(&thread_handles[i], NULL, throwDarts, (void *)i);
        printf("Created thread: %ld\n", i);
    }
    
    for(int i=0; i < NUM_THREADS; i++)
        pthread_join(thread_handles[i], NULL);
}