package SecondAssign;
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class ExpandableStack {
	private char[]array;
	private int start; 
	private int size;
	private static ArrayList <String> words = new ArrayList<String>(10);
	
	public ExpandableStack() {
		this.size = 2;
		this.array = new char[size];
		this.start = -1;
	}
	
	
	//time complexity: O(1), it just push 1 element into the stack, but whenever the size is full, then it takes O(n) time to resize and create new array 
	//space complexity: new space is used to create new array so it is O(n) 
	public void push(char newchar) {
		if(isFull() == true) {
			System.out.println("Stack is full; its current size is " + size);
			increaseSize();
		}
		array[++start] = newchar;
	}
	
	//time complexity: O(1), it just pop out the last element in the array and change "start" value 
	//space complexity: O(1), no new space is used
    public char pop() {
		if(isEmpty() == true) {
			throw new RuntimeException("The stack is empty now, can not pop it");
		}
			return array[start--];
	}
    
    //time complexity: O(1), it just pop out the top element in the array without changing anything
  	//space complexity: O(1), no new space is used
    public char top() {
    	if(isEmpty() == true) {
    		throw new RuntimeException("The stack is empty now, can not pop it");
    	}
    	return array[start];
    }
    
    //time complexity: O(1), it just returns the current size of the array
  	//space complexity: O(1), no new space is used
    public int size() {
    	if(isEmpty() == true) {
    		throw new RuntimeException("The stack is empty now, can not pop it");
    	}
    	return start + 1;
    }
	
	//time complexity: O(1), it just checks whether the array is full or not 
    //space complexity: O(1), no new space is used 
	public boolean isFull() {
		if(start == array.length - 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//time complexity: O(1), it just checks whether the array is empty or not 
    //space complexity: O(1), no new space is used 
	public boolean isEmpty() {
		if(start == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//time complexity: O(n), because it creates a new array with double size and add all the elements from the previous one to the new one.
    //space complexity: O(n), new space is used ,which is double the old one, to create new array 
	public void increaseSize() {
		int newsize = size * 2;
		System.out.println("Will be expanding the size to " + newsize);
		char[] newone = new char[newsize];
		
		for(int i=0;i< size ;i++ ) {
			newone[i] = array[i];
		}
		array = newone;
		size = newsize;
	}
	
	//time complexity: O(n), the string is used to check through the loops 
    //space complexity: O(1), just some integer variables are used to count the characters, no new sapce is used
	public static boolean checkValid(String input) {
		boolean trueornot = false;
			String aline = input;
			int begin = 0;
			int stop = 0;
			int star = 0;
			for(int a=0; a< aline.length() ;a++) {
				if(aline.charAt(a) == '(') {
					begin++;
				}
				if(aline.charAt(a) == ')') {
					stop++;
				}
				if(aline.charAt(a) == '*') {
					star++;
				}
			}
			if(begin != stop && star >= 1) {
				for(int hay=1;hay <= star; hay++) {
				if((begin + stop + hay) % 2 == 0  ) {
					hay = star;
					trueornot = true;
					break;
				}
				trueornot = false;
				}		
			}
			else {
				if(begin != stop && star == 1) {
					trueornot = false;
				}
				else {
					if(begin == stop) {
					trueornot = true;
				}
			}
			}
		
		return trueornot;
		
	}
	
	//time complexity: O(n), because it read each lines then put it in Arraylist 
    //space complexity: O(n), the new space is used to store in arraylist depends on the strings in the input file.
	public static void readFromFile(String filename) throws IOException {
		Scanner sc = new Scanner(new FileInputStream(filename));
		String line = "";
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			words.add(line);
		}
		sc.close();
	}
	
	public static void main (String[]args) {
		ExpandableStack check = new ExpandableStack();
		try {
		check.push('A');
		check.push('B');
		check.push('C');
		check.push('D');
		System.out.println(check.pop());
		System.out.println(check.size());
		System.out.println(check.pop());
		System.out.println(check.size());
		readFromFile("C:\\Users\\Admin\\Desktop\\PA2_TestFile.txt");
		for(String s : words) {
		System.out.print(s + " ");	
		System.out.println(checkValid(s));
		}
		
		
		}
		catch(RuntimeException RE) {
			System.out.println((RE.getMessage()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
