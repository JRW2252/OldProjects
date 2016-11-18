package RecursionExamplesFromClass;

// Program Name:      JunkFromClass.java

import java.util.Stack;

// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

public class JunkFromClass 
{
    public static void main(String[] args) 
    {
        javax.swing.JOptionPane.showMessageDialog(null, "Hello, Java!");
        System.out.println("\nAdding integers 1, 2, 3, 4, and 5 to a new stack");
        Stack myStack = new Stack(); 
        System.out.println("\nPeek then pop the stack till empty:");
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        myStack.add(4);
        myStack.add(5);
        while(!myStack.empty()){
            System.out.println(myStack.peek());
            myStack.pop(); 
        }
        System.out.println("");
//      ArrayList<House> listings = new ArrayList();
//      
//      listings.add(new House(0001, 200000.00));
//      listings.add(new House(0201, 200000.00));
//      listings.add(new House(0001, 200000.00));
//      listings.add(new House(0401, 200000.00));
//      listings.add(new House(0031, 200000.00));
//      listings.add(new Condo(0401, 200000.00, 4));
//      listings.add(new Condo(0001, 120000.00, 3));
//      listings.add(new Condo(0301, 220000.00, 2));
//      listings.add(new Condo(0001, 130000.00, 3));
//      listings.add(new Condo(0201, 130000.00, 3));
//      
//      Map<Integer, List<House>> groups = new HashMap<Integer, List<House>>();
//      for (House house:listings) {
//         List<House> group = groups.get(house.getListingNum());
//         if (group == null) {
//           group = new ArrayList<House>();
//           groups.put(house.getListingNum(), group);
//         }
//         group.add(house);
//      }
//      
//      for (Entry<Integer, List<House>> entry:groups.entrySet()) 
//      {
//        System.out.println("Duplicate listing number "+entry.getKey()
//                +" \t# of duplicates "+entry.getValue().size());
//      }
      
        System.out.println("Recursion with a print String n times");
        Print(3); // printing hello world 
        //System.out.println(CountCharacter();
        System.out.println("\n\n"+gcd(80, 8));
        System.out.println("\nCounting character 'x' in string 'xxrtsxx' example:\n"
                +countX("xxrtsxx"));
        System.out.println("\nFactorial example: "+Fact(8));
        System.out.println("\nMutual recursion example:");
        A(5);
        System.out.println("\nsum wo helper of 4 = "+sumwo(4));
        System.out.println("\nrecursive int n method where n=4: "+recursive(4));
        System.out.println("\nrecursive printNums method, using n=7: ");printNums(7);
        System.out.println("\nrecursive nPrint method, using n=7: ");nPrint(7);
        System.out.println("\nReverse Print: My string");
        reversePrint("My string");
        System.out.println("\n\n");
        
    }
    
    public static int Fact(int n)
    {
         if(n <= 1) // base case
              return 1; 
         return n*Fact(n-1); // general case 
    }
    public static void Print(int n)
    {
        if(n>0)
        {
            System.out.println("hello world, ");
            Print(n-1);
        }
    }
    
    public static void CountCharacter(String s, char c)
    {
        int count = 0; 
         if(s.length() < 1) // base case
              return; 
         if(s.charAt(0) == c) // general case
              count++; 
         CountCharacter(s.substring(1), c);
    }
    
    public static int gcd(int dividend, int divisor)
    {
        if(dividend % divisor == 0)
            return divisor; 
        else 
            return(gcd(divisor, dividend % divisor));
    }
    
    public static int countX(String str) 
    {
        if(str.length()<1) // simple case
            return 0; 
        if(str.charAt(0)=='x') // general case
            return(1+countX(str.substring(1)));
        else return(0+countX(str.substring(1)));
    }
    public static void A(int n)
    {
        System.out.println("top A, n = "+n); 
        if(n<=0) // simple case
            return; 
        n--; // general case
        B(n);
        System.out.println("bottom A, n = "+n); 
    }
    public static void B(int n)
    {
        System.out.println("top B, n = "+n); 
        if(n<=0) // simple case
            return; 
        n--; // general case
        A(n);
        System.out.println("bottom B, n = "+n); 
    }
    public static int sumwo(int n)
    {
        if(n ==1) // simple case
            return 1; 
        else return n+sumwo(n-1); // general case
    }
//    private static int sum(int n)
//    {
//        if(n==1)
//            return 1; 
//        else return n+sum(n-1);
//    }
//    public int getSum(int n)
//    {
//        if(n>0) 
//            return sum(n);
//    }
    public static int recursive(int n)
    {
        if(n==1) // simple case 
            return n; 
        else return recursive(n-1); // general case
    }
    
    // Remember that the values are going to be stored on the
    // activation stack and will be printed once n == 1. 
    // Therefore they will be printed in increasing order from 1 to n. 
    public static void printNums(int n)
    {
        if(n==1) // simple case
            System.out.println(n);
        else // general case
        {
            printNums(n-1);
            System.out.println(n);
        }
    }
    // Remember that the values are going to be printed as a stream
    // instead of having them stored on the activation stack for printing 
    // later. Therefore they will print in decreasing order from n to 1. 
    public static void nPrint(int n)
    {
        if (n>0)
        {
            nPrint(n-1);
            System.out.println(n);
        }
    }
    public static void reversePrint(String s){
        if(s.length() > 0){
            reversePrint(s.substring(1));
            System.out.print(s.charAt(0));
        }
    }
}
