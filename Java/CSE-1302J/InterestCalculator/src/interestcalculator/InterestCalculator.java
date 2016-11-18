package interestcalculator;

// Program Name:      InterestCalculator.java

import static interestcalculator.InterestCalculator.df;
import java.text.DecimalFormat;
import java.util.Scanner;

// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description

public class InterestCalculator 
{
    static Scanner sc = new Scanner(System.in);
    static float total = 0.00f, APY=0.00f, interest=0.00f, payAmt=0.00f;
    static int months;
    static DecimalFormat df = new DecimalFormat();
        
    public static void main(String[] args) 
    {
        menu();
        int choice = sc.nextInt();
        do {         
            switchOptions(choice);
            menu();
            choice = sc.nextInt();
        } while (choice != 0);
        System.out.println("---------Program Ended---------");
    }
    
    public static void switchOptions(int choice){
        switch (choice) {
            case 0:
            System.out.println("Bye!");
            break;
          case 1:
              SavingsCalc();
              break;
          case 2:
              LoanCalc();
            break;
            default:
                System.out.println("Invalid Choice");
        }
}
    
    public static void LoanCalc(){
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        System.out.println("Enter initial loan amount: ");
        total = sc.nextFloat();
        System.out.println("Enter APY");
        APY=(sc.nextFloat()*0.01f);
        System.out.println("Enter # of months to payoff: ");
        months = sc.nextInt();
        System.out.println("Enter required monthly payment ammount:");
        payAmt=sc.nextFloat();
        System.out.println("Month\tLoan Amount\tInterest\tPayment");
        for (int i = 1; i <= months; i++) {
            interest=total*APY;
            if(interest<=0)
                interest=0.00f;
            total=(interest+total)-payAmt;
            System.out.println(i+"\t"+df.format(total)+"\t"+df.format(interest)+"\t"+payAmt);
        }
    }
    
    public static void SavingsCalc(){
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        System.out.println("Enter initial deposit amount: ");
        total = sc.nextFloat();
        System.out.println("Enter the APY: ");
        APY=(sc.nextFloat()*0.01f);
        System.out.println("Enter # of months for CD maturity: ");
        months = sc.nextInt();
        // total, apy, months
        System.out.println("Month\tTotal\tInterest");
        for(int i=1; i<=months; i++){
            interest=total*APY;
            if(interest<=0.00f)
                interest=0.00f;
            total=interest+total;
            System.out.println(i+"\t $"+df.format(total)+
                    "\t $"+df.format(interest));
        }
   }
    
   public static void menu(){
       System.out.println("\n===============================");
       System.out.println("0: Quit");
       System.out.println("1: Savings account calculations");
       System.out.println("2: Loan calculations");
       System.out.println("===============================\n");
       }
}