//  main.cpp
//  Created by James Williams on 11/2/15.
//  Compile: g++ -std=c++0x -Wall -fopenmp -oGausElimOMP gaussian_elimination_omp.cpp
//  Usage:   ./CausElimOMP <int matrix size> <int 1 = print arrays, 0 = no printing>

// includes
#include <random>
#include <omp.h>
#include "timer.h"
#include <iostream>
#include <sstream>
#include <string>
// includes

using namespace std;

// prototypes
void fill_matrix(double**, int, int);
void fill_vals(double*, int);
void print_matrix(double**, double*, int, int);
void gaus_elim(double**, double*, int, int);
void gaus_elim_omp(double**, double*, int, int);
//void gaus_column(double**, double*, double*, int, int);
//void gaus_row(double**, double*, double*, int, int);
// prototypes

int main (int argc, const char * argv[]) {
    double **A, *B;
    int rows, cols, i, print_arrs;
    if(argc != 3) {
        printf ("Argc = %d \n", argc);
        printf ("Argc required = 3\n");
        printf ("Argv[1] = matrix size\n");
        printf ("Argv[2] = print array on(1)/off(0)\n\n");
        return 0;
    } else {
        rows = stoi(argv[1]);
        print_arrs = stoi(argv[2]);
    }
    /*
    rows = 15;
    cols = 15;
    */
    double start, finish, pStart, pFinish;

    GET_TIME(pStart);                   // start program timer
    // printf("Enter the number of rows & columns: ");
    // cin >> rows;

    cols = rows;
    printf("\n");

    A = new double* [rows];

    for (i = 0; i < rows; i++) {
        A[i] = new double[cols];
    }

    B = new double [rows];
    double *b = new double [rows];
    for(int l = 0; l < rows; l++)
        b[l] = 0;

    fill_matrix(A, rows, cols);         // fills matrix with random doubles
    fill_vals(B, rows);                 // fills values with random doubles
    if(print_arrs == 1)
        print_matrix(A, B, rows, cols); // print matrix and values

    GET_TIME(start);                    // start computation timer
    gaus_elim(A, B, rows, cols);     // run gaus elim on A & B
    // gaus_column(A, B, b, rows, cols);  // run gaus column oriented
    // gaus_row(A, B, b, rows, cols);     // run gaus row oriented
    GET_TIME(finish);                   // stop computation timer
    if(print_arrs == 1)
        print_matrix(A, B, rows, cols);
    printf("Time elapsed for computation of %d x %d matrix = %f seconds.\n", rows, cols, finish-start);
    delete A;
    delete B;

    GET_TIME(pFinish);                  // stop program timer
    printf("Total run time = %f seconds.\n\n", pFinish - pStart);

    return 0;
} /* main */

void fill_matrix(double **p, int r, int c){
    int i, j;
    random_device rd;
    mt19937 mt(rd());

    for (i = 0; i < r; i++) {
        for (j = 0; j < c; j++) {
            p[i][j] = (mt()%RAND_MAX/(double)(100000000));
        }
    }
} /* fill_matrix */


void fill_vals(double *p, int r){
    int i;
    random_device rd;
    mt19937 mt(rd());
    for (i = 0; i < r; i++) {
        p[i] = (mt()%RAND_MAX/(double)(100000000));
    }
} /* fill_vals */

void print_matrix(double **pp, double *p, int r, int c){
    int i, j;

    printf("\nPrinting Matrix: \n");
    for (i = 0; i < r; i++) {
        printf("[");
        for (j = 0; j < c; j++) {
            printf("%*.1f ",4, pp[i][j]);
        }
        printf("|%*.1f",4, p[i]);
        printf("]\n");
    }
    printf("\n");
} /* print_matrix */

void gaus_elim(double** pp, double* p, int r, int c){
    int i, j, k;
    double pivot, factor;
    // #pragma omp parallel for
    for (i = 0; i < r; i++) {
        pivot =  pp[i][i];
        for (j = 0; j < r; j++)
            pp[i][j] = pp[i][j]/pivot;
        p[i] = p[i]/pivot;
        for (k = 0; k < r; k++) {
            if(i != k){
                /* print_matrix(pp, p, r, c); */
                factor = pp[k][i];
                for (j = 0; j < r; j++)
                    pp[k][j] -= factor*pp[i][j];
                p[k] -= factor*p[i];
            }
        }
    }

} /* gaus_elim */

void gaus_column(double **pp, double *p, double *b, int r, int c){
    int i, j;

    #pragma omp parallel
    for (i = 0; i < r; i++) {
        p[i] = b[i];
    }

    for (j = r-1; j >= 0; j--) {
        p[j] /= pp[j][j];
        #pragma omp parallel
        for (i = 0; i < j; i++) {
            p[i] -= pp[i][j] * p[j];
        }
    }
} /* gaus_column */

void gaus_row(double **pp, double *p, double *b, int r, int c){
    int i, j;
    for (i = r-1; i >= 0; i--) {
        p[i] = b[i];

        #pragma omp parallel
        for (j = r+1; j < r; j++){
            p[i] -= pp[i][j]*p[j];
        }
        p[i] /= pp[i][i];
    }
} /* gaus_row*/
