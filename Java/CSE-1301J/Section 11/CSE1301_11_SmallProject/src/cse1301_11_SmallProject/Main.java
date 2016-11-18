/*
 * 
 *The same Movie and Song Classes are being used from last Modules.
 * 1.This adds Movies xi, and Songs xi into their respective ArrayLists.
 * 2.Then prints out their attributes after being stored. 
 * 
 */
package cse1301_11_SmallProject;

import java.util.ArrayList;

/**
 *
 * @author jameswilliams
 */
public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Array for songs for respective class.
        ArrayList<Song> SongList = new ArrayList<Song>();
        
        Song s = new Song("Title1", "Artist1", 2.0f);
        SongList.add(s);
        s = new Song("Title2", "Artist2", 2.2f);
        SongList.add(s);
        s = new Song("Title3", "Artist3", 2.6f);
        SongList.add(s);
        s = new Song("Title4", "Artist4", 2.8f);
        SongList.add(s);
        s = new Song("Title5", "Artist5", 5.2f);
        SongList.add(s);
        s = new Song("Title6", "Artist6", 3.2f);
        SongList.add(s);
        s = new Song("Title7", "Artist7", 1.2f);
        SongList.add(s);
        
        //Prints out array of songs with attributes.
        for(int h = 0; h < SongList.size(); h++)
        {
            System.out.println("" + SongList.get(h));
        }
        
        //Array for movies for respective class.
        ArrayList<Movie> MovieList = new ArrayList<Movie>();
        Movie m = new Movie("MovieTitle1", "Rating1", "Dir1", 5.0f);
        MovieList.add(m); 
        m = new Movie("MovieTitle2", "Rating2", "Dir2", 4.0f);
        MovieList.add(m);
        m = new Movie("MovieTitle3", "Rating3", "Dir3", 3.0f);
        MovieList.add(m);
         m = new Movie("MovieTitle4", "Rating4", "Dir4", 4.2f);
        MovieList.add(m);
        m = new Movie("MovieTitle5", "Rating5", "Dir5", 3.2f);
        MovieList.add(m);
         m = new Movie("MovieTitle6", "Rating6", "Dir6", 4.5f);
        MovieList.add(m);
        m = new Movie("MovieTitle7", "Rating7", "Dir7", 3.5f);
        MovieList.add(m);
        
        
        //Prints out array of movies with attributes.
        for(int i = 0; i < MovieList.size(); i++)
        {
            System.out.println("" + MovieList.get(i));
        }
        
        /*
         * 
         * 
         * 
         * All Lines of code below this line are from previous small projects. 
         * 
         * 
         * 
         *
        Movie MovieOne = new Movie("Saving Private Ryan", "R", 
                "Steven Speilberg", 169.0f);
        System.out.println(MovieOne);
        //COMMENT OUT THE MODIFY TO PLAY ENTIRE MOVIEONE
        //ELSE MODIFIED MOVIE ONE WILL BE PLAYED
        Modify(MovieOne);
        Movie MovieTwo = new Movie("Lincoln", "PG-13", "Steven Speilberg"
                , 150.0f);
        
        do
        {
            MovieOne.play();
        } while(MovieOne.getIsPlaying());
        
        /*
        do 
        {
            MovieTwo.play();
        } while(MovieTwo.getIsPlaying());
        */
    }
    public static void Modify(Movie m)//MODIFY MOVIE
    {
        /*
        m.setTitle("Moded Title");//SETS NEW TITLE
        m.setDirector("Moded Director");//SETS NEW DIRECTOR
        m.setRating("N/A");//SETS NEW RATING FOR FEATURE
        m.setDuration(15.0f);//SET NEW FEATURE LENGTH
        System.out.println("\nAfter modifications\n" + m);
        */
    }
}
