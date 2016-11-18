package RecursionExamplesFromClass;

// Program Name:      Condo.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class Condo extends House
{
  public int connectedUnits;
  
  public Condo()
  {
    super();
    connectedUnits = 0; 
  }
  public Condo(int newListingNum, double newPrice, int newConUnits)
  {
    super(newListingNum, newPrice);
    connectedUnits = newConUnits;
  }

  public double getPrice()
  {
    return price;
  }
  public int getListingNum()
  {
    return listingNum;
  }
  public int getConnectedUnits()
  {
    return connectedUnits; 
  }
  public String toString()
  {
    return super.toString()+", Number of connected unints: "+connectedUnits;
  }
  public boolean sameListingNum(Object other)
  {
    if(!(other instanceof House))
      return false; 
    else {
      House objHouse = (House)other;
      if(listingNum - objHouse.getListingNum() == 0)
      {
        System.out.println("Same listing numbers: "
        +listingNum+", "+objHouse.getListingNum());
        return true;
      }
      else 
        return false;
    }
  }
}
