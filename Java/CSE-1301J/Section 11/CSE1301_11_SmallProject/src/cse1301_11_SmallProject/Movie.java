package cse1301_11_SmallProject;

/**
 *
 * @author jameswilliams
 */
public class Movie 
{
    
    private String title;
    private String rating;
    private String director; 
    private float duration;
    private float currentTime;
    private float timeRemaining = 0;
    private boolean isPlaying;
    
    public Movie()
    {
        title = "NO TITLE";
        rating = "NO RATING";
        director = "NO DIRECTOR";
        duration = 0.0f;
        currentTime = 0.0f;
        timeRemaining = duration;
        isPlaying = false;
        System.out.println("Movie constructor finished.");
    }
    
    public Movie(String t, String r, String dir, Float d)
    {
        title = t;
        rating = r;
        director = dir;
        duration = d;
        currentTime = 0.0f;
        timeRemaining = duration;
        isPlaying = false;
        System.out.println("Movie constructor with parameters finished.");
    }
    
    public String toString()
    {
        return "Title:\t\t" + title + "\nRating:\t\t" + rating + "\nDirector:\t" + 
                director + "\nDuration:\t" + duration;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getRating()
    {
        return rating;
    }
    
    public String getDirector()
    {
        return director;
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
    
    public void setRating(String newRating)
    {
        if(newRating.compareTo("") != 0)
        {
            rating = newRating;
        }
    }
    
    public void setDirector(String newDirector)
    {
        if(newDirector.compareTo("") != 0)
        {
            director = newDirector;
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
        currentTime += 0.1666666667f;
        if(duration > currentTime)
        {
            timeRemaining = duration - currentTime;
            System.out.println("Current Play Time: " + currentTime
                    + "\tTime Remaining; " + timeRemaining);
        }
        else
        {
            isPlaying = false;
            System.out.println("\n" + title + " is over. Start another movie."
                    + "\n");
            currentTime = 0.0f;
        }
    }
    
}
