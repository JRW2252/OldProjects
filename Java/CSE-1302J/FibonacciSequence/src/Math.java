// Program Name:      Math.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
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

                   
public class Math 
{
    public static int total;
    // Fibonacci sequence using an iterative method to solve for the nth 
    // number in the sequence.
    public static int fibonacciIterate(int n)
    {
      total = 1;
      int[] temp = new int[n];
      if(n == 0)
        return 0;
      if(n>1)
      {
        temp[0] = 1;
        temp[1] = 1;
        for(int i = 2; i < temp.length; i++)
        {
          total = temp[i-1]+temp[i-2];
          temp[i] = total;
        }
      }
      return total;
    }
    
    // Fibonacci sequence using a recursive  method to solve for the nth 
    // number in the sequence.
    public static int fibonacciRec(int n)
    {
      if(n == 0) // base case for n=0
        return 0;
      else if(n == 1) // base case for n=1
        return 1;
      else // general case for n>1. 
        return fibonacciRec(n-1)+fibonacciRec(n-2); // add n-1 to n-2.
    }
}