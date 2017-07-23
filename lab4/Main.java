import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: lab4
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Main {
	
	public static void main(String[] args)  {
		File NewFile= new File("input_int_small.txt");
		Scanner s;
		try{
			s = new Scanner(NewFile);
			int temp[] = new int[10];
            int i = 0;
			while (s.hasNext()){
				temp[i] = s.nextInt();
				i++;
			}
			s.close();
			System.out.println("Testing input_int_small:");
			System.out.println("__________________________________________");
			MaxHeap test = new MaxHeap(temp);
			test.print();
			System.out.println("__________________________________________");
			
			System.out.println("__________________________________________");
			MinHeap test2 = new MinHeap(temp);
			test2.print();
			System.out.println("__________________________________________");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No file found ");
		}
		
		System.out.println("__________________________________________");
		System.out.println("__________________________________________");
		System.out.println("__________________________________________");
		System.out.println("__________________________________________");
		
		System.out.println("Testing buildMaxHeap:");
		int testArray[] = {10,7,14,9,8,6,12,2,19};
		MaxHeap testMax = new MaxHeap(testArray);
		testMax.print();
		System.out.println("The heap max is : " + testMax.heapMax());
		System.out.println("__________________________________________");
		System.out.println("Testing maxHeapInsert:");
		testMax.maxHeapInsert(89);
		testMax.print();
		System.out.println("The heap max is : " + testMax.heapMax());
		System.out.println("__________________________________________");
		System.out.println("Testing heapExtractMax():");
		testMax.heapExtractMax();
		testMax.print();
		System.out.println("The heap max is : " + testMax.heapMax());
		System.out.println("__________________________________________");
		
		System.out.println("___________________________________________");
		System.out.println("");
		System.out.println("Testing buildMinHeap:");
		MinHeap testMin = new MinHeap(testArray);
		testMin.print();
		System.out.println("The heap min is : " + testMin.heapMin());
		System.out.println("__________________________________________");
		System.out.println("Testing minHeapInsert:");
		testMin.minHeapInsert(1);
		testMin.print();
		System.out.println("The heap min is : " + testMin.heapMin());
		System.out.println("__________________________________________");
		System.out.println("Testing heapExtractMin():");
		testMin.heapExtractMin();
		testMin.print();
		System.out.println("The heap min is : " + testMin.heapMin());
		System.out.println("__________________________________________");
		
	}

	
}
