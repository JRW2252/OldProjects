package ClassCodeNotes;

// Program Name:      Main.java

import java.util.Random;

// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

public class Main 
{
  private static final long MEGABYTE = 1024L * 1024L;
    public static void main(String[] args) 
    {
      // Stacks and Queues
      // Last in, first out
      // basic methods: push, pop, peek
      // push: insert at the beginning of the linked list
      // pop: delete the first item in the linked list
      // peek: retrunt the first item of the list without deleting it
      //  
      // Merge Sort 
      // Quick Sort
      
      Random r = new Random();
      int [] array = new int[10000000];
      for(int i = 0; i < array.length; i++)
        array[i]= r.nextInt(100000000);
      
      sort(array);
      System.out.println();
      
      System.out.println("Sort Complete");
      Runtime runtime = Runtime.getRuntime();
          runtime.gc();
          long mem = runtime.totalMemory()-runtime.freeMemory();
          System.out.println("Used memory: "+mem+" bytes");
          System.out.println("Used memory: "+byteToMeg(mem)+" megabytes");
    }
    
//    // Method used in quick sort
//    static int partition(int arr[], int left, int right)
//    {
//      int i = left, j = right;
//      int tmp;
//      int pivot = arr[(left + right) / 2];
//     
//      while (i <= j) 
//      {
//            while (arr[i] < pivot)
//                  i++;
//            while (arr[j] > pivot)
//                  j--;
//            if (i <= j) 
//            {
//                  tmp = arr[i];
//                  arr[i] = arr[j];
//                  arr[j] = tmp;
//                  i++;
//                  j--;
//            }
//      }
//     
//      return i;
//    }
//    // quick sort method (recursive)
//    static void quickSort(int arr[], int left, int right) 
//    {
//      int index = partition(arr, left, right);
//      if (left < index - 1)
//            quickSort(arr, left, index - 1);
//      if (index < right)
//            quickSort(arr, index, right);
//    }
//    
//    public static int getPivotIdx(long arr[], int beginIdx, int len) 
//    {
//     return beginIdx+len/2;
//    }

      public static int[] numbers;
      public static int number;

      public static void sort(int[] values) 
      {
        // check for empty or null array
        if (values ==null || values.length==0){
          return;
        }
        numbers = values;
        number = values.length;
        quicksort(0, number - 1);
      }

      public static void quicksort(int low, int high) 
      {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) 
        {
          // If the current value from the left list is smaller then the pivot
          // element then get the next element from the left list
          while (numbers[i] < pivot) 
          {
            i++;
          }
          // If the current value from the right list is larger then the pivot
          // element then get the next element from the right list
          while (numbers[j] > pivot) 
          {
            j--;
          }

          // If we have found a values in the left list which is larger then
          // the pivot element and if we have found a value in the right list
          // which is smaller then the pivot element then we exchange the
          // values.
          // As we are done we can increase i and j
          if (i <= j) 
          {
            exchange(i, j);
            i++;
            j--;
          }
        }
      // Recursion
      if (low < j)
        quicksort(low, j);
      if (i < high)
        quicksort(i, high);
      }

      public static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
      }
    public static long byteToMeg(long bytes) 
    {
    return bytes/MEGABYTE;
    }
}