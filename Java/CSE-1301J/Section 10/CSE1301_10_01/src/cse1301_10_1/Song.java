/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_10_1;

/**
 *
 * @author jameswilliams
 */
public class Song {
    
    private String title;
    private String artist; 
    private float duration;
    private float currentPlayPosition;
    private float timeLeft = 0;
    private boolean isPlaying;
    
    public Song()
    {
        title = "NO TITLE";
        artist = "NO ARTIST";
        duration = 0.0f;
        currentPlayPosition = 0.0f;
        timeLeft = duration;
        isPlaying = false;
        System.out.println("Constructor is finished");
    }
    
    public Song(String t, String a, Float d)
    {
        title = t;
        artist = a;
        duration = d;
        currentPlayPosition = 0.0f;
        timeLeft = duration;
        isPlaying = false;
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
    
    public boolean getIsPlaying()
    {
        return isPlaying;
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
    
    public void play()
    {
        isPlaying = true;
        currentPlayPosition += 0.1f;
        if(currentPlayPosition < duration)
        {
            timeLeft = duration - currentPlayPosition;
            System.out.println("Time left in song: " + timeLeft);
        }
        else
        {
            isPlaying = false;
            System.out.println(title + " is finished playing.");
            currentPlayPosition = 0.0f;
        }
    }
    
}
