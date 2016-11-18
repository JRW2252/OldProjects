/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_09_01;

/**
 *
 * @author jameswilliams
 */
public class Song {
    
    private String title;
    private String artist; 
    private float duration;

    public Song()
    {
        title = "NO TITLE";
        artist = "NO ARTIST";
        duration = 0.0f;
        System.out.println("Constructor is finished");
    }
    
    public Song(String t, String a, Float d)
    {
        title = t;
        artist = a;
        duration = d;
        System.out.println("Constructor with parameters is finished");
    }
    
    public String toString()
    {
        return "Title: " + title + "\nArtist: " + artist + "\nDuration: " 
                + duration;
    }
    
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
    
}
