/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_13_01;

import java.util.Random;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_13_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] values = {12, 2, 5, 76, 3, 7, 9, 8};
        DisplayArray(values);
        SelectionSort(values);
        DisplayArray(values);
        
        int [] randomValues =  new int [20];
        Random r = new Random();
        
        for(int i=0; i < randomValues.length; i++)
        {
            randomValues [i] = r.nextInt(100);
        }
        DisplayArray(randomValues);
        SelectionSort(randomValues);
        DisplayArray(randomValues);
        
    }
    public static void SelectionSort(int [] array)
    {
        int temp;
        int max_location;
        
        for(int i=array.length -1; i > 0; i--)
        {
            max_location = IndexOfMax(array, i);
            temp = array[max_location];
            array[max_location] = array[i];
            array[i] = temp;
            
        }
    }
    public static int IndexOfMax(int [] array, int size)
    {
        int index = 0;
        for(int i = 0; i <= size; i++)
        {
            if(array[i] > array[index])
            {
                index = i;
            }
        }
        return index; 
    }
    
    public static void DisplayArray(int [] array)
    {
        for(int a : array)
        {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
