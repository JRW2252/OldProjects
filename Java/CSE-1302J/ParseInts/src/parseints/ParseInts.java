package parseints;

// Program Name:      ParseInts.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

import java.util.Scanner;
 
public class ParseInts
{
    public static void main(String[] args)
    {
        System.out.println(23%5);
    }
    public static void parseInts(String[] s)
    {
      int val, sum=0;
      Scanner scan = new Scanner(System.in);
      String line;
      Scanner scanLine = new Scanner(scan.nextLine());
      while (scanLine.hasNext())
          {  
              try{
                val = Integer.parseInt(scanLine.next());
                sum += val;
            }
            catch(Exception NumberFormatException){
                
            }
          }
      System.out.println("The sum of the integers on this line is " + sum);
    }
}
 