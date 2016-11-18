//============================================================================
// Name        : MonteCarlo.cpp
// Author      : Ryan Williams
// Version     :
// Copyright   : 
// Description : Hello World in C++, Ansi-style
//============================================================================

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

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <random>
#include <iostream>

#define NUM_THREADS 5

void *throwDarts(void *arg)
{
    long my_rank = (long) arg;  /* Use long in case of 64-bit system */
    printf("Hello from thread %ld of %d\n", my_rank, NUM_THREADS);
}

int main ()
{
    pthread_t* thread_handles;
    thread_handles = (pthread_t *) malloc(NUM_THREADS*sizeof(pthread_t));
//    std::random_device rd;
//    std::mt19937 mt(rd());
//    std::uniform_int_distribution<unsigned int>dist(INT32_MIN, INT32_MAX);
//    for (int i = 0; i < 1024; ++i) {
//        std::cout << dist(mt) << std::endl;
//    }

    for(long i=0; i < NUM_THREADS; i++){
        pthread_create(&thread_handles[i], NULL, throwDarts, (void *)i);
        printf("\tCreated thread: %d of %d\n", i, NUM_THREADS);
    }

    for(int i=0; i < NUM_THREADS; i++) {
        printf("Joining thread: %d\n", &thread_handles[i]);
        pthread_join(thread_handles[i], NULL);
    }
    free(thread_handles);
}
