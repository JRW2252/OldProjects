package lab6searchingandsorting;

// Program Name:      IntegerListTest.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Lab#6
// Due Date:          07/10/2013
// Purpose:           Program purpose / description

import java.util.Scanner;
 
public class IntegerListTest
{
    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);
 
    //------------------------------------------------------
    // main -- creates an initial list, then repeatedly prints
    // the menu and does what the user asks until they quit
    //------------------------------------------------------
    public static void main(String[] args)
    {
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0)
            {
                dispatch(choice);
                printMenu();
                choice = scan.nextInt();
            }
    }
 
    //------------------------------------------------------
    // dispatch -- takes a choice and does what needs doing
    //------------------------------------------------------
    public static void dispatch(int choice)
    {
        long totalTime = 0, start = 0, end = 0; 
        int loc;
        int val;
        long time1, time2;
        switch(choice)
            {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println(list);
                break;
            case 2:
                System.out.println("How big should the list be?");
                list = new IntegerList(scan.nextInt());
                System.out.println("List is created.");
                break;
            case 3:
                list.randomize();
                System.out.println("List is filled with random elements.");
                break;
            case 4:
                list.fillSorted();
                System.out.println("List is filled with sorted elements.");
                break;
            case 5:
                System.out.print("Enter the value to look for: ");
                val = scan.nextInt();
                start = System.currentTimeMillis();
                loc = list.linearSearch(val);
                if (loc != -1)
                    System.out.println("Found at location " + loc);
                else
                   System.out.println("Not in list");
                end = System.currentTimeMillis();
                totalTime = (end - start);
                System.out.println("\nLinear search time was: " + totalTime + " ms");
                break;
            case 6:
                System.out.print("Enter the value to look for: ");
                val = scan.nextInt();
                start = System.currentTimeMillis();
                loc = list.binarySearch(val);
                if (loc != -1)
                    System.out.println("Found at location " + loc);
                else
                    System.out.println("Not in list");
                end = System.currentTimeMillis();
                totalTime = (end - start);
                System.out.println("\nBinary search time was: " + totalTime + " ms");
                break;
            case 7:
                start = System.currentTimeMillis();
                list.sortIncreasing();
                System.out.println("List has been sorted.");
                end = System.currentTimeMillis();
                totalTime = (end - start);
                System.out.println("\nSelection sort time was: " + totalTime + " ms");
                break;
            case 8:
                start = System.currentTimeMillis();
                list.sortDecreasing();
                end = System.currentTimeMillis();
                totalTime = (end - start);
                System.out.println("\nInsertion sort time was: " + totalTime + " ms");
                break;
            case 9:
                start = System.currentTimeMillis();
                list.enhancedBubbleSort();
                System.out.println("List has been sorted.");
                end = System.currentTimeMillis();
                totalTime = (end - start);
                System.out.println("\nBubble sort time was: " + totalTime + " ms");
                break;
 
            default:
                System.out.println("Sorry, invalid choice");
            }
    }
 
 
    //------------------------------------------------------
    // printMenu -- prints the user's choices
    //------------------------------------------------------
    public static void printMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Print the list");
        System.out.println("2: Create a new list of a given size");
        System.out.println("3: Fill the list with random ints in range 1-length");
        System.out.println("4: Fill the list with already sorted elements");
        System.out.println("5: Use linear search to find an element");
        System.out.println("6: Use binary search to find an element " +
              "(list must be sorted in increasing order)");       
        System.out.println("7: Use selection sort to sort the list into " +
              " increasing order");
        System.out.println("8: Use insertion sort to sort the list into " +
              " decreasing order");
        System.out.println("9: Use enhanced bubble sort to sort the "
                + "into increasing order");
        System.out.print("\nEnter your choice: ");
    }
}