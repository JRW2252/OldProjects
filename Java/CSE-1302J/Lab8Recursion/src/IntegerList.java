// Program Name:      IntegerList.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class IntegerList
{
    int[] list; //values in the list
 
    // ------------------------------------
    //   Creates a list of the given size
    // ------------------------------------
    public IntegerList (int size)
    {
      list = new int[size];
    }
 
    // --------------------------------------------------------------
    //   Fills the array with integers between 1 and 100, inclusive
    // --------------------------------------------------------------
    public void randomize()
    {
      for (int i=0; i< list.length; i++)
          list[i] = (int)(Math.random() * 100) + 1;
    }
 
    // ----------------------------------------
    //   Prints array elements with indices
    // ----------------------------------------
    public void print()
    {
      for (int i=0; i<list.length; i++)
          System.out.println(i + ":\t" + list[i]);
    }
 
    // ------------------------------------------------------------------
    //   Returns the index of the first occurrence of target in the list.
    //   Returns -1 if target does not appear in the list.
    // ------------------------------------------------------------------
    public int linearSearch(int target)
    {
      int location = -1;
      for (int i=0; i<list.length && location == -1; i++)
          if (list[i] == target)
            location = i;
      return location;
    }
 
    // -----------------------------------------------------------------
    //   Returns the index of an occurrence of target in the list, -1
    //   if target does not appear in the list.
    // -----------------------------------------------------------------
    public int linearSearchRec(int target)
    {
      return linearSearchR (target, 0);
    }
 
    // -----------------------------------------------------------------
    //   Recursive implementation of the linear search - searches
    //   for target starting at index lo.
    // ----------------------------------------------------------------- 
    private int linearSearchR (int target, int lo)
    {
      if(lo == list.length)
        return -1;
      if(target == list[lo])
          return lo; 
      return linearSearchR(target, lo + 1);
    }
 
    // ------------------------------------------------------------------
    //   Returns the index of the occurrence of target in the list.
    //   Returns -1 if target does not appear in the list.
    // ------------------------------------------------------------------
    public int binarySearch(int target)
    {
      // fill in code for iterative binary search
      int start = 0, end = list.length, middle;
      while(end >= start)
      {
        middle = (start + end)/2;
        if(list[middle] == target)
          return middle;
        else if(list[middle]>target)
          end = middle-1; 
        else
          start = middle+1;
      }
      return -1;
    }
 
// -----------------------------------------------------------------
    //   Returns the index of an occurrence of target in the list, -1
    //   if target does not appear in the list.
    // -----------------------------------------------------------------
    public int binarySearchRec(int target)
    {
      return binarySearchR (target, 0, list.length-1);
    }
 
    // -----------------------------------------------------------------
    //   Recursive implementation of the binary search algorithm.
    //   If the list is sorted the index of an occurrence of the
    //   target is returned (or -1 if the target is not in the list).
    // ----------------------------------------------------------------- 
    private int binarySearchR (int target, int lo, int hi)
    {
      int index = (lo + hi)/2;
      if(lo <= hi)
      {
        if(list[index]==target)
          return index; 
        else if(list[index]>target)
          return binarySearchR(target, lo, index-1);
        else 
          return binarySearchR(target, index+1, hi);
      }
      else
        return -1;
    }
 
 
 
    // ------------------------------------------------------------------------
    //  Sorts the list into ascending order using the selection sort algorithm.
    // ------------------------------------------------------------------------
    public void selectionSort()
    {
      int minIndex;
      for (int i=0; i < list.length-1; i++)
          {
            //find smallest element in list starting at location i
            minIndex = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] < list[minIndex])
                      minIndex = j;
 
            //swap list[i] with smallest element
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
          }
    }
}