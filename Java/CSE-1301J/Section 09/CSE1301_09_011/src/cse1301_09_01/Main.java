/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_09_01;

/**
 *
 * @author jameswilliams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Song mySong = new Song();
        System.out.println("Title: " + mySong.getTitle() + "\nArtist: " + 
                mySong.getArtist() + "\nDuration: " + mySong.getDuration());
        
        Song yourSong = new Song("Song Title 1", "Song Artist 1", 
                + 7.40f);
        System.out.println(yourSong);
    }
}
