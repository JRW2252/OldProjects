package factorials;

// Program Name:      Factorials.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Lab7
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

import java.util.Scanner;
 
public class Factorials {
    public static void main(String[] args){
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);

        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            System.out.print("Enter an integer: ");
            try {
                int val = scan.nextInt();
                System.out.println("Factorial(" + val + ") = "
                           + MathUtils.factorial(val));
            } catch(Exception IllegalArgumentException) {
                System.err.println( IllegalArgumentException);
            }
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
    }
}
