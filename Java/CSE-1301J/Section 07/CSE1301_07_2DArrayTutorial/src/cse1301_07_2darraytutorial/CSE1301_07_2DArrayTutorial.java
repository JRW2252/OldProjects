/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse1301_07_2darraytutorial;

/**
 *
 * @author ryanwilliams
 */
public class CSE1301_07_2DArrayTutorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] data = new int[10][20];
        
        for(int row=0; row <10; row++)
        {
            for(int col=0; col <20; col++)
            {
                System.out.print(data[row][col] +"");
            }
            System.out.println();
        }
        System.out.println();
        
        data[1][4] = 6;
        
                for(int row=0; row <10; row++)
        {
            for(int col=0; col <20; col++)
            {
                System.out.print(data[row][col] +"");
            }
            System.out.println();
           
        }
        System.out.println();
        
    }
}
