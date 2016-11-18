/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package echouserinput;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class EchoUserInput {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) 
	{
		final int SENTINEL = 0;
		int number;
		int total = 0;
		
		Scanner scan = new Scanner( System.in );
		
		System.out.print( "Enter an intiger to add, 0 to total all. " ); 
		number = scan.nextInt( );
		
		while ( number != SENTINEL )
		{
			total += number;
			System.out.println( "total so far is " + total );
			System.out.print( " Enter an intiger to add, 0 to total all. " );
			number = scan.nextInt();
		}
		System.out.println("The total value is: " + total );
	}
	
}
