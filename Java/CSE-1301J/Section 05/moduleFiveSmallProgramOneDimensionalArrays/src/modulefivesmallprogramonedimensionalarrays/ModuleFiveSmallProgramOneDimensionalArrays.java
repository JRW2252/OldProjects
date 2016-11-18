/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modulefivesmallprogramonedimensionalarrays;

import java.util.Random;

/**
 *
 * @author ryanwilliams
 */
public class ModuleFiveSmallProgramOneDimensionalArrays 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    
    {
        
        int[] values;
        values = new int[1000];
        
        int[] counters;
        counters = new int[10];
        Random r = new Random();
        
        for(int i=0; i < values.length; i++)
        {
            values[i] = r.nextInt(10);
         //   System.out.print(values[i] + " ");
            int spot;
            spot = values[i];
            counters[spot]++;
        }
        System.out.println();
       
        
        for (int i = 0; i < 10; i++)
        {
            System.out.println(i + " occured" + counters[i] + " times.");
        }
        
    }
}
