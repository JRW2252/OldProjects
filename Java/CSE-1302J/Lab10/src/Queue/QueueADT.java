package Queue;

// Program Name:      QueueADT.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public interface QueueADT
{
    //---------------------------------------------
    // Puts item on end of queue.
    //---------------------------------------------
    public void enqueue(Object item);
    //---------------------------------------------
    // Removes and returns object from front of queue.
    //---------------------------------------------
    public Object dequeue();
    //---------------------------------------------
    // Returns true if queue is empty.
    //---------------------------------------------
    public boolean isEmpty();
    //---------------------------------------------
    // Returns true if queue is full.
    //---------------------------------------------
    public boolean isFull();
    //---------------------------------------------
    // Returns the number of elements in the queue.
    //---------------------------------------------
    public int size();
}