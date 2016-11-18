/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validateinput;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class ValidateInput {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
	int number;Scanner scan = new Scanner(System.in);
	
	do
	{
		System.out.print("Enter a number between 1 and 10: ");
		number = scan.nextInt();
	} while ( number < 1 || number > 10 );
	
	System.out.println("Thank you.");
	}
}