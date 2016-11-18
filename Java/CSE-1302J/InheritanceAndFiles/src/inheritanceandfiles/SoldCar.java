package inheritanceandfiles;

// Program Name:      SoldCar.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class SoldCar extends Car
{
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
    
    public SoldCar(double newDealerCost, int newIDNumber, 
            Date newDateArrived, int newModelYear, String newMakeModel, 
            double newPrice, String newCustomer, Date newDateSold)
    {
        super(newDealerCost, newIDNumber, newModelYear, 
                newDateArrived, newMakeModel);
        modelYear = newModelYear; 
        price = newPrice; 
        customer = newCustomer; 
        dateSold = newDateSold; 
    }
    
    public SoldCar(int newIDNumber, double newPrice, 
            String newCustomer, Date newDateSold)
    {
        this.idNumber = newIDNumber;
        price = newPrice; 
        customer = newCustomer; 
        dateSold = newDateSold; 
    }
    
    
    @Override
    public int getIDNumber()
    {
      return idNumber;
    }
    @Override
    public int getModelYear()
    {
        return modelYear; 
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
    
    public double calcProfit(double a, double b)
    {
        double profit = a - b;
        return profit;
    }
    
    @Override
    public String toString()
    {
        if(super.getDealerCost() > 0.0 && super.getDateArrived() != null 
                && super.getMakeModel() != null && super.getModelYear() > 0)
            return "\nSold car: Dealer cost: $" + super.getDealerCost()
                    +", Car id number: "+idNumber+
                    ", Date arrived: "+super.getDateArrived()
                    +", Make model: "+super.getMakeModel()+", year: "+super.getModelYear()
                    +"\nPrice: $"+price+", Customer: "+customer+", Date sold: "+dateSold
                    +", Dealer profit: $ "+calcProfit(price, super.getDealerCost());
        else
            return "\nSold car:Car id number: "+idNumber+
                    ", Price: $"+price+", Customer: "+customer
                    +", Date sold: "+dateSold;
    }
    
    // Returns true if have the same modelYear, 
    // dateArrived, makeModel, and dateSold.
//    public boolean equals(Object o)
//    {
//        if(!(o instanceof Car))
//            return false; 
//        else {
//            SoldCar obj = (SoldCar) o;
//            if(Math.abs(obj.getModelYear())==0
//                    &&super.getDateArrived().equals(obj.getDateArrived())
//                    &&super.getMakeModel().equals(obj.getMakeModel())
//                    &&dateSold.equals(obj.getDateSold()))
//                return true;
//            else
//                return false; 
//        }
//    }
    
}
    
