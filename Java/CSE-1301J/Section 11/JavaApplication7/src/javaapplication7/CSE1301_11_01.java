/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_11_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        Scanner sc =  new Scanner(System.in);
        String line;
        
        do
        {
            System.out.println("Enter names. (QUIT to end. Case sensative.)"
                    + "\n(LIST) (Case Sensative) for a list entered.");
            line = sc.nextLine();
            if(line.compareTo("QUIT") != 0)
            {
                names.add(line);
            }
            if(line.compareTo("LIST") == 0)
            {
                names.remove(line);
                for(int h = 0; h < names.size(); h++)
                    System.out.println("  " + names.get(h));
            }
        } while(line.compareTo("QUIT") != 0);
        
        System.out.println("\nThe following names were entered.");
        
        for(int i=0; i < names.size(); i++)
        {
            System.out.println("  " + names.get(i));
        }
    }
}
