package ioexamplecode;

// Program Name:      IOExampleCode.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

    import java.io.FileReader;
   import java.io.File;
   import java.io.IOException;
   import java.util.Scanner;
   import java.io.FileNotFoundException;
   import java.io.FileWriter;
   import java.io.BufferedWriter;
   import java.io.BufferedReader;
   import javax.swing.JFileChooser;
   import javax.swing.JOptionPane;
   import java.util.Scanner;


public class IOExampleCode 
{  
      public static void main(String[] args)
      {
         usingFileReader();
         usingScannerandFileWriter();
         usingBufferedReader();
      }
   	
      public static void usingFileReader()
      {
         FileReader reader=null;
      
         try
         {         
            reader= new FileReader("input.txt");
            int next=reader.read();
            char c;
            String word="";
            while(next != -1)
            {
               c=(char)next;
               if(c==' ')
               {
                  System.out.println(word);
                  word="";
               }
               else
                  word+=c;
               next=reader.read();             
            }
            System.out.println(word);
         }
            catch(FileNotFoundException exception)
            {
               System.out.println("file not found");
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
      }
   	
      public static void usingScannerandFileWriter()
      {
         System.out.println("\n\nwith scanner\n");
         String inputLine="";
         String data[];
         Scanner scan= null;
         try
         {
            scan= new Scanner(new File("input.txt"));
            while(scan.hasNext())
            {
               inputLine+=scan.nextLine()+" ";
            }
         }
          
            catch(FileNotFoundException fnfe)
            {
               System.out.println("File not found");
            }
         finally
         {
            scan.close();
         }
      	
         data= inputLine.split(" ");
      		
         for(int i=0; i<data.length;i++)
            System.out.println(data[i]);	
      
      //writing test
         try
         {
            FileWriter fw= new FileWriter("output.txt",false);
            BufferedWriter bw= new BufferedWriter(fw);
            for(int i=0; i<data.length;i++)
            {
               bw.write(data[i]+" ");
            }
            bw.close();
            System.out.println("\n\nfile written but not closed");
         
         }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
      
      }
   	
      public static void usingBufferedReader()
      {
         File savedFile=null;
      
         String startFile="C:\\";
         JFileChooser chooser= new JFileChooser(startFile);
      
         JOptionPane.showMessageDialog(null,"Select the class file to load ");
         if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
            savedFile=chooser.getSelectedFile();
         if(savedFile==null)
         {
            JOptionPane.showMessageDialog(null,"No file selected, closing system");
            System.exit(0);
         }
         String temp="";
         
         try
         {
            FileReader reader = new FileReader(savedFile);
            BufferedReader in = new BufferedReader(reader);
            temp =in.readLine();
            while(temp != null)
            {
               String[] data = temp.split("\\s ");
            	
               for(String s :data)
                  System.out.print(s+" ");
            		
               System.out.println();
               temp = in.readLine();
            }
         
         }
            catch (IOException ioe)
            {
               ioe.printStackTrace();
            }
      }
}
