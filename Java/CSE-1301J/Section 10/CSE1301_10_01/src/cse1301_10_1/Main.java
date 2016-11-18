/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_10_1;

/**
 *
 * @author jameswilliams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Song Song1 = new Song("Song Title 1", "Song Artist 1", 
                + 10.20f);
        System.out.println(Song1);
        
        do
        {
            Song1.play();
        } while (Song1.getIsPlaying());
        
    }
}
