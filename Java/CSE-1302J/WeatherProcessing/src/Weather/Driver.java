package Weather;

// Program Name:      Driver.java

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project 2
// Due Date:          23/Sep/2013
// Purpose:           Main Driver  

public class Driver 
{
    public static void main(String[] args) throws IOException
    {
        String cond, date, temp; 
        int tmp;
        Scanner sc = new Scanner(new File("input1.txt"));
        WeatherList weatherIn = new WeatherList();
        while (sc.hasNextLine())
        {
            
            cond = sc.next();
            temp = sc.next();
            tmp = Integer.parseInt(temp);
            date = sc.next();            
            weatherIn.addToArray(cond, tmp, date);
        }
        // prints array taken in from file
        System.out.println(weatherIn);
        // average temp
        System.out.println("\nAverage Temperature: "
                +weatherIn.averageTemperature());
        // displays sorted temps from greatest to least
        weatherIn.temperatureSort();
        // displays sorted conditions alphabetically
        weatherIn.conditionSort();
        System.out.println("\n\nFind 'Foggy' Condition");
        // displays finding foggy condition 
        weatherIn.findFoggy();
        // displays difference between foggy day temp and avg temp
        System.out.print(weatherIn.averageTemperature()-weatherIn.foggyTemp()
                +" degrees.\n\n");
        // searches for a condition
        weatherIn.findCondition();
        // searches for a temperature
        weatherIn.findTemperature();
    }    
}
