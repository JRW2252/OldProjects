package inheritanceandfiles;

// Program Name:      Car.java

import java.util.Objects;

// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class Car
{
    private double dealerCost;
    protected int idNumber;
    protected int modelYear;
    private Date dateArrived; 
    private String makeModel;
    
    public Car()
    {
        dealerCost = 0.00;
        idNumber = 0; 
        modelYear = 0; 
        dateArrived = null;
        makeModel = null;
    }
    
    public Car(double newDealerCost, int newIDNumber, int newModelYear,
            Date newDateArrived, String newMakeModel)
    {
        dealerCost = newDealerCost; 
        idNumber = newIDNumber; 
        modelYear = newModelYear; 
        dateArrived = newDateArrived; 
        makeModel = newMakeModel; 
    }
    // accessor
    public double getDealerCost()
    {
        return dealerCost;
    }
    // accessor
    public int getIDNumber()
    {
        return idNumber;
    }
    // accessor
    public int getModelYear()
    {
        return modelYear;
    }
    // accessor
    public Date getDateArrived()
    {
        return dateArrived; 
    }
    // accessor
    public String getMakeModel()
    {
        return makeModel;
    }
    @Override
    public String toString()
    {
        return "\nCar: Dealer cost: $"+dealerCost
                +", Car id number: "+idNumber
                +", Make model: "+ makeModel+", Year: "+modelYear
                +", Arrival date: "+dateArrived;
    }
     // Compare modelYear, dateArrived, and makeModel    
    @Override
    public boolean equals(Object o)
    {
                Car obj = (Car)o; 
                if(modelYear - obj.modelYear != 0) 
                    return false; 
                if (!(dateArrived.equals(obj.dateArrived)))
                    return false; 
                if (!(makeModel.equalsIgnoreCase(makeModel)))
                    return false; 
                else 
                    return true; 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.modelYear;
        hash = 59 * hash + Objects.hashCode(this.dateArrived);
        hash = 59 * hash + Objects.hashCode(this.makeModel);
        return hash;
    }
}
