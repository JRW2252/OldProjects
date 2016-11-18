//gesick
//cse1302J
//demo of selected string method
import java.util.ArrayList;
import java.util.Scanner;

public class StringDemo
{

   public static void main(String [] args)
   {
      String letters="abcdef";
      String punctuation =",:;.";
      String river = "Mississippi";
      String word1= "Hello.";
      String group ="hello goodbye this is for   a test of split and trim.";
   
   //using indexOf to check the last symbol to see if it is a punctuation mark
   // if the letter is contained in the string, it returns the index value,
   //   otherwise it returns -1
   // uses substring to get the last letter
   
      String last= word1.substring(word1.length()-1);
      int punct= punctuation.indexOf(last);
      if(punct>=0)
      {
         System.out.println("last letter, \""+last+"\" is a punctation mark");
         
         //use substring to remove punctuation mark
         word1=word1.substring(0,word1.length()-1);
         System.out.println("the revised word1 is: "+ word1);
      }
      else
         System.out.println("last letter is not a punctation mark");
         
   
   //uses contains to determine if a letter of word1 is contained in the string letters
   //contains returns true if the parameter is within the string otherwise false
   
      for(int i=0; i<word1.length();i++)
      {
         boolean hasLetter= letters.contains(word1.substring(i,i+1));
         if(hasLetter)
         {
            System.out.println(word1+" has the letter "+word1.substring(i,i+1));
         }
      }
   //uses charAt(index position) to extract individual characters which can then be compared using ==
   
      for(int i=0; i<word1.length();i++)
      {
         char temp= word1.charAt(i);
        
         if(temp=='a' || temp== 'b' || temp== 'c'||
                   temp=='d' || temp== 'e')
         {
            System.out.println(word1+" has the letter "+word1.substring(i,i+1));
         }
      }
      
   //uses replace to replace all occurences of the first parameter (p) with 
   //the second parameter (sp)in the string Mississippi
     
      river= river.replace("p","sp");
      System.out.println(river+" ");
   
   //uses substring to create a new string with the first thru 4th 
   //letters of the contents of river 
   
      String river2= river.substring(0,4);
      System.out.println("the substring is: "+river2);
      
   //uses substring to create a new string with the all the letters 
   //except for the first one of river 
   
      String river3= river.substring(1);
      System.out.println("the substring, minus the first letter, is: "+river3);
   
   //this is a test of the split command, splitting the string group by
   //whitespace only.  Without using the trim command multiple blanks may cause
   //empty words
      System.out.println("\n  using split without trim\n");
      String [] myWords= group.split(" ");
      for( String w : myWords)
         System.out.println(w);
         
      //this is a test of the split command, splitting the string group by
   //whitespace only.  Using the trim command to remove extra whitespace
   //trim may leave empty strings within the array.  To elilminate them,
   //use an if statement to test for that condition
   //the continue statement causes the program to skip all remaining lines to 
   //the bottom of the loop
   
      System.out.println("\n  using split with trim\n");
      String [] myWords1= group.split(" ");
      ArrayList<String> trimmedWords= new ArrayList<String>(); 
      for(int i=0; i<myWords1.length;i++)
      {
         String w= myWords1[i].trim();
         if(w.equals(""))
            continue;
         trimmedWords.add(w);
      
      }
      for( String w : trimmedWords)
         System.out.println(w);
    
         //this is a test using scanner to accept data from the key board 
         //and display it as individual tokens.
         // using scanner in this way may require a special delimeter at the
         //end of the string so the loop terminates.  
         //Not necessary when reading files
         
      Scanner scan = new Scanner(System.in);
      System.out.println("enter a phrase with a space ( or more ) between words. "+ 
         "enter // to end the loop");
      while(scan.hasNext())
      {
         String w = scan.next();
        
         if(w.equals("//"))
            break;
         System.out.println(w);
      }
      scan.close();
      String sentence="this is the  result of   using scanner    on a string     with spaces";
      Scanner scan2= new Scanner(sentence);
      System.out.println("\nusing scanner on a string\n");
   
      while(scan2.hasNext())
      {
         String w = scan2.next();
         System.out.println(w);
        
      }
   
   }


}