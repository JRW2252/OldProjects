/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_04_02;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_04_02 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		
Scanner sc = new Scanner(System.in);


int input;
int sum = 0;
int smallest = Integer.MAX_VALUE;

do
{
	System.out.print("Enter a number (-1 to quit): ");
	input = sc.nextInt();
	if (input != -1)
		{
			sum += input;
			if (input < smallest) {
				smallest = input;
			}
			
		}	
} while (input != -1);

System.out.println("The sum is " + sum);
System.out.println("The smallest intigert is " + smallest);
		
	}
}
