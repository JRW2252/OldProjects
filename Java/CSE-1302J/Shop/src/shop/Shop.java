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

import java.util.ArrayList;
import java.util.Scanner;
 
public class Shop
{
    public static void main (String[] args)
    {
      ArrayList<Item> cart = new ArrayList<Item>();
 
      Item item;
      String itemName;
      double itemPrice;
      double totalPrice;;
      int quantity;
 
      Scanner scan = new Scanner(System.in);
 
      String keepShopping = "y";
      ShoppingCart cart1 = new ShoppingCart();
      do
          {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.next();
 
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
 
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
 
            // *** create a new item and add it to the cart
            cart1.addToCart(itemName, itemPrice, quantity);
            //cart.add(item);
 
 
            // *** print the contents of the cart object using println
            System.out.print(cart1);
            
            //System.out.println(cart);
            
            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.next();
            
          }
      while (keepShopping.equals("y"));
      
      System.out.println("\nPlease pay the ammount of: $"+cart1.finalSale());
    }
}