/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_02_smallprogram;

import java.util.Scanner;


/**
 *
 * @author jameswilliams
 */
public class CSE1301_02_SmallProgram {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		//line to allow users to input their numbers
		System.out.print("Please input four numbers: ");
		
		//import scanner for user inputs
		Scanner sc;
		sc = new Scanner(System.in);
		
		//user numbers go here
		float num1 = sc.nextFloat();
		float num2 = sc.nextFloat();
		float num3 = sc.nextFloat();
		float num4 = sc.nextFloat();
		
		//line for calculating the sum
		float sum = num1 + num2 + num3 + num4;
		
		//line for calculating the average
		float average = sum / 4;
		
		//line for calculating the product
		float product = num1 * num2 * num3 * num4;	

        /*line for calculating the product
        *of the sums a+b and c+d */
		float productSum = (num1 + num2) * (num3 + num4);
		
		//lines for displaying the calculation to the user
		System.out.println("The sum is " + sum);
		System.out.println("The average is " + average);	
		System.out.println("The product is " + product);
		System.out.println("The product of a+b and c+d is " + productSum);
	}
}
		
		