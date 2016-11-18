package listtest;

// Program Name:      ListTest.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

// ****************************************************************
// ListTest.java
//
// A simple test program that creates an IntList, puts some
// ints in it, and prints the list.
//         
// ****************************************************************
 
public class ListTest
{
    public static void main(String[] args)
    {
      IntList myList = new IntList(10);
      myList.add(100);
      myList.add(50);
      myList.add(200);
      myList.add(25);
      System.out.println(myList);
     
      // Add the commands to test the SortedIntList data here
      SortedIntList mySort = new SortedIntList(10);
      mySort.add(100);
      mySort.add(50);
      mySort.add(200);
      mySort.add(25);
      System.out.println(mySort);
      
      SortedIntList mySort1 = new SortedIntList(10);
      mySort1.add(7);
      mySort1.add(7);
      mySort1.add(6);
      mySort1.add(5);
      mySort1.add(4);
      mySort1.add(3);
      mySort1.add(2);
      mySort1.add(1);
      System.out.println(mySort1);
      
      SortedIntList mySort2 = new SortedIntList(10);
      mySort2.add(1);
      mySort2.add(105);
      mySort2.add(63);
      mySort2.add(41);
      mySort2.add(250);
      mySort2.add(77);
      mySort2.add(6);
      System.out.println(mySort2);
    }
 
}