package project4;
// Program Name:      Date.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project#4
// Due Date:          28/October/2013
// Purpose:           Read list of cars and sold cars from file
// distinguish the difference between a car and sold car. 
// calculats profit of cars sold. Distinguishes the similar cars
// and prints them out. 
public class Date {
    private int day, year; 
    private String month; 
    
    public Date()
    {
        day = 0;
        month = null;
        year = 0; 
    }
    /**
     * @param newDay
     * @param newMonth
     * @param newYear
     */
    public Date(int newDay, String newMonth, int newYear)
    {
        day = newDay;
        month = newMonth; 
        year = newYear; 
    }
    public int getDay()
    {
        return day;
    }
    public String getMonth()
    {
        return month; 
    }
    public int getYear()
    {
        return year; 
    }
    public boolean equals(Object o)
    {
        if(!(o instanceof Date))
            return false; 
        else{
            Date obj = (Date)o; 
            if(day-obj.day == 0 
                    && month.equalsIgnoreCase(obj.month)
                    && year-obj.year == 0)
                return true; 
            else return false; 
        }
    }
    public String toString()
    {
        return (day+" "+month+", "+year);
    }
}
