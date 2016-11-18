// Program Name:      SoldCar.java
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
public class SoldCar extends Car{
    private double price; 
    private String customer; 
    private Date dateSold;
     public SoldCar()
    {
        super(); 
        price = 0;
        customer = "John Doe";
        dateSold = null;
    }
     // dealerCost, IDNum, DateArrived, year, makeModel, 
     // price, customer, dateSold
     public SoldCar(double dc, int id, 
            Date d, int y, String m, 
            double p, String c, Date newDS)
    {
        // call super constructor
        // for dealerCost, idNum, year, dateArrived, year
        super(dc, id, y, 
                d, m);
        year = y; 
        price = p; 
        customer = c; 
        dateSold = newDS; 
    }
     // idNum, price, customer, dateSold
    public SoldCar(int newID, double newP, 
            String newCustomer, Date newDS)
    {
        idNum = newID;
        price = newP; 
        customer = newCustomer; 
        dateSold = newDS; 
    }
    
    @Override
    public double getDealerCost()
    {
        return super.getDealerCost();
    }

    public int getIDNum()
    {
      return super.idNum;
    }
    
    @Override
    public Date getDateArrived()
    {
      return super.getDateArrived();
    }
    
    @Override
    public int getYear()
    {
      return super.year;
    }
    
    public String getMakeModel()
    {
      return super.getMakeModel();
    }
    
    public double getPrice()
    {
        return price; 
    }
    
    public String getCustomer()
    {
        return customer; 
    }
    
    public Date getDateSold()
    {
      return dateSold; 
    }
    
    // year, dateArrived, makeModel, and dateSold 
    @Override
    public boolean equals(Object o)
    {
      if(!(o instanceof SoldCar))
        return false; 
      else {
        SoldCar obj = (SoldCar)o;
        // date Arrived and makeModel 
        // producing error NPE! 
        if(year-obj.year==0 && dateSold.equals(obj.dateSold))
          return true; 
        else 
          return false; 
      }
    }
    
    @Override
    public String toString()
    {
        if(super.getDealerCost() > 0.0 && super.getDateArrived() != null 
                && super.getMakeModel() != null && super.getYear() > 0)
            return "\nSold car type 1\n$" + super.getDealerCost()
                    +"\n"+idNum+
                    "\n"+super.getDateArrived()
                    +"\n"+super.getMakeModel()
                    +"\n"+super.getYear()
                    +"\n$"+price+"\n"+customer
                    +"\n"+dateSold
                    +"\nProfit: $ "+calcProfit(price, super.getDealerCost());
        else
            return "\nSold car type 2\n"
                    +idNum
                    +"\n$"+price
                    +"\n"+customer
                    +"\n"+dateSold;
    }
    
    public double calcProfit(double a, double b)
    {
        double profit = a - b;
        return profit;
    }
}
