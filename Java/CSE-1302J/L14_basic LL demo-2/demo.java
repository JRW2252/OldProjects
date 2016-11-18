//gesick
//linked list demo

    public class demo
   {
   
       public static void main(String [] args)
      {
         LinkListClass LL = new LinkListClass();
         System.out.println(LL);
      
         LL.addNode("bill");
         System.out.println("display1 "+ LL+ " "+LL.display());
         LL.addNode("tom");
         System.out.println("display2 "+ LL+ " "+LL.display());
         // LL.addNode("joe");
//          System.out.println("display3 "+ LL+ " "+LL.display());
//          LL.addNode("art");
//          System.out.println("display4 "+ LL+ " "+LL.display());
      }
   }