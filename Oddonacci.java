package FirstAssign;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;

public class Oddonacci {
	
	public static long OddonacciMultiple(int a) {
		if( a==0 || a==1 || a==2 ) {
			return 1;
		}
		return OddonacciMultiple(a-1) + OddonacciMultiple(a-2) + OddonacciMultiple(a-3);
	}
	// b/ First algorithm has exponential time complexity because each of the method is called then it will lead to the call of another 3 recursive calls, which will create a recursion tree which will have more 3 recursion call while a method is called.
	// The result will not be stored. As a result, each of the method is called the whole process will run again and the same result can be calculated many times.
	// Number of method is called will grow as well as the larger number of a with the time complexity of O(3^n). This is why the algorithm not works well with big number of a.
	
	public static long OddonacciLinear(int n) {
		if( n==0 || n==1 || n==2 ) {
			return 1;
		}
		
		long[] array = new long[n+1];
		array[0] = 1;
		array[1] = 1;
		array[2] = 1;
		
		for(int i=3; i <= n; i++) {
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		return array[n];
	}
	// Second algorithm has linear time complexity because values will be stored in the array instead of calculating again over times, which will begin at the base case then calculating to the each value for only one time.
	// Each number is calculated by the three previous number, with LOOP structure (for...) will goes from 3 to n. 
	// Time complexity is O(n). This algorithm is more effective with larger number of n because each of value is calculated only one time which improve the disadvantage of the first algorithm. 
	// c/ Both of my method do not use Tail recursion because for the OddonacciMultiple method, the 3 recursion is called then it must take the result and sum up the previous one.
	// OddonacciLinear method does not use recursion so it is not the tail recursion too.
	// A tail-recursive version of Oddonacci calculator can be designed. 
	// The idea is that we must put the three numbers Oddonacci(n-1), Oddonacci(n-2), Oddonacci(n-3) to each recursive call and then if we hit n=0, we return the answer, And we must remember to not add anything after the recursion.
	
	
	public static void main (String[]args) {
		int[]value = {5,10,15};
		try {
			PrintWriter writerr = new PrintWriter("OddoOut.txt");
			for(int a : value ) {
				long start = System.nanoTime();
				long MultAnsw = OddonacciMultiple(a);
				long end = System.nanoTime();
				long TimeDuring = (end - start)/1000000; // transfer to milliseconds
				writerr.println("Multiple Oddonacci(" + a + ")= "+ MultAnsw + " with the time: " + TimeDuring + " ms");
				
				long startTime = System.nanoTime();
				long LinearAnsw = OddonacciLinear(a);
				long endTime = System.nanoTime();
				long TimeDurings = (endTime - startTime)/1000000;
				writerr.println("Linear Oddonacci(" + a + ")= "+ LinearAnsw + " with the time: " + TimeDurings + " ms");
				writerr.println(" ");
				
			}
			writerr.close();
			System.out.println("All done and saved to the file");
		}
		
		catch(IOException e) {
			System.out.println("Something is wrong with the input ");
		}
	}
	
	

}
