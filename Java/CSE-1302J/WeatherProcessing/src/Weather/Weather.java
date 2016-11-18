package Weather;

// Program Name:      Weather.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project 2 
// Due Date:          23/Sep/2013
// Purpose:           Sets up all Weather class variables for the 
// driver and WeatherList class. 

                   
public class Weather 
{
    private String condition, date;
    private int temperature; 

    public Weather()
    {
        condition = null;
        temperature = 0; 
        date = null;
    }
    
    public Weather(String cond, int temp, String dt)
    {
        condition = cond;
        temperature = temp; 
        date = dt;
    }
        
    public void setCondition(String newCondition)
    {
        condition = newCondition;
    }
    
    public void setTemperature(int newTemperature)
    {
        temperature = newTemperature;
    }
    
    public void setDate(String newDate)
    {
        date = newDate; 
    }
    
    public String getCondition()
    {
        return condition; 
    }
    
    public int getTemperature()
    {
        return temperature; 
    }
    
    public String getDate()
    {
        return date; 
    }
    
    public String toString()
    {
        return (condition+", "+temperature+", "+date);
    }
}
