/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libraries;

/**
 *
 * @author jameswilliams
 */
public class Methods 
{
  public static void main( String [] args )
  {
     SimpleDate independenceDay = new SimpleDate( 7, 4, 1776 );
     int independenceMonth = independenceDay.getMonth( );
     System.out.println( "Independence day is in month "
                         + independenceMonth );

     SimpleDate graduationDate = new SimpleDate( 5, 15, 2008 );
     System.out.println( "The current day for graduation is "
                         + graduationDate.getDay( ) );

     graduationDate.setDay( 12 );
     System.out.println( "The revised day for graduation is "
                         + graduationDate.getDay( ) );

     SimpleDate currentDay = new SimpleDate( 9, 30, 2008 );
     System.out.println( "The current day is "
                         + currentDay.getMonth( ) + '/'
                         + currentDay.getDay( ) + '/'
                         + currentDay.getYear( ) );

     currentDay.nextDay( );
     System.out.println( "The next day is "
                         + currentDay.getMonth( ) + '/'
                         + currentDay.getDay( ) + '/'
                         + currentDay.getYear( ) );
  }
}
