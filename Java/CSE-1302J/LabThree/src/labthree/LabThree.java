// Program Name - classname.java
// Course: CSE 1302J
// Student Name: Jame Williams
// Assignment Number: Lab#3
// Due Date: 09/09/2011
// Purpose: Description of what the program does
package labthree;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class LabThree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {

      int [] [] A = new int [2] [5]; // 2 rows, 5 columns
      // fill each cell with the sum of its row and column numbers
      for (int i = 0; i < 2; i++)
      {
                  for (int j = 0; j < 5; j++)
                  {
                              A[i] [j] = i + j;
                              //System.out.print(A[i][j]+"\n");
                  }
                  
      }
      int [] [] B = {{1,2,3,4,5}, {6,7,8,9,10}};  // 2 rows, 5 columns
      System.out.println ("A.length = " + A.length);
      System.out.println ("B.length = " + B.length);
      System.out.println ("Number of columns in A is " + A[0].length);
      System.out.println ("Number of cells in A is " + A.length * A[0].length);
      // compute row sums for B
      for (int i = 0; i < B.length; i++)
      {
      int sum = 0;
                  for (int j = 0; j < B[i].length; j++)
                  {
                              sum = sum + B[i] [j];
                              //System.out.print(sum+"\n");
                  }
                  //System.out.println ("The sum of row " + i + " is " + sum);
      }
      // compute column sums for B here
      for (int i = 0; i < B[0].length; i++)
      {
          int sum = 0;
                  for (int j = 0; j < B.length; j++)
                  {
                              sum = sum + B[j] [i];
                  }
                  System.out.println ("The sum of col " + i + " is " + sum);
      }
      // Part three of lab
    Scanner scan = new Scanner(new File("input1.txt"));
    int R = scan.nextInt();
    int C = scan.nextInt();
    int [][]nums = new int[R][C];
    
    for(int i = 0; i < R; i++)
        for(int j = 0; j < C; j++)
            nums[i][j] = 0;
    
    R = scan.nextInt();
    C = scan.nextInt();
    while(R!=- 1&& C!=-1)
    {
    nums[R][C] = scan.nextInt();
    R = scan.nextInt();
    C = scan.nextInt();
    }
    
    for(int i = 0; i < nums.length; i++)
    {
        for(int j = 0; j < nums[0].length ; j++)
        {
            System.out.print(nums[i][j]+" ");
        }
        System.out.println("");
    }
    }
}
