package cse1301_programone;

import java.util.Scanner;

/**
 *
 * @author jamesryanwilliams
 */
public class CSE1301_ProgramOne 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //CREATE SCANNER
        Scanner scan = new Scanner(System.in);
        
        //INT VARS
        int onCount = 0;int offCount = 0; int i;int digit = 0;
        
        //STRING VAR
        String input;
                
        //DO THIS STATEMENT
        do
        {
            //PROMPT USER AND ACCEPT INPUT
            System.out.print("\nEnter a valid binary word.\n(3 to 8 digits): ");
            input = scan.next();
            //CREATE INDEX
            for(i = 0; i < input.length(); i++)
            {   
                /*I HAD TO SUBTRACT 48 TO MAKE INTEGERS CORRECT.*/
                digit = input.charAt(i) - 48; 
                //System.out.println(digit + "\t" + i);
                
                //ON COUNTER
                if(digit == 1)
                {
                onCount++;
                }
                //OFF COUNTER
                if(digit == 0)
                {
                offCount++;
                }
                //EXCLUDE NON 1 OR O INTS
                if(digit > 1 || digit < 0)
                {
                    onCount = 0;
                    offCount = 0;
                }
                 /*
                 * 
                 * I TRIED TO EXCLUDE NON INTEGER CHARACTERS MANY WAYS
                 * AND GOT COULD NOT GET IT TO WORK FOR ME. SO, IF YOU ENTER 
                 * 3 LETTERS IT WILL ACCEPT IT AS BEING VALID. I PUT A 
                 * STATEMENT TO WHERE IF THE ON/OFF COUNT IS = 0, THEN IT IS
                 * INVALID. SORRY I COULDN'T GET IT FILTERED WELL ENOUGH.
                 * 
                 */
                //EXCLUDE NON INT CHARACTERS 
                if(digit != 0 || digit != 1)
                {
                    onCount = 0;
                    offCount = 0;
                }
            //BEGIN FILTERING OUTSIDE THE FOR LOOP    
            }
            //NEEDS AT LEAST 1 ON
            if(onCount < 1)
            {
                onCount = 0;
            }
            //EXCLUDES ALL OFF (REDUNDANCY)
            if(offCount > 7)
            {
                offCount = 0;
            }
        } while(digit > 1 || digit < 0);
        
        //PRINT THE VALIDATION STATEMENT
        System.out.println("\nBinary word is valid\n");
        //PRINT TOTAL OF ON AND OFF VARS 
        System.out.println("\n\nIf on and off = 0\nThe word is invalid!!"
                + "\n\non:\t\t" + onCount + "\noff:\t\t" + offCount);
      }
}