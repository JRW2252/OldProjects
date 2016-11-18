/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertexample;

import java.util.Scanner;


/**
 *
 * @author ryanwilliams
 */
public class ConvertExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
    System.out.print("Enter a valid binary word (must be at least three 1's"
                    + " to be valid): ");
    Scanner sc = new Scanner(System.in);
    int in = sc.nextInt();
    System.out.println("Integer: " + in);
    //integer to binary
    String by = Integer.toBinaryString(in);
    System.out.println("Byte: " + by);
    //integer to hexadecimal
    String hex = Integer.toHexString(in);
    System.out.println("Hexa decimal: " + hex);
    //integer to octal
    String oct = Integer.toOctalString(in);
    System.out.println("Octal: " + oct);
    }
}