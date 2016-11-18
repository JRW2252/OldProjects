
#include <iostream>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

/*
 Global variables
 */
int num_threads, n, m;
double* A, * x, * y, * globalVec;

void* pthMatVecMult(void* rank);
void startThreads();

int main(int argc, const char * argv[]) {
    printf("Running this program will not check for incorrect input.\n"
           "You will need to use a number of threads that will divide evenly among the matrix size.\n"
           "EX: 2 threads for a 2x2 matrix, or 4 threads for a 16x16 matrix. \n\t- - - KEEP IT SIMPLE. - - -\n\n");
    printf("Enter number of threads to use: ");
    cin >> num_threads;
    startThreads();
    
    
    return {0};
}

void startThreads(){
    long rank =0;
    pthread_t threads[num_threads];
    globalVec = malloc(sizeof(double)*(m*n));
}