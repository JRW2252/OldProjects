/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_programthree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_ProgramThree 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        ArrayList<Song> songCollection = new ArrayList<Song>();
        
        
        ArrayList<MP3_Player> songsOnPlayer = new ArrayList<MP3_Player>();

        
        Scanner sc = new Scanner(System.in);
        String userControlls;
        System.out.println("Pick what songs you want on your play list:");
        do
        {
            userControlls = sc.nextLine();
            if(userControlls.compareToIgnoreCase("add") == 0)
            {
                System.out.println("Pick the number you want to add:");
                for(int i = 0; i < songCollection.size(); i++)
                {
                    System.out.println(songCollection.indexOf(i) +
                            ": " + songCollection.get(i));
                }
                userControlls = sc.nextLine();
            }
        } while(userControlls.compareTo("Play") != 0);
    }
}