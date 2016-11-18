package randombookdatagenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomBookDataGenerator 
{
    public static void main(String[] args) throws FileNotFoundException 
    {
        Random rNum = new Random();
        File fileIn = new File("publisherList.rtf");
        Scanner sc = new Scanner(fileIn);
        ArrayList <String> publishers = new ArrayList();
       
        while (sc.hasNextLine()) {
            publishers.add(sc.nextLine());
        }
        sc.close();
        String [] listPubs = new String[1001];
        
        for (int a = 0; a < listPubs.length; a++) {
            int rand = rNum.nextInt(publishers.size());
            listPubs[a] = publishers.get(rand);
            System.out.println(listPubs[a]);
        }
//        // ISBN-10, ISBN-13, Shelf Code, Publisher
//        // Above are variables that need to be produced
//        
        System.out.println("ISBN-10");
        System.out.println("----------");
        String ISBN10 [] = new String[10];
        String List10 [] = new String[1001];
        for (int i = 0; i < List10.length; i++) {
            String y = "";
            for (int j = 0; j < ISBN10.length; j++) {
                int x = rNum.nextInt(10);
                ISBN10[j] = Integer.toString(x);
                y = y.concat(ISBN10[j]);
            }
            List10[i] = y;
            System.out.println(y);
        }
        
        
        System.out.println("\n\nISBN-13");
        System.out.println("-------------");
        String ISBN13 [] = new String [13];
        String List13 [] = new String [1001];
        for (int k = 0; k < List13.length; k++) {
            String y =  "";
            for (int l = 0; l < ISBN13.length; l++) {
                int x = rNum.nextInt(10);
                ISBN13[l] = Integer.toString(x);
                y = y.concat(ISBN13[l]);
            }
            List13[k] = y;
            System.out.println(List13[k].substring(0, 3)+"-"+List13[k].substring(3));
        }
        System.out.println("\n\nShelf Code");
        System.out.println("----------");
        for (int a = 0; a < 1001; a++) {
            
        }
//        numBookCopies(1001);
        
            
    }
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    static String randomString( int len ) 
    {
       StringBuilder sb = new StringBuilder( len );
       for( int i = 0; i < len; i++ ) 
          sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
       return sb.toString();
    }
    static int [] numBookCopies(int num){
        int [] numCopies = new int [num];
        for (int i = 0; i < num; i++) {
            numCopies[i] = rnd.nextInt(5)+1;
            System.out.println(numCopies[i]);
        }
        return numCopies;
    }


}
