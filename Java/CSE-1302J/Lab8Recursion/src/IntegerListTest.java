// Program Name:      IntegerListTest.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
import java.util.Scanner;
 
public class IntegerListTest
{
    static IntegerList list = new IntegerList(10);
    static Scanner scan = new Scanner(System.in);
 
    // ------------------------------------------------------------------
    //   Creates a list, then repeatedly print the menu and do what the
    //   user asks until they quit.
    // ------------------------------------------------------------------
    public static void main(String[] args)
    {
      printMenu();
      int choice = scan.nextInt();
      while (choice != 0)
          {
            swOptions(choice);
            printMenu();
            choice = scan.nextInt();
          }
    }
 
    // -------------------------------------
    //  Does what the menu item calls for.
    // -------------------------------------
    public static void swOptions(int choice)
    {
      int loc;
      switch(choice)
          {
          case 0:
            System.out.println("Bye!");
            break;
          case 1:
            System.out.println("How big should the list be?");
            int size = scan.nextInt();
            list = new IntegerList(size);
            list.randomize();
            break;
          case 2:
            list.selectionSort();
            break;
          case 3:
            System.out.print("Enter the value to look for: ");
            loc = list.linearSearch(scan.nextInt());
            if (loc != -1)
                System.out.println("Found at location " + loc);
            else
                System.out.println("Not in list");
            break;
          case 4:
            list.print();
            break;
          case 5:
            System.out.println("Enter a value to look for: ");
            int target = list.linearSearchRec(scan.nextInt());
            if(target != -1)
              System.out.println("Found at location "+ target);
            else
              System.out.println("Not in list");
            break;
          case 6:
            System.out.println("Enter a value to look for: ");
            target = list.binarySearch(scan.nextInt());
            list.binarySearch(target);
            if(target != -1)
              System.out.println("Found at location "+ target);
            else
              System.out.println("Not in list");
            break; 
          case 7:
            System.out.println("Enter a value to look for: ");
            target = list.binarySearchRec(scan.nextInt());
            if(target != -1)
              System.out.println("Found at location "+ target);
            else
              System.out.println("Not in list");
            break;
          //add case 5 and 6 and 7
          default:
            System.out.println("Sorry, invalid choice");
          }
    }
 
    // -------------------------------------
    //   Prints the menu of user's choices.
    // -------------------------------------
    public static void printMenu()
    {
      System.out.println("\n   Menu   ");
      System.out.println("   ====");
      System.out.println("0: Quit");
      System.out.println("1: Create new list elements (** do this first!! **)");
      System.out.println("2: Sort the list using selection sort");
      System.out.println("3: Find an element in the list using linear search");
      System.out.println("4: Print the list");
      System.out.println("5: Linear recursive search");
      System.out.println("6: Binary search");
      System.out.println("7: Binary recursive search");
      System.out.print("\nEnter your choice: ");
    }
 
}
