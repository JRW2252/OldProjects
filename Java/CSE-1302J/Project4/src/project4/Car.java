// Program Name:      Car.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project#4
// Due Date:          28/October/2013
// Purpose:           Read list of cars and sold cars from file
// distinguish the difference between a car and sold car. 
// calculats profit of cars sold. Distinguishes the similar cars
// and prints them out. 
package project4;

import java.util.Objects;

/**
 *
 * @author ryanwilliams
 */
public class Car {
    protected int idNum, year; 
    private double dealerCost;
    private Date dateArrived; 
    private String makeModel; 
    
    public Car()
    {
        dealerCost = 0.00;
        idNum = 0; 
        year = 0; 
        dateArrived = null;
        makeModel = null;
    }
    public Car(int y, Date dA, String m)
    {
      year = y; 
      dateArrived = dA;
      makeModel = m;
    }
    public Car(double dc, int id, int y, Date d, String m)
    {
        dealerCost = dc; 
        idNum = id; 
        year = y; 
        dateArrived = d; 
        makeModel = m; 
    }
    public double getDealerCost()
    {
        return dealerCost; 
    }
    public int getIDNum()
    {
      return idNum; 
    }
    public int getYear()
    {
        return year; 
    }
    public Date getDateArrived()
    {
        return dateArrived; 
    }
    public String getMakeModel()
    {
        return makeModel; 
    }
    
// Compare Year, dateArrived, and makeModel 
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Car))
            return false; 
        else {
            Car obj = (Car)o;
            if(year-obj.year == 0 
                    && dateArrived.equals(obj.dateArrived) 
                    && makeModel.equalsIgnoreCase(obj.makeModel))
                return true; 
            else return false; 
        }
    }
    
  @Override
  public String toString()
  {
      return "\nCar\n"+dealerCost
              +"\n"+idNum+"\n"+year
              +"\n"+dateArrived+"\n"+makeModel;
  }
}
