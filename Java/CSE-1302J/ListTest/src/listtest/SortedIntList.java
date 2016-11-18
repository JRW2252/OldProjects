package listtest;

// Program Name:      SortedIntList.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class SortedIntList
{
    protected int[] list;
    protected int numElements = 0;
    //-------------------------------------------------------------
    // Constructor -- creates an integer list of a given size.
    //-------------------------------------------------------------
    public SortedIntList(int size)
    {
      list = new int[size];
    }
 
    //-------------------------------------------------------------
    // Adds an integer to the list in a sorted fashion.
    //-------------------------------------------------------------
    public void add(int value)
    {
    if (numElements == list.length)
        System.out.println("Can't add, list is full");
    else
    {
        int insertAt = 0;
        boolean found = false; 
        for(int i = 0; i < numElements; i++)
        {
            if(value < list[i])
            {
                found = true; 
                insertAt = i; 
                break; 
            }
        }
        if(!found)
        {
            insertAt = numElements;
        }    
        //if(value > list[])
        //    {
                for(int i = numElements-1; i >= insertAt; i--)
                {
                    if(value < list[i])
                    {
                        list[i+1] = list[i]; 
                    }
                }
           // }
        list[insertAt] = value;
        numElements++; 
    }
//        numElements++;
}
        
    
    private void increaseSize()
    {
        int[] temp = new int[numElements+1];
        for(int i =0; i < list.length; i++)
        {
            temp[i]=list[i];
        }
        list = temp; 
        temp = null;
        numElements = list.length;
    }
 
    //-------------------------------------------------------------
    // Returns a string containing the elements of the list with their
    // indices.
    //-------------------------------------------------------------
    public String toString()
    {
      String returnString = "";
      for (int i=0; i<numElements; i++)
          returnString += i + ": " + list[i] + "\n";
      return returnString;
    }
}
