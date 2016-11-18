package funwithdatastructures;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author jameswilliams
 */
public class FunWithDataStructures {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
//     collections();
//      stacking(); 
//      hashSet(); 
      generics(); 
  }
  
  public static void generics(){
      String[] arr1 = {"goat", "tiger", "lion", 
          "goat", "hawk", "condore", "mole", "lion"};
      Character[] arr2 = {'r', 'y', 'a', 'n'};
      
      printMe(arr1);
      printMe(arr2);
  }

  private static <T> void printMe(T[] arr) {
      for (T x : arr) {
          System.out.printf("%s ", x);
      }
      System.out.println();
    }
  public static void hashSet(){
      String[] animals = {"goat", "tiger", "lion", 
          "goat", "hawk", "condore", "mole", "lion"}; 
      List<String> list = Arrays.asList(animals); 
      
      System.out.printf("%s", list);
      System.out.println();
      
      Set<String> set = new HashSet<String>(list);
      System.out.printf("%s", set);
  }
  
  public static void stacking(){
      Stack<Double> dubStack = new Stack<>();
      int n = 0; 
      do {
          dubStack.push(random()*1000); 
          n++; 
      } while (n < 250);
      
      printStack(dubStack);
     
      for (int i = 0; i < dubStack.size(); i++) {
          dubStack.pop();
      }
      
      printStack(dubStack);
      dubStack.pop();
      printStack(dubStack);
      dubStack.pop();
      printStack(dubStack);
  }
  
  private static void printStack(Stack<Double> dubStack) {
        
        if (dubStack.isEmpty()) {
            System.out.println("Stack is empty");
      } else {
            for (int i = 0; i < dubStack.size(); i++) {
                System.out.println(i + " - " +dubStack.pop());
            }
      }
    }
  
  
  public static void collections(){
      String[] myArr1 = {"goat", "tiger", "lion", "hawk"}; 
    List<String> myList1 = new ArrayList<>();
    // add arr to list  
    myList1.addAll(Arrays.asList(myArr1));
    
    String[] myArr2 = {"bison", "snake", "panda"};
    List<String> myList2 = new ArrayList<>(); 
    // add arr to list
    myList2.addAll(Arrays.asList(myArr2));
    
    for (int i = 0; i < myList1.size(); i++) {
        String get = myList1.get(i);
        System.out.println("list 1 get = " + get);
    }
    for (int i = 0; i < myList2.size(); i++) {
        String get = myList2.get(i);
        System.out.println("list 2 get = " + get);
    }
    myList1.sort(null);
    
    for (String x : myList1) {
        System.out.println("sorted list 1 get = " + x);
    }
    
    Collections.shuffle(myList1);
    
    for (String x : myList1) {
        System.out.println("shuffled my list 1 = " + x);
    }
    
      List<String> allList = new ArrayList<>(); 
      allList.addAll(myList1);
      allList.addAll(myList2);
      for (String x : allList) {
          System.out.println("all list = " + x);
      }
    Collections.sort(allList);
      for (String x : allList) {
          System.out.println("sorted all list = " + x);
      }
      Collections.shuffle(allList);
      for (String x : allList) {
          System.out.println("shuffled all list = " + x);
      }
      
      allList.removeAll(allList); 
      int i = 0;
      
      while (i < 250) {
          double d = (random()*10000);
          allList.add(Double.toString(d));
          i++;
      }
      
      for (String x : allList) {
          System.out.println("more all list = " + x);
      }
      Collections.sort(allList);
      for (String x : allList) {
          System.out.println("sorted all list = " + x);
      }
  }

    
}
