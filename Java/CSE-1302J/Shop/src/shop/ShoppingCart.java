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
 
public class ShoppingCart
{
    
    private Item[] cart;
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity
    private double finalSale;
    // -----------------------------------------------------------
    //  Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart()
    {
      
      capacity = 5;
      cart = new Item[capacity];
      itemCount = 0;
      totalPrice = 0.0;
    }
 
    // -------------------------------------------------------
    //  Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String itemName, double price, int quantity)
    { 
        
        Item temp = new Item(itemName, price, quantity);// Create new temp Item
        // Add price * quantity to running total
        totalPrice += (price * quantity); 
        cart[itemCount] = temp; // Initialize cart size, assign index value
        itemCount += 1; // Incrament array size
        if(itemCount==capacity) // Utilize increseSize method
        {
            increaseSize();
        }
    }
 
    // -------------------------------------------------------
    //  Returns the contents of the cart together with
    //  summary information.
    // -------------------------------------------------------
    public String toString()
    {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
 
      String contents = "\nShopping Cart\n";
      contents += "\nItem, Price Ea, Qty, Total\n";
 
      for (int i = 0; i < itemCount; i++)
          contents += cart[i].toString() + "\n";
 
      contents += "\nTotal Price: " + fmt.format(totalPrice);
      contents += "\n";
 
      return contents;
    }
    //
    // Formats total price and returns it as currency
    //
    public double finalSale()
    {
        finalSale=totalPrice;
        NumberFormat fmtr = NumberFormat.getCurrencyInstance();
        fmtr.format(finalSale);
        return finalSale;
    }
 
    // ---------------------------------------------------------
    //  Increases the capacity of the shopping cart by 3
    // ---------------------------------------------------------
    private void increaseSize()
    {
        Item[] temp = new Item[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp; 
        temp = null;
        capacity = cart.length;
    }
}