package cse1301_03_03;

import java.util.Scanner;


/**
 *
 * @author jameswilliams
 */
public class CSE1301_03_03 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		float smallest;
		float largest;
		float allEqual;
		float num1, num2, num3, num4;
		
		Scanner scan = new Scanner( System.in );
		
		System.out.print("Enter your first number: ");
		num1 = scan.nextFloat( );
		System.out.print("Enter your second number: ");
		num2 = scan.nextFloat( );
		System.out.print("Enter your third number: ");
		num3 =scan.nextFloat( );
		System.out.print("Enter your fourth number: ");
		num4 = scan.nextFloat( );
		
		if (num1 <= num2 && num1 <= num3 && num1 <= num4){
		smallest = num1;
		}
		else if (num2 <= num3 && num2 <= num4){
		smallest = num2;
		}
		else if (num3 <= num4){
		smallest = num3;
		}
		else{
		smallest = num4;
		}
		
		if (num1 >= num2 && num1 >= num3 && num1 >= num4){
		largest = num1;
		}
		else if (num2 >= num3 && num2 >= num4){
		largest = num2;
		}
		else if (num3 >= num4){
		largest = num3;
		}
		else{
		largest = num4;
		}
	
		if (num1 == num2 && num2 == num3 && num3 == num4){
		allEqual = num1;
		System.out.println("All of the numbers were the same you clown.");
		}
		else{
		System.out.println("The smallest number from your inputs is: " + smallest + ", and the largest number from your " + "inputs is: " + largest);
		}
		
		
	}
	
}
	