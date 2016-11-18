/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_03_01;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_03_01 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Boolean isRaining;
		Boolean homework;
		Boolean homeworkExtension;
		
		isRaining= false;
		homework= false;
		homeworkExtension= false;
		
		
		Boolean shouldGoOutside;
		shouldGoOutside = !homework || homeworkExtension && !isRaining;
		

				
		System.out.println(shouldGoOutside);

	}
}
