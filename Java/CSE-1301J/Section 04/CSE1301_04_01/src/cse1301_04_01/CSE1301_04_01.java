/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_04_01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_04_01 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException
	{
		
		// TODO code application logic here
		int i = 0;
		int sum = 0;
		
		while (i == (i/2))
		{
			sum += i;
			i++;
		}
		
		System.out.println("The sum of 1 to 10 is " + sum);
		
		//Sum from 1 to n = n*(n+1)/2
		System.out.println("More simply the sum = " + 10*11/2);
		
		
		File input = new File("data.txt");
		Scanner sc = new Scanner(input);
		
		int value;
		sum = 0;
		
		while (sc.hasNext())
		{
			
			value = sc.nextInt();
			System.out.println("I read in " + value);
			sum += value;
			
		}
		System.out.println("The sum of the values is " + sum);
	}
}
