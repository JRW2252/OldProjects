/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryserarch;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class BinarySerarch {

    public static void main(String[] args) {
        int[] numbers ={2,4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search for: ");
        
        int input = sc.nextInt();
        int index = binarySearch(numbers, input);
        if(index != -1)
            System.out.println(input + " is found at index " + index);
        else
            System.out.println(input + " not found.");
    }
    public static int binarySearch(int[] arr, int input)
    {
        int start = 0;
        int end = arr.length -1;
        int middle;
        
        while(end >= start)
        {
            middle = (start + end) / 2;
            if(arr[middle] == input)
                return middle;
            else if(arr[middle] > input)
                end = middle -1;
            else
                start = middle +1;
            }
    return -1;
    }
}
