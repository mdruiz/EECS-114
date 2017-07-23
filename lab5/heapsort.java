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
 * Assignment: lab5
 * Filename : heapsort.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class heapsort {
	
	public static void main(String args[]){
		//int test[] = new int[]{10,16,14,10,8,7,9,3,2,4,1};
		File newFile = new File(args[0]);
		Scanner s;
		try{
			s = new Scanner(newFile);
			int temp = s.nextInt();
			int test[] = new int[temp+1];
			test[0] = temp;
            int i = 1;
			while (s.hasNext()){
				test[i] = s.nextInt();
				i++;
			}
			s.close();
			Heapsort(test,test[0]);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void Heapsort(int[] A, int n){
		BuildMaxHeap(A, n);
		print(A,n);
		int temp;
		for(int i = n; i>1; i--){
			temp = A[1];
			A[1] = A[i];
			A[i] = temp;
			MaxHeapify(A, i-1, 1);
			print(A, n);
		}
	}
	
	public static void BuildMaxHeap(int[] array ,int heapSize){
		for (int i = (heapSize/2)-1; i > 0; i--){
			MaxHeapify(array, heapSize, i);
		}
	}
	
	private static void MaxHeapify(int[] h, int heapSize, int index){
		int current = index;
		int leftChild = 2*index ;
		int rightChild = 2*index +1;
		int temp;
		// while the parent violates the Max Heap properties, trickle down
		while( h[current] < h[leftChild] || (rightChild < heapSize && h[current] < h[rightChild])){
			leftChild = 2*current ;
			rightChild = 2*current +1;
			// if parent has two children
			if ((rightChild) <= heapSize){
				if( h[current] < h[leftChild] || h[current] < h[rightChild]){
					// if left child is bigger
					if(h[leftChild] > h[rightChild]){
						temp = h[leftChild];
						h[leftChild] = h[current];
						h[current] = temp;
						current = leftChild;
					}
					//if right child is bigger
					else{
						temp = h[rightChild];
						h[rightChild] = h[current];
						h[current] = temp;
						current = rightChild;
					}
				}
			}
			//if parent only has one child
			else if(leftChild <= heapSize){
				if( h[current] < h[leftChild]){
					temp = h[leftChild];
					h[leftChild] = h[current];
					h[current] = temp;		
					current = leftChild;
				}
			}
			else{
				break;
			}
		}
	}
	
	
	public static void print(int[] h, int heapSize){
		for(int i=1; i <= heapSize;i++){
			System.out.print(h[i] + " ");
		}
		System.out.println();
		
	}
}
