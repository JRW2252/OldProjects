    public class LinkListClass
   {
         
      private Node first;
   	
       class Node
      {
         public String name;
         public Node next;
      }
   	
       public LinkListClass()
      {
         first=null;
      	
      }
       public void addNode(String n)
      {
         Node newNode = new Node();    
         newNode.name=n;
         newNode.next=first;
         first=newNode;
      }
       public String display()
      {
         Node current= first;
         String data= "";
         while(current.next!=null)
         {
            data+=current +" "+current.name+" next is " + current.next+ "   ";
            current=current.next;
         }
         data+=current +" "+current.name + " next is " + current.next+ "   ";
         return data;
      }
   }