/*
 * @author James Ryan Williams
 * 
 * Builds arrays from the file voting_2008.txt. 
 * Sorts information in file into rows/columns. 
 * 
 */
package cse1301_07_smallprogram;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;


/**
 *
 * @author ryanwilliams
 */
public class CSE1301_07_smallProgram 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        //original import from tutorial
        File election = new File("voting_2008.txt");
        Scanner sc = new Scanner(election);
       
        //original array from tutorial
        String [] states = new String [51];
        int [][] votes = new int[51][3];
        
       
        //totals array initialized
        //will be used to store the candidates totals and total of casted votes
        int [] totals = new int [4];//totals is the totals for candidates
        int [] rowT = new int [51];//rowT stands for row total
        
        
        //original loops from tutorial
        for(int s=0; s < 51; s++)
        {
            states [s] = sc.nextLine();            
        }
        
        for(int c=0; c < 3; c++)
        {
            //initialize candidate totals
            int cT = 0;
            
            for(int s=0; s < 51; s++)
            {
                votes[s][c] = sc.nextInt();
                //adding candidates totals
                cT += votes[s][c];
            }
            //candidate totals stored in array "totals" @ 0-2.
            totals[c] = cT;
        }
        

        
        Formatter fmtr = new Formatter();
        fmtr.format("%20s%12s%12s%12s", "State", "Obama", "McCain", "Other\n");
        System.out.println(fmtr);

        
        for(int s=0; s < 51; s++)
        {
            int rSum = 0;//initialize rSum or "row sum"
            fmtr = new Formatter();
            fmtr.format("%20s", states[s]);
            System.out.print(fmtr);
            for (int c=0; c < 3; c++)
            {
                rSum += votes[s][c];//adding the columns of the rows
                rowT [s] = rSum;//declare the sum to the array "rowT."
                fmtr = new Formatter();
                fmtr.format("%12d", votes[s][c]);
                System.out.print(fmtr);
            }
            System.out.println();
        }
        
        //add array "totals" @ 0-2 for total votes cast in election.
        //value in array "totals: @ 3.
        totals[3] = totals[0] + totals[1] + totals[2];
        
        //format the printout of the array "totals."
        fmtr = new Formatter();
        fmtr.format("\n\tTotals:%17d%12d%12d\n\tAll Votes:%12d", 
                totals[0],totals[1],totals[2],totals[3]);
        System.out.print(fmtr + "\n\n");
        
        //printout of total votes cast per state
        for(int s=0; s < 51; s++)
        {
            fmtr = new Formatter();
            fmtr.format("\n%20s%12d", states[s], rowT[s]);
            System.out.print(fmtr);
        }
    }

}

