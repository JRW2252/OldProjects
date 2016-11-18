/*
 Project:    mpi_monte_carlo
 File:       mpi_monte_carlo.cpp
 Created By: James Williams
 Date:       11/14/15.

 Purpose:    Estimate Pi by simulation of throwing darts at a dart board.
             Program will use MPI for distributed computing across nodes.

             1. Process 0 should read in the total number of tosses and
             broadcast it to the other processes.
             2. Use MPI Reduce to find the global sum of the local variable number
             in circle, and have process 0 print the result.

 Note:       num_darts was somehow being altered mid program, so the variable
             was reset to the original number of darts to be thrown right 
             before process 0 calculates pi.      

 Compile:    mpicc MCarloX.c -fopenmp -o MCarloX
 Usage:      mpiexec -n <# nodes or processors> MPI_MCarlo
*/

/* prototype */
double calc_pi(long long, long long);
/* prototype */

/* include */
#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
#include <omp.h>
/* include */

int main(int argc, char * argv[]) {
    long long i, local_darts, local_hits, total_hits, num_darts = 16000000;
    double pi, x, y;
    int my_rank, num_nodes;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &num_nodes);
    MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);

    // if (argc <=1) {
    //   MPI_Finalize();
    //   exit(-1);
    // }
    // scanf(argv[1],"%d", num_nodes);
    // 653331 
    
    local_darts = num_darts/num_nodes;
    
    // if(my_rank == 0){
    //   printf("num_nodes: %d\n", num_nodes );
    //   printf("num_darts: %lld\n", num_darts );
    //   printf("my rank: %d\tlocal_darts: %lld\n", my_rank, local_darts );
    // }else{
    //   printf("my rank: %d\tlocal_darts: %lld\n", my_rank, local_darts );
    // }
    
    
    
    if(my_rank == 0){
        local_darts = (num_darts-(num_nodes-1)*local_darts);
        
        /***************************************************
         * I do not understand this calculation.  You have
         * already correctly calculated local darts.
         */
    }

    unsigned int seed;
    seed = time(NULL)+my_rank;
    total_hits =0; local_hits = 0;
    srand(my_rank);

    #pragma omp parallel for \
      reduction(+: local_hits) private (i, x, y)
    for (i = 0; i < local_darts; i++){
        x = ((double) rand_r(&seed)/RAND_MAX*(1.0 - 0.0) + 0.0);
        y = ((double) rand_r(&seed+num_nodes)/RAND_MAX*(1.0 - 0.0) + 0.0);
        if((x*x) + (y*y) <= 1) {
            ++local_hits;
        }
    } 
    printf("my rank: %d --> local_hits: %lld\n",my_rank, local_hits );
    MPI_Reduce(&local_hits, &total_hits, 1, MPI_LONG_LONG, MPI_SUM, 0, MPI_COMM_WORLD);

    /* see note at top */ 
    num_darts = 16000000;
    
    if(my_rank == 0){
      pi = calc_pi(num_darts, total_hits);
      printf("\n\nEvaluation of Pi\nTotal darts = %lld\t", num_darts);
      printf("Total Hits = %lld\t", total_hits);
      printf("Pi = %f\n", pi);
    }

    MPI_Finalize();
    return 0;
}

double calc_pi(long long n, long long m){
    double my_pi =  (4.0 * (double)m / (double)n);
    return my_pi;
} /* calc_pi */

/********************************************
 * 50/50 Please see my comment in your code. 
 */
