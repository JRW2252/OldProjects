// Program Name       classname.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Lab2
// Due Date:          08/28/2013
// Purpose:           Simulate a shopping experience for the user.
/* 
*  User adds item name, price, then quantity to a shopping cart. 
*  Total price is added and displayed for the current items picked. 
*  User has the option to continue shopping and the items, prices, and
*  quantities are displayed after each item is added to cart. 
*  Ultimately, the user decides to stop and is asked to pay the total for the 
*  items selected in the cart. 
*/    
package shop;
 
import java.text.NumberFormat;
 
public class Item
{
    private String name;
    private double price;
    private int quantity;
 
    // -------------------------------------------------------
    //  Create a new item with the given attributes.
    // -------------------------------------------------------
    public Item (String itemName, double itemPrice, int numPurchased)
    {
      name = itemName;
      price = itemPrice;
      quantity = numPurchased;
    }
 
    // -------------------------------------------------------
    //   Return a string with the information about the item
    // -------------------------------------------------------
    public String toString ()
    {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
 
      return (name + "\t" + fmt.format(price) + "\t" + quantity + "\t"
            + fmt.format(price*quantity));
    }
 
    // -------------------------------------------------
    //   Returns the unit price of the item
    // -------------------------------------------------
    public double getPrice()
    {
      return price;
    }
 
    // -------------------------------------------------
    //   Returns the name of the item
    // -------------------------------------------------
    public String getName()
    {
      return name;
    }
 
    // -------------------------------------------------
    //   Returns the quantity of the item
    // -------------------------------------------------
    public int getQuantity()
    {
      return quantity;
    }
} 