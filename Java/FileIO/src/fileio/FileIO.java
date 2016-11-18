package fileio;

/**
 *
 * @author jameswilliams
 */

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.swing.JFileChooser;

public class FileIO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select input file");
        int retVal = fc.showOpenDialog(null);
        
        if(retVal == JFileChooser.APPROVE_OPTION){
            FileWriter outFile;
            PrintWriter output;
            try (Scanner sc = new Scanner(fc.getSelectedFile())) {
                // get timestamp to append to file name
                String timestamp = LocalDateTime.now().toString();
                
                // new file with timestamp appended
                outFile = new FileWriter("DataFile"+timestamp+".csv");
                output = new PrintWriter(outFile);
                
                // initialize empty obj
                MonteCarloData MCData = new MonteCarloData();
                // write header on csv file
                output.println("Darts,Threads,Hits,Pi,Time");
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    
                    // skip empty lines
                    if(line.isEmpty() && sc.hasNextLine())
                        line = sc.nextLine();
                    
                    System.out.println(line);
                    int option = getOption(line); // 
                    int numbers = line.indexOf(" ")+1;
                    
                    // set data in line as obj attr
                    switch(option){ 
                        case 1: MCData.setDarts(line.substring(numbers));
                        break;
                        case 2: MCData.setThreads(line.substring(numbers));
                        break;
                        case 3: MCData.setHits(line.substring(numbers));
                        break;
                        case 4: MCData.setPi(line.substring(numbers));
                        break;
                        case 5: MCData.setTime(line.substring(numbers)); 
                        break;
                        default: break;
                    }
                    
                    // filled all obj attr's, write obj to file
                    if(option == 5){
                        // print toString to file then empty data obj
                        System.out.println(MCData.toString());
                        output.print(MCData.toString());
                        MCData.emptyData();
                    }
                }
                // close resources
            outFile.close();
            output.close();
            sc.close();
            }
        }
    }
    
    public static String savePath(){
        String path = "/"; 
        JFileChooser pathOut = new JFileChooser(); 
        pathOut.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        pathOut.setDialogTitle("Choose Save Location");
        
        return path; 
    }
    
    public static int getOption(String s){
        int option; 
        if(s.startsWith("Darts:"))
            option = 1; 
        else if(s.startsWith("Threads:"))
            option = 2;
        else if(s.startsWith("Hits:"))
            option = 3; 
        else if(s.startsWith("Pi:"))
            option = 4; 
        else if(s.startsWith("Time:"))
            option = 5; 
        else
            option = -1;
        
        return option;
    }
}