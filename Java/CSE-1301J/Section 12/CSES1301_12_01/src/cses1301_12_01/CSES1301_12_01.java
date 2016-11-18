/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cses1301_12_01;

/**
 *
 * @author jameswilliams
 */
public class CSES1301_12_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] values = { 1, 3, 5, 7, 3, 5, 9, 5, 3, 9};
        DisplayArray(values);
        int[] valuesSorted = {1, 3, 4, 5, 6, 7, 8, 12, 21, 30, 34, 36, 38, 48};
        DisplayArray(valuesSorted);
        
        int index;
        index = IndexOf(3, values);
        System.out.println("Position of 3 is at index # " + index);
        
        index = BinaryIndexOf(34, valuesSorted);
        System.out.println("Position of 34 is at Binary index # " + index);
        
        
        
        
    }
    
    public static int IndexOf(int value, int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == value)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static int BinaryIndexOf(int value, int[] array)
    {
        int start = 0;
        int end = array.length -1;
        int middle;
        
        while(end >= start)

        {
            middle = (start + end) / 2;
            if(array[middle] == value)
            {
                return middle;
            }
            if(array[middle] < value)
            {
                start = middle + 1;
            }
            else
            {
                end = middle -1;
            }
        }
        return -1;
    }
    
    public static void DisplayArray(int[] array)
    {
        for(int a : array)
        {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
