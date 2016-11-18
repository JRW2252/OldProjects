package inheritanceandfiles;

// Program Name:      Date.java

import java.util.Objects;

// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class Date 
{
    private int day;
    private int year; 
    private String month; 
    
    public Date(int d, int y, String m)
    {
        day = d;
        year = y; 
        month = m;
    }
    public int getDay()
    {
        return day; 
    }
    public int getYear()
    {
        return year; 
    }
        public String getMonth()
    {
        return month;
    }
    @Override
        public String toString()
    {
        return new StringBuilder().append(day).append(" ")
                .append(month).append(", ").append(year).toString();
    }    
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Date))
            return false;
        else{
            Date obj = (Date)o;
            if((day - obj.day) != 0)
                return false;
            if(!(month.equals(obj.month)))
                return false;
            if((year - obj.year) != 0)
                return false; 
            else 
                return true; 
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.day;
        hash = 53 * hash + this.year;
        hash = 53 * hash + Objects.hashCode(this.month);
        return hash;
    }

}
