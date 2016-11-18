package inputmismatchexception;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class InputMismatchException 
{
	public static void main(String[] args) 
	{
	Scanner scan = new Scanner ( System.in );
	String garbage;
	
	System.out.print( "Enter your age as an intiger: ");
	while ( ! scan.hasNextInt( ) )
		{
			garbage = scan.nextLine();
			System.out.print( "\nPlease enter an intiger: " );
		}
		int age = scan.nextInt( );
		System.out.println( "Your age is " + age );
		
	}	
}
