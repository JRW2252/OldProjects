package RecursionExamplesFromClass;

// Program Name:      House.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class House implements Comparable<House>
{
  public int listingNum;
  public double price; 
  
  public House()
  {
    listingNum = 0; 
    price = 0.00; 
  }  
  public House(int newListingNum, double newPrice)
  {
    listingNum = newListingNum;
    price = newPrice; 
  }  
  public int getListingNum()
  {
    return listingNum;
  }  
  public double getPrice()
  {
    return listingNum; 
  }
  public String toString()
  {
    return ("Listing number: "+listingNum+", Price: "+price);
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
  @Override
  public int compareTo(final House o) 
  {
      return listingNum - o.listingNum;
  }
}
