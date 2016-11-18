/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_12smallprogram;

/**
 *
 * @author ryanwilliams
 */
public class CSE1301_12SmallProgram 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int index;
        
        int[] values = {1, 6, 4, 7, 2, 8, 45, 23, 11, 3, 5, 22, 9, 8, 6, 7,34 };
        DisplayArray(values);
        
        index = IndexOf(0, values);
        System.out.println("\nindex# for 0 in the unordered list: " + index);
        index = IndexOf(7, values);
        System.out.println("\nindex# for 7 in the unordered list: " + index);
        index = IndexOf(22, values);
        System.out.println("\nindex# for 22 in the unordered list: " + index);
        index = IndexOf(3, values);
        System.out.println("\nindex# for 3 in the unordered list: " + index);
        index = IndexOf(9, values);
        System.out.println("\nindex# for 9 in the unordered list: " + index + 
                "\n");
        
        
        int[] orderedValues = {1, 3, 4, 5, 7, 8, 9, 11, 13, 14, 17, 19, 20, 21};
        DisplayArray(orderedValues);
        
        index = BinaryIndexOf(0, orderedValues);
        System.out.println("\nindex# for 0 in the ordered list: " + index);
        index = BinaryIndexOf(19, orderedValues);
        System.out.println("\nindex# for 19 in the ordered list: " + index);
        index = BinaryIndexOf(7, orderedValues);
        System.out.println("\nindex# for 7 in the ordered list: " + index);
        index = BinaryIndexOf(4, orderedValues);
        System.out.println("\nindex# for 4 in the ordered list: " + index);
        index = BinaryIndexOf(20, orderedValues);
        System.out.println("\nindex# for 20 in ordered list: " + index + "\n");
        
    }
    
    public static int IndexOf(int value, int[] array)
    {
        int count = 0;
        for(int i = 0; i < array.length; i++)
        {
            count ++;
            if(array[i] == value)
            {
                return i;
            }
        } 
        System.out.println("Total linear counts: " + count);
        return -1;
    }
    
    public static int BinaryIndexOf(int value, int[] array)
    {
        int start = 0;
        int end = array.length -1;
        int middle;
        int count = 0;
        
        while(end >= start)
        {
            
            middle = (start + end) / 2;
            if(array[middle] == value)
            {
                count++;
                return middle;
            }
            if(array[middle] < value)
            {
                count++;
                start = middle + 1;
            }
            else
            {
                count++;
                end = middle -1;
            }
        } 
        System.out.println("Total binary counts: " + count);
        return -1;
        
    }
    
    
    public static void DisplayArray(int[] array)
    {
        for(int a: array)
        {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
