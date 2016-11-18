// Program Name:      Person.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# 5
// Due Date:          18/11/2013
// ----------------------------------------------------------------------
// Purpose:           Inports a list of data (last name, 
// first name, and phone numbers), and adds them into arrays. 
// One array for simple initial import, one for sorted alphabetically 
// (last name, first name), and the last for sorted numerically
// (phone numbers). Then provide the user a means to search for a persons
// phone number via entering their name, and a means to search for a 
// persons name associated with a phone number. 
// ----------------------------------------------------------------------     

// Using formatter to display the information in a manner that 
// does not suck to read.
import java.util.Formatter;

                   
public class Person implements Comparable
{
  
  Person [] pBook;
  private String last, first, phoneNumber;
  
  // Person constructor
  public Person()
  {
    last = null; 
    first = null;
    phoneNumber = null;
  }
  
  // Override Person constructor
  public Person(String l, String f, String p)
  {
    last = l; 
    first = f;
    phoneNumber = p;
  }
  
  // Last name accessor
  public String getLast()
  {
    return last;
  }
  
  // First name accessor
  public String getFirst()
  {
    return first; 
  }
  
  // phoneNumber accessor
  public String getPhoneNum()
  {
    return phoneNumber; 
  }
  
  // toString that is formatted to display the 
  // Person using align left at 15, 15, and 15 spaces
  // for the values of last, first, and phoneNumber
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    try (Formatter fmtr = new Formatter(sb)) {
      String layout = "%-15s %-15s %-15s";
      fmtr.format(layout, last, first, phoneNumber);
    }
    return sb.toString();
  }
  
  // Create a list and the size of the list
  public Person (int length)
  {
    pBook = new Person [length];
  }
 
  // Returns true for same name
  @Override
  public boolean equals(Object o)
  {
    if(!(o instanceof Person))
      return false;
    return (last.equals(((Person)o).getLast()) 
            && first.equals(((Person)o).getFirst()));
  }
  
  // Compare Objects properties (last name, first name)
  @Override
  public int compareTo(Object o)
  {
    if(!(o instanceof Person))
      return -1; 
    Person comp = (Person)o;
    int result = this.last.compareTo(comp.last);
    if(result != 0)
      return result;
    result = this.first.compareTo(comp.first);
    if(result != 0)
      return result; 
    return comp.last.compareTo(this.last);
  }
  
  // Comparing phone numbers method
  // Did not actually use this method
  public int compareToNum(Object o)
  {
    if(!(o instanceof Person))
      return -1; 
    Person comp = (Person)o;
    int result = this.phoneNumber.compareTo(comp.phoneNumber);
    if(result != 0)
      return result;
    return comp.phoneNumber.compareTo(this.phoneNumber);
  }
}