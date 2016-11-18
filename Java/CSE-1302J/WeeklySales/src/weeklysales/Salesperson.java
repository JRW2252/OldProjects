package weeklysales;

// Program Name:      Salesperson.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class Salesperson implements Comparable
{
    private String firstName, lastName;
    private int totalSales;
 
    //------------------------------------------------------
    //  Constructor:  Sets up the sales person object with
    //                the given data.
    //------------------------------------------------------
    public Salesperson (String first, String last, int sales)
    {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }
 
    //-------------------------------------------
    //  Returns the sales person as a string.
    //-------------------------------------------
    public String toString()
    {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }
 
 
    //-------------------------------------------
    //  Returns true if the sales people have
    //  the same name.
    //-------------------------------------------
    public boolean equals (Object other)
    {
        return (lastName.equals(((Salesperson)other).getLastName()) &&
                firstName.equals(((Salesperson)other).getFirstName()));
    }
 
    //--------------------------------------------------
    //  Order is based on total sales with the name
    //  (last, then first) breaking a tie.
    //--------------------------------------------------
    public int compareTo(Object o)
    {
        if(!(o instanceof Salesperson))
        return -1;
        Salesperson other = (Salesperson)o;
        int result = this.totalSales-other.totalSales;
        if(result != 0)
            return -result;
        result = this.lastName.compareTo(other.lastName);
        if(result != 0)
            return result; 
        result = this.firstName.compareTo(other.firstName);
        if(result != 0)
            return result;
        return other.firstName.compareTo(this.firstName);
    }
 
    //-------------------------
    //  First name accessor.
    //-------------------------
    public String getFirstName()
    {
        return firstName;
    }
   
    //-------------------------
    //  Last name accessor.
    //-------------------------
    public String getLastName()
    {
        return lastName;
    }
 
    //-------------------------
    //  Total sales accessor.
    //-------------------------
    public int getSales()
    {
        return totalSales;
    }
}

