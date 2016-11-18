package smallproject;

// Program Name:      SmallProject.java

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

        String nums = "", letters = "", spchars = "";

        Scanner scan = new Scanner(System.in);
        System.out.print("Type a string: ");
        String s = scan.nextLine();

        s = s.replaceAll(" ", "");

        nums = s.replaceAll("[-+.;()*&%'/$#@!?<>_=^:,^]","");
        nums = nums.replaceAll("[a-zA-Z]", "");

        letters = s.replaceAll("[0-9]","");
        letters = letters.replaceAll("[-+.;()*&%'/$#@!?<>_=^:,^]","");

        spchars = s.replaceAll("[a-zA-Z]","");
        spchars = spchars.replaceAll("[0-9]","");

        System.out.println("\n"+nums + "\t" + letters + "\t" + spchars);

    }
}
