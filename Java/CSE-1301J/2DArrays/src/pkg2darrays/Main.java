package pkg2darrays;

/**
 *
 * @author ryanwilliams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int testArray[][]= { {1, 3, 4, 5} , {4, 8, 9, 1} };
        int sum = 0;
        for(int row = 0; row < 2; row++)
        {
            for(int col = 0; col < 4; col++)
            {
                sum += testArray[row][col];
                System.out.print(testArray[row][col] + " ");
            }
        }
        
        System.out.print("\n" + sum + "\n");
        
        for(int col = 0; col < 4; col++)
        {
            for(int row = 0; row < 2; row ++)
            {
                sum += testArray[row][col];
                System.out.print(testArray[row][col] + " ");
            }
        }
        System.out.print("\n" + sum + "\n");
    }
}
