package cse1301_programthree;

/**
 *
 * @author jameswilliams
 */
public class Song 
{
    
    private String title;
    private String artist; 
    private float duration;
    private int fileSize;
    private float currentPlayPosition;
    private float timeLeft = 0;
    private boolean isPlaying;
    
    public Song()
    {
        title = "NO TITLE";
        artist = "NO ARTIST";
        duration = 0.0f;
        fileSize = 0;
        currentPlayPosition = 0.0f;
        timeLeft = duration;
        isPlaying = false;
        System.out.println("Song constructor finished.");
    }
    
    public Song(String t, String a, Float d, Integer s)
    {
        title = t;
        artist = a;
        duration = d;
        fileSize = s;
        currentPlayPosition = 0.0f;
        timeLeft = duration;
        isPlaying = false;
        System.out.println("Song constructor with parameters finished.");
    }
    
    public String toString()
    {
        return "Title:\t\t" + title + "\nArtist:\t\t" + artist + "\nDuration:\t" 
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
    
    public int getFileSiz()
    {
        return fileSize;
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
    
    public void setFileSize(int newFileSize)
    {
        if(newFileSize >= 0)
                {
                    fileSize = newFileSize;
                }
    }
    
    public void setDuration(float newDuration)
    {
        if(newDuration >= 0)
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
