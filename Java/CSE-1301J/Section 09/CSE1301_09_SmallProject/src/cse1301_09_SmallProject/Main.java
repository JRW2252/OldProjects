/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_09_SmallProject;

/**
 *
 * @author jameswilliams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Movie myMovie = new Movie();
        System.out.println("Title: " + myMovie.getTitle() + "\nARating: " + 
                myMovie.getRating() + "\nDirector:" + myMovie.getDirector() 
                + "\nDuration: " + myMovie.getDuration());
        
        Movie yourMovie = new Movie("Movie Title 1", "PG13", "Steven Speilberg"
                , 110.23f);
        System.out.println(yourMovie);
        
        Movie anotherMovie = new Movie("Movie Title 2", "PG13", "Ryan Williams"
                , 120.00f);
        System.out.println(anotherMovie);
    }
}
