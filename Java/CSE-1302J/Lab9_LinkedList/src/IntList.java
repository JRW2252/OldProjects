// Program Name:      IntList.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project# or Lab#
// Due Date:          dd/mm/2013
// Purpose:           Program purpose / description         

                   
public class IntList 
{
    private IntNode front;
    private int count = 0;
    public IntList()
    {
      front = null;
    }
    
    public void addToFront(int val)
    {
      front = new IntNode(val, front);
      count++;
    }
    
    public void addToEnd(int val)
    {
      count++;
                IntNode newnode = new IntNode(val,null);
 
                //if list is empty, this will be the only node in it
                if (front == null)
                    front = newnode;
                else
                    {
                                //make temp point to last thing in list
                                IntNode temp = front;
                                while (temp.next != null)
                                    temp = temp.next;
                                //link new node into list
                                temp.next = newnode;
                    }
    }
    
    public void removeFirst()
    {
      if(front != null)
        front = front.next;
      count--;
    }
    
    public void print()
    {
      System.out.println("-------------------");
      System.out.print("List elements: ");
      IntNode temp = front;
      while(temp != null)
      {
        System.out.print(temp.val+" ");
        temp = temp.next;
      }
      System.out.println("\n-------------------");
    }
    
     public int length()
     {
       return count;
     }
     public String toString()
     {
      IntNode current = front; 
      String data = "";
      while(current.next!=null)
      {
        data+=current+" "+current.val+" next "+current.next+"\n";
        current=current.next;
      }
      data+=current+" "+current.val+" next "+current.next+"\n";
      return data;
     }
     
     public void removeLast()
     {
       IntNode current = front;
       IntNode prev = front;
       
       while(current.next != null)
       {
         prev = current;
         current = current.next;
       }
       if(current.next == null)
         prev.next = current.next;
     }
     public void replace(int oldVal, int newVal)
     {
       IntNode current = front; 
       while(current != null)
       {
         if(current.val==oldVal)
           current.val = newVal; 
         current= current.next;
       }
     }
     public void printRec()
     {
       IntNode temp = front; 
       if(front == null)
         return; 
       IntNode rest = front.next;
       System.out.println(temp.val+" "+printRecHelper(rest));
     }
     public String printRecHelper(IntNode rest)
     {
       
       if(rest.next==null)
         return ""+rest.val;
       else 
         return rest.val+" "+printRecHelper(rest.next);
     }
     public void printRecBack()
     {
       IntNode temp = front; 
       if(front == null)
         return; 
       IntNode rest = front.next;
       System.out.println(printRecBackHelp(rest)+" "+temp.val);
     }
     public String printRecBackHelp(IntNode rest)
     {
       if(rest.next==null)
         return ""+rest.val;
       else 
         return printRecBackHelp(rest.next)+" "+rest.val;
     }
}
