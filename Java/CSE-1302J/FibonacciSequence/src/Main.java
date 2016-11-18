
import static java.util.Collections.list;
import java.util.Scanner;

// Program Name:      Main.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# 6
// Due Date:          25/11/2013
// --------------------------------------------------------------------------
// Purpose:           Running two seperate methods to solve the same problem.
// The first option solves a fibonacci sequence using an iterative method, 
// and the second usning a recursive method. Each method is to be ran for the
// number n=40, then display the time lapse (stopwatch) for each method to 
// produce their results. Then compare the time differences between the two 
// methods runs. Explain why one method takes more time than the other.......
// --------------------------------------------------------------------------

                   
public class Main 
{
    private static final long MEGABYTE = 1024L * 1024L;
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int choice;
      // Using a do-while loop instead of a switch for the user choices
      do {
        long start, end, totalTime; // time variables (ms).
        printOptions();             // print the user options to choose from
        choice = sc.nextInt();      //run the choice
        
        // Run the iterative fibonacci method
        // Iterative method run time is very fast due to low overhead of memory
        // usage.
        if(choice == 1){
          System.out.println("Enter a number for the iterative\n"
                  + "fibonnacci sequence: ");
          int num = sc.nextInt();
          System.out.println("\n-----------------------------------------");
          start = System.currentTimeMillis();       // sets start run time
          System.out.println("Start time: "+start); // display start time
          // run iterative method and display resulst for the #n input
          System.out.println("Calculated total for "+num+": "
                  +Math.fibonacciIterate(num));
          end = System.currentTimeMillis();         // sets end run time
          System.out.println("End time: "+end);// display end time
          totalTime = (end-start);                  // sets total time lapse
          System.out.println("Total Time: "+totalTime+"ms");// total time in ms
          // calculate memory usage for running the iterative method of n
          Runtime runtime = Runtime.getRuntime();
          runtime.gc();
          long mem = runtime.totalMemory()-runtime.freeMemory();
          System.out.println("Used memory in bytes: "+mem);
          System.out.println("Used memory in megabytes: "
              +byteToMeg(mem));
          System.out.println("\n-----------------------------------------");
        }
        
        // run the recursive fibonacci method
        if(choice == 2){
          System.out.println("Enter a number for the recursive\n"
                  + "fibonnacci sequence: ");
          int num = sc.nextInt();
          System.out.println("\n-----------------------------------------");
          start = System.currentTimeMillis();       // sets start run time
          System.out.println("Start time: "+start); // display start time
          // run recursive method and display resulst for the #n input
          System.out.println("Calculated total for "+num+": "
                  +Math.fibonacciRec(num));
          end = System.currentTimeMillis();         // sets end run time
          System.out.println("End time: "+end);// display end time
          totalTime = (end-start);                  // sets total time lapse
          System.out.println("Total Time: "+totalTime+"ms");// total time in ms
          // calculate memory usage for running the recursive method of n
          Runtime runtime = Runtime.getRuntime();
          runtime.gc();
          long mem = runtime.totalMemory()-runtime.freeMemory();
          System.out.println("Used memory in bytes: "+mem);
          System.out.println("Used memory in megabytes: "
              +byteToMeg(mem));
          System.out.println("\n-----------------------------------------");
        }
        if(choice ==3){
          System.out.println("-----------------------------------------");
          for(int i=0; i<=40;i++)
            System.out.println(i+": "+Math.fibonacciIterate(i));
          System.out.println("-----------------------------------------");
        }
      } while(choice != 0); // end program choice = 0
    }
    
    // static method to print user options to choose from 
    public static void printOptions()
    {
      System.out.println("\n-----------------------------------------");
      System.out.println("0: Quit ");
      System.out.println("1: Iterative Fibonacci sequence");
      System.out.println("2: Recursive Fibonacci sequence");
      System.out.println("3: Print Fibonacci sequence for n=40");
      System.out.println("-----------------------------------------\n");    
    }
    
    public static long byteToMeg(long bytes) 
    {
    return bytes/MEGABYTE;
    }
}
