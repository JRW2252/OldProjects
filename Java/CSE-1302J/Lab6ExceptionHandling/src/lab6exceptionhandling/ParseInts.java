package lab6exceptionhandling;

// Program Name:      ParseInts.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Lab#7
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
import java.util.Scanner;
 
public class ParseInts
{
    public static void main(String[] args)
    {
      int val, sum=0;
      Scanner scan = new Scanner(System.in);
      String line;
 
      System.out.println("Enter a line of text");
      Scanner scanLine = new Scanner(scan.nextLine());
 
      while (scanLine.hasNext())
          {      
            val = Integer.parseInt(scanLine.next());
            try{
            sum += val;
            }
            catch(Exception NumberFormatException){
                
            }
          }
      System.out.println("The sum of the integers on this line is " + sum);
    }
 
}
