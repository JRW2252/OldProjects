//
//  partthree.cpp
//

#include <stdio.h>
#include <iostream>
#include <time.h>
#include <stdlib.h>
#include <utility>
#include <set>
#include <math.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <fstream>

using namespace std;

int partition(int* input, int p, int r);
void quickSort(int arr[], int left, int right);
void selectSort(int arr[], int n);
void merge_sort (int array[], int size);
int  merge  (int list1[ ] , int size1 , int list2[ ] , int size2 , int list3[ ]);
void bubbleSort(int array[], int arrSize);
void shellsort(int array[], int arrSize);
void insertion_sort (int array[], int arrSize);

int arSize = 1000000;
int arrNums[1000000];

int main(void)
{
    string filePath;
    filePath = ("/Users/kg4zlk/Downloads/Project3/numbers.txt");
    //string filePath = ("/Users/jameswilliams/Dropbox/School By Term/Spring 15/Operating Syst./Group Projects/Project3/numbers.txt");
    string numberIn;
    
    ifstream myfile (filePath);
    
    cout << "reading file" << endl;
    
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
        cout << "could not open file: " << endl;
    
    cout << "sorting numbers" << endl;
    
    int dividedSize = arSize / 6;
    int nextArrStart = 0;
    
    
    
    //quickSort(arrNums, 0, arSize);
    //selectSort(arrNums, arSize);
    //vector<int> sortedVec = merge_sort(vec);
    //bubbleSort(arrNums, arSize);
    //shellsort(arrNums, arSize);
    insertion_sort (arrNums, arSize);
    
    cout << "done." << endl;
    
    for (int i = 0; i < 1000; i++)
    {
        cout << arrNums[i] << endl;
    }
}

int partition(int* input, int p, int r)
{
    int pivot = input[r];
    
    while ( p < r )
    {
        while ( input[p] < pivot )
            p++;
        
        while ( input[r] > pivot )
            r--;
        
        if ( input[p] == input[r] )
            p++;
        else if ( p < r )
        {
            int tmp = input[p];
            input[p] = input[r];
            input[r] = tmp;
        }
    }
    
    return r;
}

void quicksort(int* input, int p, int r)
{
    if ( p < r )
    {
        int j = partition(input, p, r);
        quicksort(input, p, j-1);
        quicksort(input, j+1, r);
    }
}

void selectSort(int arr[], int n)
{
    //pos_min is short for position of min
    int pos_min,temp;
    
    for (int i=0; i < n-1; i++)
    {
        pos_min = i;//set pos_min to the current index of array
        
        for (int j=i+1; j < n; j++)
        {
            
            if (arr[j] < arr[pos_min])
                pos_min=j;
            //pos_min will keep track of the index that min is in, this is needed when a swap happens
        }
        
        //if pos_min no longer equals i than a smaller value must have been found, so a swap must occur
        if (pos_min != i)
        {
            temp = arr[i];
            arr[i] = arr[pos_min];
            arr[pos_min] = temp;
        }
    }
}

void merge_sort (int array[], int size)
{
    int temp[size];
    int mid, i;
    if (size < 2) {
        return;
    }
    else {
        mid = size / 2;
        merge_sort(array, mid);
        merge_sort(array + mid, size - mid);
        merge (array, mid, array + mid, size - mid, temp);
        for (i = 0; i < size; i++) {
            array[i] = temp[i];
        }
    }
}

int  merge  (int list1[ ] , int size1 , int list2[ ] , int size2 , int list3[ ])
{
    int i1, i2, i3;
    if (size1+size2 > arSize) {
        return false;
    }
    i1 = 0; i2 = 0; i3 = 0;
    /* while both lists are non-empty */
    while (i1 < size1 && i2 < size2) {
        if (list1[i1] < list2[i2]) {
            list3[i3++] = list1[i1++];
        }
        else {
            list3[i3++] = list2[i2++];
        }
    }
    while (i1 < size1) {
        /* copy remainder of list1 */
        list3[i3++] = list1[i1++];
    }
    while (i2 < size2) {
        /* copy remainder of list2 */
        list3[i3++] = list2[i2++];
    }
    return true;
}

void bubbleSort(int array[], int arrSize)
{
    bool swapped = true;
    int j = 0;
    int tmp;
    while (swapped) {
        swapped = false;
        j++;
        for (int i = 0; i < arrSize - j; i++) {
            if (array[i] > array[i + 1]) {
                tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                swapped = true;
            }
        }
    }
}

void shellsort(int array[], int arrSize)
{
    int gap, i, j, temp;
    
    for (gap = arrSize / 2; gap > 0; gap /= 2)
        for (i = gap; i < arrSize; i++)
            for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap)
            {
                temp = array[j];
                array[j] = array[j + gap];
                array[j + gap] = temp;
            }
}

void insertion_sort (int array[], int arrSize)
{
    int j, temp;
    
    for (int i = 0; i < arrSize; i++){
        j = i;
        
        while (j > 0 && array[j] < array[j-1]){
            temp = array[j];
            array[j] = array[j-1];
            array[j-1] = temp;
            j--;
        }
    }
}

void *thr_func1(void *tid) {
    if(tid == 0)
        quickSort(arrNums, 0, 99);
    else {
        selectSort(arrNums, 100, 199);
    }
    //pthread_exit(NULL);
    return 0;
}

void *thr_func2(void* arg)
{
    if (arg == 0)
        merge_sort(arrNums, arSize);
    else
        bubbleSort(arrNums, arSize);
    
    return 0;
}

void *thr_func3(void* arg)
{
    if (arg == 0)
        shellsort(arrNums, arSize);
    else
        insertion_sort(arrNums, arSize);
    return 0;
}
