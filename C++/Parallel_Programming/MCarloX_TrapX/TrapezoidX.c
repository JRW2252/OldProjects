/*
 Project:    trapezoid using mpi and openmp
 File:       TrapezoidX.c
 Created By: James Williams
 Date:       12/03/15.

 Compile:    mpicc TrapezoidX.c -fopenmp -Wall -o TrapezoidX
 Usage:      mpiexec -n <# nodes or processors> TrapezoidX
 */

/* includes */
#include <stdio.h>
#include <mpi.h>
#include <omp.h>
/* includes */

/* prototypes */
double trap_rule(double, double, int, double);
double f(double);
/* prototypes */

int main(int argc, char * argv[]) {
    /* variables */
    double left, right, shift;
    double local_area, total_area, local_left, local_right;
    int my_rank, num_nodes, n_divs, local_divs;
    /* variables */

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &num_nodes);
    MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    
    n_divs = 160; left = 0.0; right = 10.0;
    shift = (right-left)/num_nodes;
    local_divs = n_divs/num_nodes; 
    local_left = my_rank * shift; 
    local_right = local_left + shift; 
    local_area = trap_rule(local_left, local_right, local_divs, shift);
    
    printf("Section: %d  ", 1);
    printf("My Rank: %d  ", my_rank);
    printf("Locals: %f -> %f -> %d --> ",local_left, local_right, local_divs);
    printf("Area: %f\n", local_area);

    MPI_Reduce(&local_area, &total_area, 1, MPI_DOUBLE,
                   MPI_SUM,0, MPI_COMM_WORLD);

    if(my_rank == 0){
        printf("Total Area: %f\n", total_area);
    } 

    MPI_Finalize();
    return 0;
} /* main */


double trap_rule(double l, double r, int n, double dx){
    double f_area;
    double x = l;
    int i;

    f_area = (f(l)+f(r))/2;

    #pragma omp parallel for
    
    /*****************************************
     * This means that every thread will be doing
     * this same calculation.  You want to split
     * the calculation up between threads.
     */
    for (i = 1;  i <= n-1; i++) {
        x = l+(i*dx);
        
        /*************************************
         * This is your problem.  dx is the length
         * of the interval that needs to be subdivided
         * by each thread
         */
        f_area += f(x);
    }

    f_area *= dx;
    return f_area;

} /* trap_rule */

double f(double x){
    return x*x;
} /* f */


/*******************************************
 * 36/50 Please see my comments in your code. 
 */
