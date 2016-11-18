/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_02_01;

import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_02_01 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		System.out.print("Please type your name:");
		String user_name;
		Scanner sc = new Scanner(System.in);
		user_name = sc.nextLine();
		System.out.println("Welcome to Java " + user_name);
	}
}