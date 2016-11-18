// Program Name ReadabilityScale.java / Class: Word.java
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

public class Word {
    
    private char vowels [] = {'a','e','i','o','u','y','A','E','I','O','U','Y'};
    private char punctuation [] = {'!','?','.',';',':','(',')','"'};
    private String edLevel = "";
    private static int wordCount = 0;
    private static int sentCount = 0;
    private static int syllCount = 0;
    private static float index = 0;

    public Word(String w)
    {
        // Remove numbers
        w = w.replaceAll("[0-9]", "");
        // Remove non sentence ending characters
        w = w.replaceAll("-", "");
        w = w.replaceAll(",", "");
        w = w.replaceAll("_", "");
        w = w.replaceAll("'", "");

        StringBuilder tempWord = new StringBuilder(w);
        if(tempWord.length() > 0)
        {
            for(int i=0; i<tempWord.length(); i++)
            {
                if(tempWord.charAt(i) == punctuation[5] || 
                        tempWord.charAt(i) == punctuation [6] || 
                        tempWord.charAt(i) == punctuation[7])
                    tempWord = tempWord.deleteCharAt(i);
            }
            w = tempWord.toString();
        }
        // Skip over blank tokens
        if(w.contains(" ") || w.length() < 1)
                return;
            else
                wordCount++;
        
        // Count sentences
        for(int i = 0; i < 5; i++)
            if(w.charAt(w.length()-1) == punctuation[i])
                sentCount++;
        
        // Count all syllables 
        if(w.length() > 2)
        {
            for(int i = 0; i < vowels.length; i++)
                for(int j = 0; j < w.length()-1; j++) 
                    if(vowels[i] == w.charAt(j))
                        syllCount++;
        }
        
        // Calcuation for the legability index
        index = (float) ((206.835 - 84.6 * (float)syllCount / wordCount)-
                        (1.015 * (float)wordCount / sentCount));
        
        // Assign the string according to the 
        // appropriate index value 
        if(index <= 100 && index >=91)
            edLevel = ("5th Grader");
        if(index <= 90 && index >= 81)
            edLevel = ("6th Grader");
        if(index <= 80 && index >= 71)
            edLevel = ("7th Grader");
        if(index <= 70 && index >= 66)
            edLevel = ("8th Grader");
        if(index <= 65 && index >= 61)
            edLevel = ("9th Grader");
        if(index <= 60 && index >= 51)
            edLevel = ("High School Student");
        if(index <= 50 && index >= 31)
            edLevel = ("College Student");
        if(index <= 30 && index >= 0)
            edLevel = ("College Graduate");
        if(index < 0)
            edLevel = ("Law School Graduate");
    }
    
    // returning sentenceCount
    public int getSetenceCount()
    {
        return sentCount;
    }
    
    // returning wordCount
    public int getWordCount()
    {
        return wordCount;
    }
    
    // returning syllableCount
    public int getSyllableCount()
    {
        return syllCount;
    }
    
    // returns the calculated index value 
    public float getIndex()
    {
        return index; 
    }
    
    // returns the string assigned to the 
    // appropriate index
    public String getReadIndex()
    {
        return edLevel; 
    }
}
