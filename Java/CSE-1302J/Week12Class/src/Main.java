
import javax.xml.soap.Node;

// Program Name:      Main.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class Main 
{
    public static void main(String[] args) {
      // Link List <Data Structures> 
      // Nodes <data component, and point> 
      // Node n = new Node(); 
      // n.data = 5; 
      // Node s = new Node(); 
      // s.data = 3; 
      // s.next=n;
      LinkedList LL = new LinkedList(); 
      System.out.println(LL);
      LL.addNode("Name 1");
      LL.addNode("Name 2");
      LL.addNode("Nmae 3");
      LL.addBack("Name 4");
      System.out.println(LL.display());
      
      LL.remove("Name 2");
      System.out.println(LL.display());
      
      LL.remove("N");
      System.out.println(LL.display());
      
    }
    public static int data;
    public static Node next;
    
}


