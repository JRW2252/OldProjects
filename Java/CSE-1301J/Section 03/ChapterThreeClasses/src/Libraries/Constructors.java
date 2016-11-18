/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libraries;

/**
 *
 * @author jameswilliams
 */
public class Constructors 
{
   public static void main( String [ ] args )
   {
     SimpleDate independenceDay;
     independenceDay = new SimpleDate( 7, 4, 1776 );

     SimpleDate graduationDate = new SimpleDate( 5, 15, 2012 );

     SimpleDate defaultDate = new SimpleDate( );
   }
}
