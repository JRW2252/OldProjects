// Program Name:      Main.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# 5
// Due Date:          18/11/2013
// ----------------------------------------------------------------------
// Purpose:           Inports a list of data (last name, 
// first name, and phone numbers), and adds them into arrays. 
// One array for simple initial import, one for sorted alphabetically 
// (last name, first name), and the last for sorted numerically
// (phone numbers). Then provide the user a means to search for a persons
// phone number via entering their name, and a means to search for a 
// persons name associated with a phone number. 
// ----------------------------------------------------------------------          


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main 
{
    
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) 
  {
    Person [] list = new Person[1000];
    Person [] pBook = new Person[1000];
    Person [] pBook1 = new Person[1000];
    try
    {
      String line;
      int count = 0;
//       Using Scanner, read in the file "PhoneList.txt"
//       one line at a time. Then split each line into 
//       an String array (info), and assign each variable
//       it's index. 
//       Using the info array, assign each index position 
//       to a Person. Then add the new person jDoe to the 
//       phoneBook array, and incrament the count to prime
//       the phonBook for the next person. 
      Scanner sc = new Scanner(new File("PhoneList.txt"));
      while (sc.hasNextLine())
      {
         line = sc.nextLine();
         String [] info = line.split(" ");
         Person jDoe = new Person(info[0], info[1], (info[2]+" "+info[3]));
         list[count] = jDoe;
         pBook[count] = jDoe;
         pBook1[count] = jDoe;
         count++;
      }

    }
    catch(FileNotFoundException exception)
    {
       System.out.println("file not found");
    }
    // Sort pBook alphabetically and
    // sort pBook numerically.
    SearchSort.insertionSortName(pBook);
    SearchSort.insertionSortNums(pBook1);
    
    int choice;
    do{
      printFormat();
      choice = sc.nextInt();
      if(choice == 1){
        printList(list);
      }
      if(choice == 2){
        printList(pBook);
      }
      if(choice == 3){
        printList(pBook1);
      }
      if(choice == 4){ 
        System.out.println("Type name using 'Last First' format");
        String name = sc.next().concat(" ").concat(sc.next());
        System.out.println(SearchSort.binaryWithName(pBook, name));
      }
      if(choice == 5){
        System.out.println("Type phone number using ### ###-#### format");
        String num = sc.next().concat(" ").concat(sc.next());
        System.out.println(SearchSort.binaryWithNumber(pBook1, num));
      }      
      } while(choice != 0);
  }
    
  // Method for printing Person arrays
  public static void printList(Person[]o)
  {
    for(int i = 0; i < o.length; i++)
      System.out.println(i + ": "+o[i]);
  } 
  
  public static void printFormat()
  {
    System.out.println("\n-----------------------------------------");
    System.out.println("0: Quit ");
    System.out.println("1: Print original list");
    System.out.println("2: Print alphabetically sorted list");
    System.out.println("3: Print numerically sorted list");
    System.out.println("4: Search using a name for a phone number"
            + "\n\tName format: 'Last First'");
    System.out.println("5: Search using a phone number for a name"
            + "\n\tNumber format: ### ###-####");
    System.out.println("-----------------------------------------\n");    
  }
}