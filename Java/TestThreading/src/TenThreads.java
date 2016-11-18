
import java.util.Random;

/**
 * Creates ten threads to search for the maximum value of a large matrix.
 * Each thread searches one portion of the matrix.
 */

public class TenThreads {

    private static int[][] getBigHairyMatrix() {
        int [][] matrix = new int[100][100]; 
        
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix.length-1; j++) {
                Random r = new Random();
                int rand = r.nextInt(Integer.MAX_VALUE); 
                matrix[i][j] = rand; 
            }
        }
        return matrix; 
    }
    private static class WorkerThread extends Thread {
        int max = Integer.MIN_VALUE;
        int[] ourArray;
        public WorkerThread(int[] ourArray) {
            this.ourArray = ourArray;
        }
        // Find the maximum value in our particular piece of the array
        public void run() {
            for (int i = 0; i < ourArray.length; i++)
                max = Math.max(max, ourArray[i]);
        }
        public int getMax() {
            return max;
        } 
    }
    public static void main(String[] args) {
        WorkerThread[] threads = new WorkerThread[10];
        int[][] bigMatrix = getBigHairyMatrix();
        int max = Integer.MIN_VALUE;
        // Give each thread a slice of the matrix to work with
        for (int i=0; i < 10; i++) {
            threads[i] = new WorkerThread(bigMatrix[i]);
            threads[i].start();
        }
        // Wait for each thread to finish
        try {
            for (int i=0; i < 10; i++) {
                threads[i].join();
                max = Math.max(max, threads[i].getMax());
            } 
        }
        catch (InterruptedException e) {
            // fall through
        }
        System.out.println("Maximum value was " + max);
    }
}