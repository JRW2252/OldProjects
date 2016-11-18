package factorials;

// Program Name:      MathUtils.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class MathUtils 
{
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n)throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("Negative factorials do not exist."); 
        }
        if(n > 12)
        {
            throw new IllegalArgumentException("Arithmetic overflow error.");
        }
      int fac = 1;
      for (int i=n; i>0; i--)
          fac *= i;
      return fac;
    }
}
