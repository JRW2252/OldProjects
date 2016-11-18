/*
* File: mpi_merge_sort.c
* Created by James Williams on 11/14/15.
*
* Purpose:
* Each process should use a random number generator to create a local list of n/comm_sz ints.
* Each process should then sort its local list, and process 0 should gather and print the local lists.
* Then the processes should use tree-structured communication to merge the global list onto process 0,
* which prints the result.
* Compile: mpicc mpi_merge_sort.c -o MPI_MergeSort
* Execute: mpiexec -n <# nodes or processors> MPI_MergeSort
*/
/* Includes */
#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
/* Includes */

/* Prototypes */
void merge_sort(int*, int*, int, int);
void merge(int*, int*, int, int, int);
/* Prototypes */

int main(int argc, char *argv[]) {
    int *main_arr;
    int *local_arr;
    int i, my_rank, num_nodes, keys;

    keys = 1600000;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &num_nodes);
    MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);

    // allocate for each nodes array
    local_arr = malloc((keys/num_nodes)*sizeof(int));
    // set up random gen
    unsigned int seed;
    seed = time(NULL)+my_rank;
    srand(my_rank);

    for(i = 0; i < (keys/num_nodes); i++){
        local_arr[i] = (rand_r(&seed)%RAND_MAX);
        
        /********************************************
         * do not need to worry about race conditions
         */
       // printf("i\t%d\n", local_arr[i]);
    }

    if(my_rank == 0){
        main_arr = malloc(keys*sizeof(int));
        
        /********************************************
         * missing a large part of the algorithm
         */
    }

    MPI_Finalize();
    return 0;
}

void merge_sort(int* one, int* two, int left, int right){
    int mid;
    if(left < right+1){
        mid = (left+right)/2;
        merge_sort(one, two, left, mid);
        merge_sort(one, two, mid+1, right);
        merge(one, two, left, mid, right);
    }
} /* merge_sort */

void merge(int* one, int* two, int left, int mid, int right){
    int i, j, k, l;
	i = left; j = left; k = mid + 1;

	while((i <= mid) && (k <= right)) {
		if(one[i] <= one[k]) {
			two[j] = one[i];
			i++;
        }else {
			two[j] = one[k];
			k++;
        }
        j++;
    }

	if(mid < i) {
		for(l = k; l <= right; l++) {
			two[j] = one[l];
			j++;
        }
    } else {
		for(l = i; l <= mid; l++) {
			two[j] = one[l];
			j++;
        }
    }

	for(l = left; l <= right; l++) {
		one[l] = two[l];
    }
} /* merge */

/*******************************************************
 * 18/50 Please see my comments in your code. 
 */
