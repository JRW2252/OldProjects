package cse1301_09_SmallProject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

    public Movie()
    {
        title = "NO TITLE";
        rating = "NO RATING";
        director = "NO DIRECTOR";
        duration = 0.0f;
        System.out.println("Constructor is finished");
    }
    
    public Movie(String t, String r, String dir, Float d)
    {
        title = t;
        rating = r;
        director = dir;
        duration = d;
        System.out.println("Constructor with parameters is finished");
    }
    
    public String toString()
    {
        return "Title: " + title + "\nRating: " + rating + "\nDirector: " + 
                director + "\nDuration: " + duration;
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

    
    public void setTitle(String newTitle)
    {
        if(newTitle.compareTo("") != 0)
        {
            title = newTitle;
        }
    }
    
    public void setArtist(String newRating)
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
        if(newDuration >=0)
        {
            duration = newDuration;
        }
    }

}
