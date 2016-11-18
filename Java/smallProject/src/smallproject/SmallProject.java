package smallproject;

// Program Name:      SmallProject.java

import java.util.ArrayList;
import java.util.Scanner;

// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

public class SmallProject 
{
    public static void main(String[] args) 
    {
        //--------------------------------------------------------------------------//
        // using arraylists for the alternative method / implementation
        ArrayList<Character>letter = new ArrayList<>();
        ArrayList<Character>number = new ArrayList<>();
        ArrayList<Character>special = new ArrayList<>();
        //--------------------------------------------------------------------------//
        // using the character arrays to determine where characters belong
        char[]lets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
            't','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
        char[]numbs={'0','1','2','3','4','5','6','7','8','9'}; 
        char[]specs={'"','[',']','{','}','-','+','.',';','(',')','*','&','%','/','$','#','@','!','?',
            '<','>','_','=','^',':',','};
        //--------------------------------------------------------------------------//
        String nums = "", letters = "", spchars = "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Type a string: ");
        String s = scan.nextLine();
        String sAlt = s; 
        //--------------------------------------------------------------------------//
        s = s.replaceAll(" ", "");
        nums = s.replaceAll("[-+.;()*&%'/$#@!?<>_=^:,^]","");
        nums = nums.replaceAll("[a-zA-Z]", "");
        //--------------------------------------------------------------------------//
        letters = s.replaceAll("[0-9]","");
        letters = letters.replaceAll("[-+.;()*&%'/$#@!?<>_=^:,^]","");
        //--------------------------------------------------------------------------//
        spchars = s.replaceAll("[a-zA-Z]","");
        spchars = spchars.replaceAll("[0-9]","");
        String toPrint = ("|  Original method: "+nums + "  " + letters + "  " + spchars+"  |");
        for (int i = 0; i < toPrint.length(); i++) {
            System.out.print("-");
        }
        System.out.println("\n"+toPrint);
        //--------------------------------------------------------------------------//
        System.out.print("| Alternate method: ");
        for (int i = 0; i < sAlt.length(); i++) {
            char p = sAlt.charAt(i);
            // letter arraylist
            for (int j = 0; j < lets.length; j++) {
                if (p==lets[j]) {
                    letter.add(p);
                }
            }
            // number arraylist
            for (int j = 0; j < numbs.length; j++) {
                if (p==numbs[j]) {
                    number.add(p);
                }
            }
            // special arraylist
            for (int j = 0; j < specs.length; j++) {
                if (p==specs[j]) {
                    special.add(p);
                }
            }
        }
        //--------------------------------------------------------------------------//
        for(Character ch: number)
            System.out.print(ch);
        System.out.print("  ");
        for(Character ch: letter)
            System.out.print(ch);
        System.out.print("  ");
        for(Character ch: special)
            System.out.print(ch);
        System.out.print("  |\n");
        for (int i = 0; i < toPrint.length(); i++) {
            System.out.print("-");
        }
        System.out.print("\n\n");
    }
}
