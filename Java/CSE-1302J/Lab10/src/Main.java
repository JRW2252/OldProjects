
import Queue.QueueADT;

// Program Name:      Main.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Lab#10
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

public class Main 
{
    public static void main(String[] args)
    {
      QueueADT q = new ArrayQueue();
      System.out.println("\nEnqueuing 10, 20, 30, 40, 50:");
      q.enqueue("10");
      q.enqueue("20");
      q.enqueue("30");
      q.enqueue("40");
      q.enqueue("50");
      System.out.println(q+"\nDequeuing four...");
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println(q+"\nEnqueuing 60, 70, 80, 90, 100:");
      q.enqueue("60");
      q.enqueue("70");
      q.enqueue("80");
      q.enqueue("90");
      q.enqueue("100");
      System.out.println("\nHere's the queue: " + q);
      System.out.println(q+"\nEnqueuing chocolate, cake, pie, truffles:");
      q.enqueue("chocolate");
      q.enqueue("cake");
      q.enqueue("pie");
      q.enqueue("truffles");
      System.out.println("\nHere's the queue: " + q);
      System.out.println("It contains " + q.size() + " items.");
      System.out.println("\nDequeuing two...");
      System.out.println(q.dequeue());
      System.out.println(q.dequeue());
      System.out.println("\nEnqueuing cookies, profiteroles, mousse, cheesecake, ice cream:");
      q.enqueue("cookies");
      q.enqueue("profiteroles");
      q.enqueue("mousse");
      q.enqueue("cheesecake");
      q.enqueue("ice cream");
      System.out.println("\nHere's the queue again: " + q);
      System.out.println("Now it contains "  + q.size() + " items.");
      System.out.println("\nDequeuing everything in queue");
      while (!q.isEmpty())
          System.out.println(q.dequeue());
      System.out.println("\nNow it contains "  + q.size() + " items.");
      if (q.isEmpty())
          System.out.println("Queue is empty!");
      else
          System.out.println("Queue is not empty -- why not??!!");
    }
}
