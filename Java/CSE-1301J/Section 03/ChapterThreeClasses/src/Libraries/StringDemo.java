/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Libraries;

/**
 *
 * @author jameswilliams
 */
public class StringDemo 
{
  public static void main ( String [] args )
  {
    String s1 = new String( "OOP in Java " );
    System.out.println( "s1 is: " + s1 );
    String s2 = "is not that difficult. ";
    System.out.println( "s2 is: " + s2 );

    String s3 = s1 + s2; // new String is s1, followed by s2
    System.out.println( "s1 + s2 returns: " + s3 );

    System.out.println( "s1 is still: " + s1 ); // s1 is unchanged
    System.out.println( "s2 is still: " + s2 ); // s2 is unchanged

    String greeting1 = "Hi"; // instantiate greeting1
    System.out.println( "\nThe length of " + greeting1 + " is "
                        + greeting1.length( ) );

    String greeting2 = new String( "Hello" ); // instantiate greeting2
    int len = greeting2.length( );  // len will be assigned 5
    System.out.println( "The length of " + greeting2 + " is " + len );

    String empty = new String( );
    System.out.println( "The length of the empty String is "
                        + empty.length( ) );

    String greeting2Upper = greeting2.toUpperCase( );
    System.out.println( );
    System.out.println( greeting2 + " converted to upper case is "
                        + greeting2Upper );

    String invertedName = "Lincoln, Abraham";

    int comma = invertedName.indexOf( ',' ); // find the comma
    System.out.println( "\nThe index of " + ',' + " in "
                        + invertedName + " is " + comma );

    // extract all characters up to comma
    String lastName = invertedName.substring( 0, comma );
    System.out.println( "Dear Mr. " + lastName );
  }
}
