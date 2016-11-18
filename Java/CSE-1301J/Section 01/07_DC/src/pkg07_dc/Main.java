/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg07_dc;

/**
 *
 * @author jameswilliams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double [][] bills={ {45.24, 54.67, 32.55, 25.61},
                                {65.29, 49.75, 32.08, 26.11},
                                {75.24, 54.53, 34.55, 28.16}};
double z=0;
   for(int j=0; j < bills[0].length; j++)
    {
     z=z+bills[0][j];
    }
   System.out.println("bills:" + z);
    }
}
