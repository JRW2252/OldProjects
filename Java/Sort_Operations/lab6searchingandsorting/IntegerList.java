package lab6searchingandsorting;

// Program Name:      IntegerList.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Lab#6
// Due Date:          07/10/2013
// Purpose:           Program purpose / description         
 import java.util.*;

public class IntegerList
{
    int[] list; //values in the list
 
    //------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size.  All elements default to value 0.
    //------------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
    }
 
 
    //------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    //------------------------------------------------------------
    public void randomize()
    {
        int max = list.length;
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * max) + 1;
    }
 
 
    //------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    //------------------------------------------------------------
    public void fillSorted()
    {
        for (int i=0; i<list.length; i++)
            list[i] = i + 2;
    }
 
 
    //------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    //------------------------------------------------------------
    public String toString()
    {
        String s = "";
        for (int i=0; i<list.length; i++)
           s += i + ":\t" + list[i] + "\n";
        return s;
    }
 
 
    //------------------------------------------------------------
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list.  Returns -1
    // if target does not appear in the list
    //------------------------------------------------------------
    public int linearSearch(int target)
    {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
            if (list[i] == target)
                location = i;
        return location;
    }
 
   
    //------------------------------------------------------------
    // sortIncreasing  -- uses selection sort
    //------------------------------------------------------------
    public void sortIncreasing()
    {
        int min;
 
        for (int i = 0; i < list.length - 1; i++)
        {
            min = i; 
            for(int j = i+1; j < list.length; j++)
            {
                if(list[j] < list[min])
                    min = j; 
            }
            if(i != min && list[min] < list.length)
            {
                int temp = list[min];
                list[min] = list[i];
                list[i] = temp; 
            }
        }
    }
    
    public void sortDecreasing()
    {
        int j, temp; 
        for(int i = 0; i < list.length; i++)
        {
            j = i; 
            temp = list[i];
            
            while(j != 0 && list[j - 1] < temp)
            {
                list[j] = list[j - 1];
                j--; 
            }
            list[j] = temp; 
        }
    }
   
    //------------------------------------------------------------
    //Binary search  -- 
    //------------------------------------------------------------
       public int binarySearch(int find)
      {
          int start = 0, end = list.length-1, mid;
          while (end >= start)
          {
              mid = (start + end)/2;
              if(list[mid] == find)
              {
                  return mid; 
              }
              else if (list[mid] > find)
              {
                  end = mid -1; 
              }
              else
              {
                  start = mid + 1; 
              }
          }
          return -1; 
      }
    //------------------------------------------------------------
    //Enhanced bubble sort -- 
    //------------------------------------------------------------
       public void enhancedBubbleSort()
      {
      // enhanced bubble sort
       boolean unsorted = true;
      
       while (unsorted)
         {
            int max = list.length-1;
            unsorted = false;
            for (int i = 0; i < max; i++)
            {
               if (list[i] > list[i+1])
               {
                  unsorted = true;
                  arraySwap( i, i+1);
                  max -= 1;
               }
            }
         }
      
      }  
       
       public void arraySwap( int first_index, int second_index) 
       {
         int first = list[first_index];
         int second =list[second_index];
     
         list[first_index] = second;
         list[second_index] = first; 
         
//         for (int i = 0; i < list.length; i++)
//         {
//            if (i == first_index) {
//               list[i] = second;
//            } 
//           else if (i == second_index)
//            {
//               list[i] = first;
//            } 
                    
      }  
}