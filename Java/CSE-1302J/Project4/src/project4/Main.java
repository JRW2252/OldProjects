// Program Name:      Main.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project#4
// Due Date:          28/October/2013
// Purpose:           Read list of cars and sold cars from file
// distinguish the difference between a car and sold car. 
// calculats profit of cars sold. Distinguishes the similar cars
// and prints them out. 
package project4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ryanwilliams
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double price, dealerCost;
    int idNumber, day, year, arrivalYear, modelYear; 
    String line, month, makeModel, customer;
    Date dateArrived, dateSold; 
    String [] varSplit;
    ArrayList<Car> carLot = new ArrayList();
    ArrayList<Car> similars = new ArrayList();
    Car currentCar = new Car();

    BufferedReader br = null;
    try 
      {
        // read in DataFile.txt from project folder
        br = new BufferedReader(new FileReader("DataFile.txt"));
        // reading the file by line instead of using the read() method. 
        while ((line = br.readLine()) != null) 
        {
          // adding the lines into an array and indexing by 
          // seperated lines.
          String[] lines = line.split(System.getProperty("line.separator"));
          for(int i = 0; i < lines.length; i++)
          {
            Car dealerCar;
            // Checking for Car status as sold or not sold
            if(lines[i].charAt(0)=='C')// not sold status
            {
              lines[i] = lines[i].substring(1);
              varSplit = lines[i].split(" ");

              dealerCost = Double.parseDouble(varSplit[1]);
              idNumber = Integer.parseInt(varSplit[2]);
              day = Integer.parseInt(varSplit[4]);
              month = varSplit[3];
              arrivalYear = Integer.parseInt(varSplit[5]);
              year = Integer.parseInt(varSplit[6]);
              dateArrived = new Date(day, month, year);
              makeModel = varSplit[7];
              // create car
              dealerCar = new Car (dealerCost, idNumber, 
                      year, dateArrived, makeModel);
              // add car to arraylist
              carLot.add(dealerCar);
            }

            if(lines[i].charAt(0)=='S')// sold status
            {
              if(lines[i].charAt(1)=='1')// sold type 1 status
              {
                lines[i] = lines[i].substring(2);
                varSplit = lines[i].split(" ");

                idNumber = Integer.parseInt(varSplit[1]);
                price = Double.parseDouble(varSplit[2]);
                customer = varSplit[3];
                month = varSplit[4];
                day = Integer.parseInt(varSplit[5]);
                year = Integer.parseInt(varSplit[6]);
                dateSold = new Date(day, month, year);
                // assign values to Sold car
                dealerCar = new SoldCar (idNumber, price, 
                        customer, dateSold);
                // Add sold car to arraylist
                carLot.add(dealerCar);
              }
              else // sold type 2 status
              { 
                lines[i] = lines[i].substring(2);
                varSplit = lines[i].split(" ");

                dealerCost = Double.parseDouble(varSplit[1]);
                idNumber = Integer.parseInt(varSplit[2]);
                month = varSplit[3]; 
                day = Integer.parseInt(varSplit[4]);
                year = Integer.parseInt(varSplit[5]); 
                dateArrived = new Date(day, month, year);
                modelYear = Integer.parseInt(varSplit[6]);
                makeModel = varSplit[7]; 
                price = Double.parseDouble(varSplit[8]);
                customer = varSplit[9];
                month = varSplit[10];
                day = Integer.parseInt(varSplit[11]); 
                year = Integer.parseInt(varSplit[12]); 
                dateSold = new Date(day, month, year); 
                // assign values to Sold car
                dealerCar = new SoldCar(dealerCost, idNumber, dateArrived, 
                        modelYear, makeModel, price, customer, dateSold);
                // add sold car to the arrayList
                carLot.add(dealerCar);
              }
            }
              else continue;
            }
          }
        } catch (IOException e) {
        } finally {
          try
        {
        if (br != null)
        br.close();
        } catch (IOException ex) {
        }
    }
    // Print out entire list of cars 
    // That were read in from the file
    System.out.println("Listing of Cars\n");
    for(Car cars: carLot)
      System.out.println(cars);
    // Print out the list of idNumbers 
    // Assigned to multiple cars and 
    // the number of cars that have the idNumber. 
    System.out.println("\n\nList of Duplicate ID's");
    Map<Integer, List<Car>> groups = new HashMap<Integer, List<Car>>();
      for (Car car:carLot) {
         List<Car> groupID = groups.get(car.getIDNum());
         if (groupID == null) {
           groupID = new ArrayList<Car>();
           groups.put(car.getIDNum(), groupID);
         }
         groupID.add(car);
      }
      
      for (Map.Entry<Integer, List<Car>> entry:groups.entrySet()) 
      {
        if(entry.getValue().size()>1)
        {
          System.out.println("ID Number: "+entry.getKey()
                  +" \t# of duplicates "+entry.getValue().size());
        }
      }
    // Print out cars that are similar to one another that
    // are stored int the carLot arraylist. 
    System.out.println();
    for(int i = 0; i < carLot.size()-1; i++)
    {
      for(int j = i+1; j < carLot.size(); j++)
      {
        if(carLot.get(i).equals(carLot.get(j)))
          System.out.println("\n--Similar Cars--"+carLot.get(i)
                  +"\n------------"+carLot.get(j));
      }
    }
  }
}
