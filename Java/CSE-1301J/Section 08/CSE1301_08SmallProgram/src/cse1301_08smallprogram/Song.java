/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_08smallprogram;

/**
 *
 * @author jameswilliams
 */
public class Song {
    
    private String title;
    private String artist; 
    private float duration;
    private String album;
    private String genre;
    private int rating;
    
    public String getTitle()
    {
        return title;
    }
    
    public String getArtist()
    {
        return artist;
    }
    
    public float getDuration()
    {
        return duration;
    }
    
    public String getAlbum()
    {
        return album;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public int getRating()
    {
        return rating;
    }
    
    public void setTitle(String newTitle)
    {
        if(newTitle.compareTo("") != 0)
        {
            title = newTitle;
        }
    }
    
    public void setArtist(String newArtist)
    {
        if(newArtist.compareTo("") != 0)
        {
            artist = newArtist;
        }
    }
    
    public void setDuration(float newDuration)
    {
        if(newDuration >=0)
        {
            duration = newDuration;
        }
    }
    
    public void setAlbum(String newAlbum)
    {
        if(newAlbum.compareTo("") != 0)
        {
            album = newAlbum;
        }
    }
    
    public void setGenre(String newGenre)
    {
        if(newGenre.compareTo("") != 0)
        {
            genre = newGenre;
        }
    }
    
    public void setRating(int newRating)
    {
        if(newRating >= 0 || newRating <= 10)
        {
            rating = newRating;
        }
    }
    
    
}
