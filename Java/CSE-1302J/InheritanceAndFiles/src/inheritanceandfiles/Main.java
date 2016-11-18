package inheritanceandfiles;

// Program Name:      Main.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Read list of cars and sold cars from file
// distinguish the difference between a car and sold car. 
// calculats profit of cars sold. Distinguishes the similar cars
// and prints them out. 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main 
{
  public static void main(String[] args) throws IOException 
  {
    double price, dealerCost;
    int idNumber, day, year, arrivalYear, modelYear; 
    String line, month, makeModel, customer;
    Date dateArrived, dateSold; 
    String [] varSplit;
    ArrayList<Car> carLot = new ArrayList();
    ArrayList<Integer> sameId = new ArrayList();
    Car currentCar; 
    
    
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
              month = varSplit[3];
              day = Integer.parseInt(varSplit[4]);
              arrivalYear = Integer.parseInt(varSplit[5]);
              dateArrived = new Date(day, arrivalYear, month);
              year = Integer.parseInt(varSplit[6]);
              makeModel = varSplit[7];
              
              dealerCar = new Car (dealerCost, idNumber, 
                      year, dateArrived, makeModel);
              for(Car search: carLot)
              {
                  currentCar = search;
                  if(Math.abs(currentCar.getIDNumber()-dealerCar.idNumber)==0)
                  {
                      sameId.add(currentCar.getIDNumber());
                      sameId.add(dealerCar.idNumber);
                  }
              }
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
                dateSold = new Date(day, year, month);

                dealerCar = new SoldCar (idNumber, price, 
                        customer, dateSold);
                for(Car search: carLot)
              {
                  currentCar = search;
                  if(Math.abs(currentCar.getIDNumber()-dealerCar.idNumber)==0)
                  {
                      sameId.add(currentCar.getIDNumber());
                      sameId.add(dealerCar.idNumber);
                  }
              }
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
                dateArrived = new Date(day, year, month);
                modelYear = Integer.parseInt(varSplit[6]);
                makeModel = varSplit[7]; 
                price = Double.parseDouble(varSplit[8]);
                customer = varSplit[9];
                month = varSplit[10];
                day = Integer.parseInt(varSplit[11]); 
                year = Integer.parseInt(varSplit[12]); 
                dateSold = new Date(day, year, month); 

                dealerCar = new SoldCar(dealerCost, idNumber, dateArrived, 
                        modelYear, makeModel, price, customer, dateSold);
                for(Car search: carLot)
              {
                  currentCar = search;
                  if(Math.abs(currentCar.getIDNumber()-dealerCar.idNumber)==0)
                  {
                      sameId.add(currentCar.getIDNumber());
                      sameId.add(dealerCar.idNumber);
                  }
              }
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
    
    
    System.out.println("List of cars:");
    for(Car cars: carLot)
      System.out.println(((carLot.indexOf(cars)+1)+": "+cars));
//    System.out.println("\n\nList of Duplicate ID's");
//    Map<Integer, List<Car>> groups = new HashMap<Integer, List<Car>>();
//      for (Car car:carLot) {
//         List<Car> groupID = groups.get(car.getIDNumber());
//         if (groupID == null) {
//           groupID = new ArrayList<Car>();
//           groups.put(car.getIDNumber(), groupID);
//         }
//         groupID.add(car);
//      }
//      
//      for (Map.Entry<Integer, List<Car>> entry:groups.entrySet()) 
//      {
//        if(entry.getValue().size()>1)
//        {
//          System.out.println("ID Number: "+entry.getKey()
//                  +" \t# of duplicates "+entry.getValue().size());
//        }
//      }
//      groups.clear();
//      
//      
//      Car carA, carB;
//      System.out.print("\nSimilar cars");
//      for(int i = 0; i < carLot.size()-1; i++ )
//      {
//        carA=carLot.get(i);
//        for(int j = i+1; j < carLot.size(); j++)
//        {
//          carB=carLot.get(j);
//          if(carA.getIDNumber()-carB.getIDNumber() == 0 &&
//                  carA.getMakeModel().equals(carB.getMakeModel())
//                  && carA.getModelYear()-carB.getModelYear() == 0)
//          {
////            System.out.print("\n"+(i+1));
////            System.out.print(carA);
////            System.out.print("\n"+(j+1));
////            System.out.print(carB+"\n");
//          }
//        }
//      }
//      for(Integer same: sameId)
//          System.out.println(same);
  }
}