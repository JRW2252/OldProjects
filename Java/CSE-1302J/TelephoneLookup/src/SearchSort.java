// Program Name:      SearchSort.java
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
                   
public class SearchSort 
{ 
  // Insertion Sort Alphabetically
  public static void insertionSortName (Person[] o)
  {
    Person temp;
    int j;
    for (int i = 1; i < o.length; i++)
    {
       j = i;
       temp = o[i]; 
       //  Shift larger values
       while (j != 0 && (temp.compareTo(o[j-1])) < 0)
       {
          o[j] = o[j-1];
          j--;
       }
       o[j] = temp;
    }
  }

  // Insertion Sort Numerically
  public static void insertionSortNums(Person [] o)
  { 
    Person temp;
    int j;
    for (int i = 1; i < o.length; i++)
    {
      j = i;
      temp = o[i];
      while(j != 0 && (temp.getPhoneNum()).compareTo
      (o[j-1].getPhoneNum()) < 0)
      {
        o[j] = o[j-1];
        j--;
      }
      o[j] = temp;
    }
  }

  // Method utilized to search with a name to find a phoneNumber
  public static String binaryWithName(Person [] o, String n)
  {
    String name = n;
    int start = 0, end = o.length-1, mid;
    while(end >= start)
    {
      mid = (start+end)/2;
      if(name.compareToIgnoreCase((o[mid].getLast().concat(" ")
              .concat(o[mid].getFirst()))) == 0) 
      {
        return "-------------------------------------------------"
                + "\nInformation for " + name + " was found.\n"
                +mid+": "+o[mid]
                + "\n-------------------------------------------------\n";
      }
      if(name.compareToIgnoreCase((o[mid].getLast().concat(" ")
              .concat(o[mid].getFirst()))) > 0)
      {
//        System.out.println(mid+": "+o[mid]);
        start = mid + 1;
      }
      else if(name.compareToIgnoreCase((o[mid].getLast().concat(" ")
              .concat(o[mid].getFirst()))) < 0)
      {
//        System.out.println(mid+": "+o[mid]);
        end = mid - 1;
      }
    }
    return "No Results Found for "+name;
  }
  
  // Method utilized to search with a phoneNumber for a name
  public static String binaryWithNumber(Person[]o, String n)
  {
    String num = n; 
    int start = 0, end = o.length-1, mid;
    while(end >= start)
    {
      mid = (start+end)/2;
      if(num.compareTo(o[mid].getPhoneNum()) == 0) 
      {
        return "-------------------------------------------------"
                + "\nInformation for " + num + " was found.\n"
                +mid+": "+o[mid]
                + "\n-------------------------------------------------\n";
      }
      if(num.compareTo((o[mid].getPhoneNum())) > 0)
      {
//        System.out.println(mid+": "+o[mid]);
        start = mid + 1;
      }
      else if(num.compareTo((o[mid].getPhoneNum())) < 0)
      {
//        System.out.println(mid+": "+o[mid]);
        end = mid - 1;
      }
    }
    return "No Results Found for "+num;
  }
}