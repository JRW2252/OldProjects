/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jameswilliams
 */
public class VariablesClass 	
{
  public static void main( String [] args )
  {
    // This example shows how to declare and initialize variables

    int testGrade = 100;
    long cityPopulation = 425612340L;
    byte ageInYears = 19;

    float  salesTax = .05F;
    double interestRate = 0.725;
    double avogadroNumber = +6.022E23;
    // avogadroNumber is represented in scientific notation;
    //     its value is 6.022 x 10 to the power 23

    char finalGrade = 'A';
    boolean isEmpty = true;

    System.out.println( "testGrade is " + testGrade );
    System.out.println( "cityPopulation is " + cityPopulation );
    System.out.println( "ageInYears is " + ageInYears );
    System.out.println( "salesTax is " + salesTax );
    System.out.println( "interestRate is " + interestRate );
    System.out.println( "avogadroNumber is " + avogadroNumber );
    System.out.println( "finalGrade is " + finalGrade );
    System.out.println( "isEmpty is " + isEmpty );
  }
 }