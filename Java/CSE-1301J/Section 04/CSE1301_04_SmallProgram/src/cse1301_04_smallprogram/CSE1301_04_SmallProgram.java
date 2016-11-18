/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_04_smallprogram;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_04_SmallProgram {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
                Scanner scan = new Scanner(System.in);
		int sum = 0;	
		int input;
		
		//scanner is for user inputs
		
		
		do
		{
		System.out.print("Enter an even integer (-1 to quit): ");
		input = scan.nextInt();
		//declares -1 and odd integers to terminate loop 
		if (input != -1 && input%2 == 0)
			{
			sum += input;
			System.out.println("The last even integer was added");
			} 
		} while (input != -1);	
		System.out.println("The sum of even integers is: " + sum);
	}
}