/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_04_03;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_04_03 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++)
		{
			System.out.print(i + "");
		}
		System.out.println("");
		
		Scanner sc = new Scanner(System.in);
		String input;
		System.out.print("Please input a string ");
		input = sc.nextLine();
		System.out.println("You entered: " + input);
		
		String backwards = "";
		int character_count = input.length();
		
		for (int i=0; i < character_count; i++)
		{
			backwards = input.charAt(i) + backwards;
		}
		System.out.println("This backwards is; " + backwards);
	}
}
