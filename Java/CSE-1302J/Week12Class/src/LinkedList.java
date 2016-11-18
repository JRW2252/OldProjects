// Program Name:      LinkedList.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class LinkedList 
{
    private Node first; 
    
    class Node
    {
      public String name; 
      public Node next;
    }
    public void addNode(String n)
    {
      Node newNode = new Node(); 
      newNode.name=n;
      newNode.next=first;
      first=newNode;
    }
    public void addBack(String n)
    {
      Node newNode = new Node(); 
      newNode.name=n;
      newNode.next=null; 
      Node current = first; 
      while(current.next!=null)
      {
        current = current.next;
      }
      current.next = newNode;
    }
    public void remove(String n)
    {
      Node current = first; 
      Node previous = first; 
//      while(current.name.equals(n));
      while(current.next != null)
      {
        if(!current.name.equals(n))
        {
          previous = current; 
          current = current.next;
        }
        
      }
      if(current.next!=null)
      previous.next = current.next;
    }
    public String display()
    {
      Node current = first; 
      String data = "";
      while(current.next!=null)
      {
        data+=current+" "+" next "+current.next+"\n";
        current=current.next;
      }
      data+=current+" "+" next "+current.next+"\n";
      return data;
    }
}
