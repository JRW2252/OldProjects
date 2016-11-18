/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module4filereaderversion;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class Module4FileReaderVersion {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException
	{

		File input = new File("data.txt");
		Scanner sc = new Scanner(input);
		int value = 0; int sum = 0;
		
		while (sc.hasNext())
		{
			System.out.println("This value has been read" + value);
			if (value != -1 && value%2 == 0)
			{
				sum += value;
				System.out.println("This value has been added "
				+ value);
			}
		value = sc.nextInt();	
		}
		//closing scanner to use the scanner resources for 
		//System.in
		sc.close();
		System.out.println("The sum of the values is " + sum);
		
		//New scanner created for system inputs
		Scanner scan = new Scanner(System.in);
		do
		{
		System.out.print("Enter more integers (-1 to quit): ");
		value = scan.nextInt();
		//declares -1 to terminate loop
		if (value != -1 && value%2 == 0)
			{
			sum += value;	
			System.out.println("The last even number was added.");
			} 
		} while (value != -1);	
		System.out.println("The final total is: " + sum);
		scan.close();
	}
	
}