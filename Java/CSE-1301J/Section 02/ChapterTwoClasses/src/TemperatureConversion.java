
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jameswilliams
 */
public class TemperatureConversion 
{
   public static void main( String [] args )
   {
     	int temp,far,cel;
		System.out.print("What is the temperature you'd like to convert?  ");
		Scanner myScanner = new Scanner(System.in);
		temp = myScanner.nextInt();
		far = temp * 9 / 5 + 32; //use this line if Celsius to Fahrenheit
		cel = (temp - 32) * 5 / 9; // use this line if Fahrenheit to Celsius
		//use this line if Celsius to Fahrenheit
 		System.out.println("Fahrenheit --> Celsius: " + cel); 
		// use this line if Fahrenheit to Celsius
		System.out.println("Celsius --> Fahrenheit: " + far);
	}	
}