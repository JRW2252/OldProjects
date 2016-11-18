 //gesick
 //search and sort examples
   import java.util.ArrayList;
   import java.util.Random;
   import java.util.Scanner;
   import java.util.Collections;
 
   public class search_sort_Demo
   {
      private static Random r;
      public static void main(String[] args)
      {
         long start, end, elapsed;
         r = new Random();
         Scanner scan= new Scanner(System.in);
      	
         int[] A = { 3, 5, 1, 7, 15, 13, -2, 8, -5 };
      
         int[] B = { 4, 7, 1, 15, 17, 90, 28, 32, 45 };
      
         ArrayList<Integer> C = new ArrayList<Integer>();
      	
         C.add(5); C.add(27); C.add(11);
         C.add(8); C.add(17); C.add(16);
         C.add(25); C.add(7); C.add(-1);
      
         int[] G = new int[C.size()];
         for(int i=0; i<G.length;i++)
            G[i]=C.get(i);
      		
         int[] D = { 4, 7, 1, 15, 17, 90, 28, 32, 45 };
         
         ArrayList<Integer> E = new ArrayList<Integer>();
         for(int i :D)
            E.add(i);      
         BubbleSort( A);
         PrintArray(A, "bubble");
      
         SelectionSort( B);
         PrintArray(B, "\nselection");
      
         C=InsertionSort( C);
         PrintArrayList(C, "\n list insertion ");
      
         G=InsertionSortArray( G);
         PrintArray(G, "\narray insertion ");
      
         int[] F = { 3, 5, 1, 7, 15, 13, -2, 8, -5 };
         Collections.sort(E);
         PrintArrayList(E, "\nbuilt-in ArrayList");
      
                
         System.out.println("Enter the value to search for (linear search using unsorted A equivalent): ");
         int find = Integer.parseInt(scan.nextLine());
         int steps=0;
         boolean found = LinearSearch(F, find);
         System.out.println(found ? "found" : "not found");
      
         System.out.println("Enter the value to search for (Binary search using sorted A): ");
         find = Integer.parseInt(scan.nextLine());
      
         found = BinarySearch(A, find);
         System.out.println( found ? "found" : "not found");
         int[] nums1 = new int[10000];
         int[] nums2 = new int[20000];
         fillArray(nums1);
         fillArray(nums2);
			
			 start= System.nanoTime();
               BubbleSort( nums1);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\nBubble sort "+nums1.length+" elements elapsed time "+elapsed*.000001+" ms");
                  
      
         start= System.nanoTime();
         BubbleSort( nums2);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\nBubble sort "+nums2.length+" elements elapsed time "+elapsed*.000001+" ms");
                  
      
         fillArray(nums1);
         fillArray(nums2);
        
         start= System.nanoTime();
         SelectionSort( nums1);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\nselection sort "+nums1.length+" elements elapsed time "+elapsed*.000001+" ms");
         
         start= System.nanoTime();
         SelectionSort( nums2);
         end= System.nanoTime(); 
         elapsed=end-start; 
         System.out.println("\nselection sort "+nums2.length+" elements elapsed time "+elapsed*.000001+" ms");
      			        
         fillArray(nums1);
         fillArray(nums2);
      	
         ArrayList<Integer> list1 = new ArrayList<Integer>();
         for(int i=0; i<nums1.length;i++)
            list1.add(nums1[i]);
				
         ArrayList<Integer> list2 = new ArrayList<Integer>();
         for(int i=0; i<nums2.length;i++)
            list2.add(nums2[i]);
				
    //  System.out.println("insertion, nums2 length"+nums2.length);
         start= System.nanoTime();
         InsertionSort( list1);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\ninsertion sort "+list1.size()+" elements elapsed time "+elapsed*.000001+" ms");
      
         start= System.nanoTime();
         InsertionSort( list2);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\ninsertion sort "+list2.size()+" elements elapsed time "+elapsed*.000001+" ms");                  
                
         fillArray(nums1);
         fillArray(nums2);
      	
         start= System.nanoTime();
         InsertionSortArray( nums1);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\ninsertion sort array "+nums1.length+" elements elapsed time "+elapsed*.000001+" ms");   
        
         start= System.nanoTime();
         InsertionSortArray( nums2);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\ninsertion sort array "+nums2.length+" elements elapsed time "+elapsed*.000001+" ms");  
                  
      
         fillArray(nums1);
         fillArray(nums2);
      
         ArrayList<Integer> list3 = new ArrayList<Integer>();
         for(int i=0; i<nums1.length;i++)
            list3.add(nums1[i]);
				
         ArrayList<Integer> list4 =new ArrayList<Integer>();
         for(int i=0; i<nums2.length;i++)
            list4.add(nums2[i]);
      		
         start= System.nanoTime();
         Collections.sort(list3);
         end= System.nanoTime();
         elapsed=end-start; 
         System.out.println("\nCollections sort of arraylist "+nums1.length+" elements elapsed time "+elapsed*.000001+" ms");   
      			    
         start= System.nanoTime();
         Collections.sort(list4);
         end= System.nanoTime() ;
         elapsed=end-start; 
         System.out.println("\nCollections sort of arraylist "+nums2.length+" elements elapsed time "+elapsed*.000001+" ms");      
      }
   
      private static void fillArray(int[] A)
      {
         for (int i = 0; i < A.length; i++)
            A[i] = r.nextInt(60000);
      }
      public static void BubbleSort( int[] A)
      {
         for (int i = 0; i < A.length - 1; i++)
            for (int j = i; j < A.length; j++)
            {
               if (A[j] < A[i])
               {
                  int temp = A[j];
                  A[j] = A[i];
                  A[i] = temp;
               }
            }
      
      }
      public static void SelectionSort( int[] B)
      {
         int i = 0;
         int j = 0;
         for (i = 0; i < B.length - 1; i++)
         {
            int minPos = i;
            for (j = i + 1; j < B.length; j++)
            {
               if (B[j] < B[minPos])
                  minPos = j;
            }
            if (i != minPos && minPos < B.length)
            {
               int temp = B[minPos];
               B[minPos] = B[i];
               B[i] = temp;
            }
         }
      }
      public static ArrayList<Integer> InsertionSort( ArrayList<Integer> C)
      {
         ArrayList<Integer> inOrder = new ArrayList<Integer>();
         for (int temp : C)
         {
            boolean added = false;
            for (int i = 0; i < inOrder.size(); i++)
            {
               if (temp < inOrder.get(i))
               {
                  inOrder.add(i, temp);
                  added = true;
                  break;
               }
            }
            if (!added)
               inOrder.add(temp);
         }
         return inOrder;
      }
      public static void PrintArray(int[] anArray, String msg)
      {
         System.out.println(msg + " sort");
         for (int i = 0; i < anArray.length; i++)
            System.out.print(anArray[i] + " ");
         System.out.println();
      }
      public static void PrintArrayList(ArrayList<Integer> aArrayList, String msg)
      {
         System.out.println(msg + " sort");
         for (int num : aArrayList)
            System.out.print(num + " ");
         System.out.println();
      }
      public static boolean LinearSearch(int[] G, int find)
      {
         int steps = 0;
         for (int temp : G)
         {
            steps++;
            if (temp == find)
            {
               System.out.println("steps "+steps);
               return true;
            }
         }
      			
         System.out.println("steps "+steps);
      
         return false;
      }
   
      public static boolean BinarySearch(int[] G, int find)
      {
         boolean found = false;
         int steps = 0;
         int low = -1;
         int high = G.length;
         int mid = 0;
         while (!found)
         {
         
            steps++;
            mid = (low + high) / 2;
            if (find == G[mid])
            {
               System.out.println("steps "+steps);
            
               return true;
            }
            else if (find < G[mid])
               high = mid;
            else
               low = mid;
            if (low >= high - 1 || high <= low + 1)
            {
               System.out.println("steps "+steps);
            
               return false;
            }
         
         }
      
         System.out.println("steps "+steps);
      
         return found;
      
      }
      private static int[] InsertionSortArray( int[] A)
      {
      
         int[] sorted = new int[A.length];
         int elements = 0;
         for (int a : A)
         {
            boolean found = false;
            int insertAt = 0;
            for (int i = 0; i < elements; i++)
            {
            
               if (a < sorted[i])
               {
                  found = true;
                  insertAt = i;
                  break;
               }
               if (!found)
                  insertAt = elements;
            
            }
         
            for (int i = elements - 1; i >= insertAt; i--)
            {
               sorted[i + 1] = sorted[i];
            
            }
         
            sorted[insertAt] = a;
            elements++;
         }
         return sorted;
      }
   }