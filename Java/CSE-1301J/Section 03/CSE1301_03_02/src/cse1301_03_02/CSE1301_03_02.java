/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_03_02;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_03_02 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x_position = 0;
		int y_position = 0;
		char command;
		
		System.out.print("Enter a command(WASD): ");
		command = sc.next() .toUpperCase() .charAt(0);
		
		/*
		if (command == 'W') System.out.println("Moving up. ");
		else if (command == 'A') System.out.println("Moving left. ");
		else if (command == 'S')System.out.println("Moving down. ");
		else if (command == 'D')System.out.println("Moving right. ");
		*/
		
		switch(command)
		{

			case 'W' :
				y_position++;
				System.out.println("Moving up. ");
				break;
			
			case 'A' :
				x_position--;
				System.out.println("Moving left. ");
				break;
				
			case 'S' :
				y_position--;
				System.out.println("Moving down. ");
				break;
				
			case 'D' :
				x_position++;
				System.out.println("Moving right. ");
				break;
				
			default : System.out.println("You did not enter a valid (WASD) command");
		}	
		System.out.println("Your position is x: " + x_position + ", y: " + y_position);
	}
}
