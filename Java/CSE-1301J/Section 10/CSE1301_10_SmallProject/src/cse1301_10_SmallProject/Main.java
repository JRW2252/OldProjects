/*
 * THIS MAIN SETS CHARACTERISTICS FOR MOVIEONE AND OUTPUTS RESULTS.
 * ALSO, THE MODIFIER SETS NEW ATTRIBUTES FOR THE MOVIE ONE.
 * COMMENT OUT THE MODIFY(MOVIEONE); ON LINE__27__ TO PLAY ORIGINAL 
 * MOVIE TITLE AND DISPLAY IT'S INFORMATION. 
 */
package cse1301_10_SmallProject;

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
        m.setTitle("Moded Title");//SETS NEW TITLE
        m.setDirector("Moded Director");//SETS NEW DIRECTOR
        m.setRating("N/A");//SETS NEW RATING FOR FEATURE
        m.setDuration(15.0f);//SET NEW FEATURE LENGTH
        System.out.println("\nAfter modifications\n" + m);
    }
}
