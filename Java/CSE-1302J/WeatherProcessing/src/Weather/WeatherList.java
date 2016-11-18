package Weather;

// Program Name:      WeatherList.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project 2
// Due Date:          23/Sep/2013
// Purpose:           Methods for usnig the weather that is brought 
// in from the driver class. 

import java.util.Scanner;
         
public class WeatherList 
{
    private Weather [] list; 
    private int count, tempSum, cap, avgTemp; 
 
     
    public WeatherList()
    {
        cap = 1;
        list = new Weather[cap];
        count = 0;
        tempSum = 0;
        avgTemp = 0;
    }
    
    public void addToArray(String condition, int temperature, String date)
    {
        Weather temp = new Weather (condition, temperature, date);
        tempSum += temperature;
        list[count] = temp; 
        count += 1;
        if(count == cap)
        {
            increaseArraySize(); 
        }
    }
    
    // increases array size
    private void increaseArraySize()
    {
        Weather[] temp = new Weather[cap+1];
        for(int i=0; i < cap; i++)
        {
            temp[i] = list[i];
        }
        list = temp; 
        temp = null;
        cap = list.length;
    }   
    
    // averaging temperatures
    public int averageTemperature()
    {
        avgTemp = (tempSum/count);
        return avgTemp; 
    }
    
    // sorts temperatures from greatest to least
    public void temperatureSort()
    {
        // go through array of temperatures having i stop at len -1
        for (int i = 0; i < list.length-1; i++)
        {
            int minPos = i; // sets minPos to arr[0] value
            // go through array having j stop at 1 past i 
            // to compare the two values            
            for (int j = i+1; j < list.length-1; j++)
            {
                if (list[j].getTemperature() < list[minPos].getTemperature())
                minPos = j;
            }
            // checks val of i and its position relative 
            // to the end of the array
            if (i != minPos && minPos < list.length)
            {
                Weather temp = list[minPos];
                list[minPos] = list[i];
                list[i] = temp;
            }
        }
        // list is sorted from min to max so it will be printed out
        // in reverse order to display it from max to min temperature
        System.out.println("\n\nSorted Tempurature List: \n"
                + "\nCONDITION, TEMPERATURE, DATE");
        for(int l =list.length-1; l >= 0; l--)
            System.out.println(list[l]);
    }
    
    // sorts conditions alphabetically
    public void conditionSort()
    {
        for(int i = 0; i < list.length - 1; i++)
            for(int j = i; j < list.length -1; j++)
            {
                if(list[j].getCondition().compareTo(list[i].getCondition()) < 0)
                {
                    Weather temp = list[j];
                    list[j] = list[i];
                    list[i] = temp; 
                }
            }
        
        System.out.println("\n\nSorted Condition List: \n"
                + "\nCONDITION, TEMPERATURE, DATE");
        for(int i = 0; i < list.length-1; i++)
            System.out.println(list[i]);
    }
    
    // finds a condition in a search from user
    public void findCondition()
    {
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter a condition that you would like to find: ");
                boolean found = false; 
                String searchCond; 
                do {
                    searchCond= sc.next();
                    for(int i = 0; i<list.length-1;i++)
                    {
                         String aCond = list[i].getCondition();
                         if(searchCond.equalsIgnoreCase(aCond))
                            found = true; 
                         else found = false; 
                    } 
                    System.out.println("search did not find that condition."
                            + " Try again. \n");
                } while (found == false);
                System.out.println("Your searched condition "+searchCond
                        +" was found. \n");
    }
    // finds temperature in a search from user
    public void findTemperature()
    {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter a temperature that you want to find: ");
                boolean found = false; 
                int find;
                do {
                    find = scan.nextInt();
                    for(int i = 0; i<list.length-1;i++)
                    {
                         int aTemp = list[i].getTemperature();
                         if(aTemp == find)
                            found = true;
                         else found = false; 
                    }
                    System.out.println("search did not find that temperature."
                            + " Try again. \n");
                } while (found = false);
                System.out.println("Your searched temperature "+find
                        +" was found. \n");
    }
    
    // searches for foggy condition
    public void findFoggy()
    {
        for(int i = 0; i < list.length - 1; i++)
        {
            if(list[i].getCondition().equalsIgnoreCase("Foggy"))
            {
                int condTemp = list[i].getTemperature();
                System.out.println("\nCONDITION, TEMPERATURE, DATE");
                System.out.print(list[i]+"\n"+
                        "\nFoggy day's temp difference from the average is ");
            }  
        }
    }
    
    // gets the temp of foggy condition
    public int foggyTemp()
    {
        int fogTemp = 0; 
        for(int i = 0; i < list.length - 1; i++)
            if(list[i].getCondition().equalsIgnoreCase("foggy"))
                fogTemp = list[i].getTemperature();
        return fogTemp;
    }
    
    // to string for array printing
    public String toString()
    {
        String daysWeather = "\nCONDITION, TEMPERATURE, DATE\n";
        for(int i = 0; i < list.length-1; i++)
            daysWeather += list[i]+"\n";
        return daysWeather;
    }
}