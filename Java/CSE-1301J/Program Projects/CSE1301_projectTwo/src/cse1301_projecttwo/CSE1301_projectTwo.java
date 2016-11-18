/*
 * Simulation of rolling two die at the number of user imput times.
 */
package cse1301_projecttwo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ryanwilliams
 */
public class CSE1301_projectTwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
{   
    //NEW SCANNER
    Scanner sc = new Scanner(System.in);
        
    //NEW RANDOM
    Random r = new Random();    
        
    //SIZE OF ARRAY DETERMINED BY USER
    System.out.print("Enter an integer: ");
    int size = sc.nextInt();
    
    //CREATE SUM VALUES FOR HISTOGRAM
    int two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0;
    int nine = 0, ten = 0, eleven = 0, twelve = 0, sum;

    String ast = "*";
        
    //CREATE ARRAY RANDOMS
    //INPUT INT SIZE FROM USER
    int [] die1 = new int [ size + 1 ];
    int [] die2 = new int [ size + 1 ];
    
    //CREATE ARRAY FOR SUMS
    int [] sums = new int [11];
    
    //CREATE ARRAY FOR HISTOGRAM
    String [] hist = new String [11];
    
    //ASSIGN ARRAY VALUES TO " "
    for(int h = 0; h < hist.length; h++)
    {
        hist[h] = "";
    }
    
    //SIMULATE ROLLING DICE
    for(int i = 1; i < die1.length; i++)
    {
        die1[i] = r.nextInt(6)+1;
        die2[i] = r.nextInt(6)+1;
        sum = die1[i] + die2[i];
        
        if(sum == 2) {
            two ++;
            sums[0] = two;
            hist[0] += ast;
        }
        if(sum == 3) {
            three ++;
            sums[1] = three;
            hist[1] += ast;
        }
        if(sum == 4) {
            four ++;
            sums[2] = four;
            hist[2] += ast;
        }
        if(sum == 5) {
            five ++;
            sums[3] = five;
            hist[3] += ast;
        }
        if(sum == 6) {
            six ++;
            sums[4] = six;
            hist[4] += ast;
        }
        if(sum == 7) {
            seven ++;
            sums[5] = seven;
            hist[5] += ast;
        }
        if(sum == 8) {
            eight ++;
            sums[6] = eight;
            hist[6] += ast;
        }
        if(sum == 9) {
            nine ++;
            sums[7] = nine;
            hist[7] += ast;
        }
        if(sum == 10) {
            ten ++;
            sums[8] = ten;
            hist[8] += ast;
        }
        if(sum == 11) {
            eleven ++;
            sums[9] = eleven;
            hist[9] += ast;
        }
        if(sum == 12) {
            twelve ++;
            sums[10] = twelve;
            hist[10] += ast;
        }
        //PRINT THE RESULTS FROM ROLLING DICE
        System.out.println(i +":" + "\tDie 1: " + die1[i] 
                + "\t Die2: " + die2[i] + "\tSum: " + sum);
    }
    //TEST RESULTS OF DICE ROLLS (ENDED UP PROVIDING A SPACE).
    System.out.println("\nTalley of sums from rolls.");
    
    //PRINT THE HISTOGRAM OF RESULTS FROM DICE ROLLS/SUMS
    for(int j=0; j < sums.length; j++)
    {   
        System.out.println(j+2 + ":\t" + hist[j]);
    }
    
}
}