/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_08smallprogram;

/**
 *
 * @author jameswilliams
 */
public class CSE1301_08SmallProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Song mySong = new Song();
        mySong.setTitle("Praise the Lord");
        mySong.setArtist("Made up Artist");
        mySong.setDuration(7.33f);
        mySong.setAlbum("Made up Album");
        mySong.setGenre("Awesome");
        mySong.setRating(10);
        
        Song yourSong = new Song();
        yourSong.setTitle("Jesus Freak");
        yourSong.setArtist("DC Talk");
        yourSong.setDuration(4.47f);
        yourSong.setAlbum("Made up Album One");
        yourSong.setGenre("Awesome One");
        yourSong.setRating(10);
        
        Song ourSong = new Song();
        ourSong.setTitle("Our New Song");
        ourSong.setArtist("Made up Artist Two");
        ourSong.setDuration(2.22f);
        ourSong.setAlbum("Made up Album Two");
        ourSong.setGenre("Awesome Two");
        ourSong.setRating(4);
        
        Song thisSong = new Song();
        thisSong.setTitle("This New Song");
        thisSong.setArtist("Made up Artist Three");
        thisSong.setDuration(2.22f);
        thisSong.setAlbum("Made up Album Three");
        thisSong.setGenre("Awesome Three");
        thisSong.setRating(6);
        
        System.out.println("\n'" + mySong.getTitle() + "' by, '"  
                + mySong.getArtist() + "'\nSong length: " + mySong.getDuration() 
                + "\nAlbum Title: " + mySong.getAlbum() + "\nRating: "
                + mySong.getRating() + "\nGenre: " + 
                mySong.getGenre());
        
        System.out.println("\n'" + yourSong.getTitle() + "' by, '"  
                + yourSong.getArtist() + "'\nSong length: " + yourSong.getDuration()
                + "\nAlbum Title: " + yourSong.getAlbum() + "\nRating: "
                + yourSong.getRating() + "\nGenre: " + 
                yourSong.getGenre());
        
        System.out.println("\n'" + ourSong.getTitle() + "' by, '"  
                + ourSong.getArtist() + "'\nSong length: " + ourSong.getDuration() 
                + "\nAlbum Title: " + ourSong.getAlbum() + "\nRating: "
                + ourSong.getRating() + "\nGenre: " + 
                ourSong.getGenre());
        
        System.out.println("\n'" + thisSong.getTitle() + "' by, '"  
                + thisSong.getArtist() + "'\nSong length: " + thisSong.getDuration() 
                + "\nAlbum Title: " + thisSong.getAlbum() + "\nRating: "
                + thisSong.getRating() + "\nGenre: " + 
                thisSong.getGenre());
    }
}
