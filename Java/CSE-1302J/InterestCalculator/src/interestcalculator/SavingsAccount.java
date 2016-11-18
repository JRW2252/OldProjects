package interestcalculator;
      

public class SavingsAccount 
{
    private int months;
    private float  total, apy, interest;
    
    public SavingsAccount(){
        total=0.00F;
        apy=0.00F;
        months=0;
        interest=0.00F;
    }
    
    public SavingsAccount(float t, float newapy,int m){
        total=t;
        apy=newapy;
        months=m;
    }
    
    public float getTotal(){
        return total;
    }
    
    public float getAPY(){
        return apy;
    }
    
    public float getInterest(){
        return interest;
    }
    
    public int getMonths(){
        return months;
    }
    
    
}
