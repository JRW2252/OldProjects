package sorting;

/**
 *
 * @author jameswilliams
 */
public class MergeSort {
    public static void main(String[] args) {
		int []a = {2,15,22,47,51};
		int []b = {14,18,26,45,49,56,78};
		
		// Array C of sum of size of the two sorted array A and B
		int []c = new int[a.length+b.length];
		
		merge(a,b,c);
		System.out.print("Array a: ");
		printArray(a);
		System.out.println();
		System.out.print("Array b: ");
		printArray(b);
		System.out.println();
		System.out.print("Array c: ");
		printArray(c);
	}

	public static void merge(int []a, int []b, int []c){
		int cursorA = 0,cursorB = 0,cursorC = 0;
		int sizeA = a.length;
		int sizeB = b.length;
		
		// Runs until neither array is empty
		while(cursorA < sizeA && cursorB < sizeB){
			// Compare the items of two arrays and copy the smaller item into to third array
			if(a[cursorA] < b[cursorB]){
				c[cursorC++] = a[cursorA++];
			}else{
				c[cursorC++] = b[cursorB++];
			}
		}
		
		// If array B's cursor scanned and compared all the items of the array
		// but array A's is not
		while(cursorA < sizeA){
			c[cursorC++] = a[cursorA++];
		}
		
		// If array A's cursor scanned and compared all the items of the array
		// but array B's is not
		while(cursorB < sizeB){
			c[cursorC++] = b[cursorB++];
		}
	}
	
	public static void printArray(int []array){
		for(int i : array){
			System.out.print(i+" ");
		}
	} 
}
