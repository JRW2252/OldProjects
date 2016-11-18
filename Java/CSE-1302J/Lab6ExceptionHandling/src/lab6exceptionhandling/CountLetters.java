package lab6exceptionhandling;

// Program Name:      CountLetters.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

import java.util.Scanner;

public class CountLetters
{
    public static void main(String[] args)
    {
      int[] counts = new int[26];
      Scanner scan = new Scanner(System.in);
 
      //get word from user
      System.out.print("Enter a phrase: ");
      String word = scan.nextLine();
 
      //convert to all upper case
      word = word.toUpperCase();
 
      //count frequency of each letter in string
      for (int i=0; i < word.length(); i++)
      {
          try{
          counts[word.charAt(i)-'A']++;
          }
          catch(Exception ArrayIndexOutOfBounds)
          {
              System.out.println(word.charAt(i)+" is not a letter");
          }
      }
      //print frequencies
      System.out.println();
      for (int i=0; i < counts.length; i++)
      {
          if (counts [i] != 0)
            System.out.println((char)(i +'A') + ": " + counts[i]);
          
      }
    }
 
}
