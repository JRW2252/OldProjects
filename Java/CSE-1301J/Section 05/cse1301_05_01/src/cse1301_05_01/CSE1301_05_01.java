package cse1301_05_01;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_05_01 
{

    public static void main(String[] args) 
    {   
        //NEW SCANNER
        Scanner sc = new Scanner(System.in);
        
        //CREATE COUNTER
        int count = 0;
        
        //NEW RANDOM
        Random r = new Random();    
        
        //SIZE OF ARRAY DETERMINED BY USER
        System.out.print("Enter an integer: ");
        int size = sc.nextInt();
        
        //FOR SUM OF [i] >=70
        float sum = 0;
        
        //CREATE ARRAY RANDOMS
        //INPUT INT SIZE FROM USER
        float [] randoms = new float [ size ]; 
        for(int i = 0; i < randoms.length; i++)
        
        {
            
            /*MULTIPLY THE FLOATS BY 100, MAKING 
             * THE VALUES IN RANGE 0 TO 100*/
            randoms[i] = r.nextFloat()*100;
            if(randoms[i] >= 70)
        
            {
                
                //PRINT OUT INPUTS TO BE CALCULATED
                System.out.println("Input:\t" + randoms[i]);
                
                //KEEPS A TOTAL OF THE RANDOM NUMBERS
                sum += randoms[i];
               
                //KEEPS A COUNT OF THE RANDOM NUMBERS
                count ++;
            
            }
            
            else
            
            {
            
                //PRINT OUT OF DISCARDED INPUTS
                System.out.println("Input:\t" + randoms[i]);
            
            }
            
        }
        
        //PRINT OUT OF RESULTS
        System.out.println("\n\nSum of >= 70:\t\t" + sum + "\n# of >= 70:"
                + "\t\t" + count + "\n>= 70 average:\t\t" + sum/count);
            
    }
    
}