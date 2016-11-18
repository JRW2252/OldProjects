// Program Name ReadabilityScale.java 
// Course: CSE 1302J
// Student Name: James Ryan Williams
// Assignment Number: Project1
// Due Date: 09/09/2013

// Purpose: Calculates the legability index of imported files
// Readability Scale scans a file that is chosen by means of 
// JFileChooser. File is scanned and scrubbed of all non word 
// characters and non-sentence ending characters. The individual 
// words are then counted and iterated through for a vowel count.
// The results are then printed onto the screen and the program is 
// then ended. 

package ReadabilityScale;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ReadabilityScale {

    public static void main(String[] args) throws IOException {

        int totalSent=0, totalSyl=0, totalW=0, readIndex = 0;
        String edLevel=""; 
        Scanner scan = null;
        
        //Create a file chooser
        
        JFileChooser fc = new JFileChooser();
        //
        //In response to a button click:
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) 
        {
            System.out.println("You chose to open the file: " +
            fc.getSelectedFile().getName());
            scan = new Scanner(fc.getSelectedFile());
            while (scan.hasNext())
            {
                Word word = new Word(scan.next());
                
                totalW = word.getWordCount();
                totalSyl = word.getSyllableCount();
                totalSent = word.getSetenceCount();
                readIndex = (int) word.getIndex();
                edLevel = word.getReadIndex();
            }
            scan.close();
            System.out.println("Words: "+totalW+
                    "\tSyllables: "+totalSyl+
                    "\t\tSentences: "+totalSent+
                    "\tLegability Index: "+readIndex+
                    "\n\nThis legability index is translated to "
                    + "the education level of a "+edLevel+"\n\n");
        }
    }
}
