/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libraries;

/**
 *
 * @author jameswilliams
 */
public class NullReference2
{
  public static void main( String [] args )
  {
     SimpleDate independenceDay = new SimpleDate( 7, 4, 1776 );
     System.out.println( "The month of independenceDay is "
                         + independenceDay.getMonth( ) );

      independenceDay = null;  // set object reference to null
     // attempt to use object reference
     System.out.println( "The month of independenceDay is "
                         + independenceDay.getMonth( ) );
  }
}

