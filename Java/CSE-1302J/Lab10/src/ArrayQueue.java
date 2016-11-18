import Queue.QueueADT;

// Program Name:      ArrayQueue.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class ArrayQueue implements QueueADT
{
    private int DEFAULT_SIZE = 5;
    private Object[] elements;
    private int numElements;
    private int front, back;
    //---------------------------------------------
    // Constructor; creates array of default size.
    //---------------------------------------------
    public ArrayQueue()
    {
      elements = new Object[DEFAULT_SIZE]; 
      numElements = 0;
      front = 0; 
      back = 0;
    }
    //---------------------------------------------
    // Puts item on end of queue.
    //---------------------------------------------
    @Override
    public void enqueue(Object item)
    {
      elements[back]=item;
      back++;
      numElements++; 
      if(back%DEFAULT_SIZE==0 && numElements>0)
        back = 0; 
      if(isFull())
      {
        increaseSize();
//        elements[numElements]=item;
//        back ++;
//        numElements++;
      }
    }
    //---------------------------------------------
    // Removes and returns object from front of queue.
    //---------------------------------------------
    public Object dequeue()
    {
      if(!isEmpty())
      {
      Object toDelete = elements[front];
      front++;
      numElements--;
      if(front%DEFAULT_SIZE==0 && numElements > 0)
        front = 0;
      return toDelete;
      }
      return null;
    }
    //---------------------------------------------
    // Returns true if queue is empty.
    //---------------------------------------------
    public boolean isEmpty()
    {
      if(numElements != 0)
        return false;
      else return true; 
    } 
    //---------------------------------------------
    // Returns true if queue is full, but it never is.
    //---------------------------------------------
    public boolean isFull()
    {
      if(DEFAULT_SIZE == numElements)
        return true; 
      else 
        return false; 
    }
    //---------------------------------------------
    // Returns the number of elements in the queue.
    //---------------------------------------------
    public int size()
    {
      return numElements;
    }
    //---------------------------------------------
    // Returns a string containing the elements of the queue
    // from first to last
    //---------------------------------------------
    public String toString()
    {
      String result = "\n";
      for (int i = front, count=0; count < numElements;
                   i=(i+1)%elements.length,count++)
      result = result + elements[i]+ "\n";
      return result;
    }
    private void increaseSize()
    {
      Object [] temp = new Object [ 2 * elements.length];
      for ( int i = 0; i < elements.length; i++) 
      {
        temp [i] = elements [ (i + front)% elements.length]; 
      }
      elements = temp; 
      front = 0; 
      back = numElements; 
      DEFAULT_SIZE *=2;
    }
}