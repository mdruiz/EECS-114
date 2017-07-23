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
 * Assignment: lab2
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Main {

public static void main(String[] args) throws FileNotFoundException {
//TODO: Input a file name from args[0] (it can be have a directory appended to it) and open file to store in Scanner object.

	File NewFile= new File("words5.dict");
	Scanner s;
	try{
		s = new Scanner(NewFile);
	System.out.println(s.next());
	System.out.println(s.next());
	System.out.println(s.next());
	System.out.println(s.next());
	s.close();
	}
	catch(FileNotFoundException e)
	{
		System.out.println("No file found ");
	}
DoublyLinkedList<Integer> numLinkedList = new DoublyLinkedList<Integer>();
//After the next three insertion, the list will be 6,  5, and 1 in this order.
System.out.println("Empty: " +numLinkedList.isEmpty());
numLinkedList.add(0, 1);											// 1
numLinkedList.add(0, 5);											// 5, 1
numLinkedList.add(0, 6);											// 6, 5, 1
System.out.println("Empty: " +numLinkedList.isEmpty());				
System.out.println("Size of list: " +numLinkedList.size());     	
numLinkedList.add(0, 9);											// 9, 6, 5, 1
numLinkedList.add(8, 3);											// 9, 6, 5, 1
numLinkedList.add(2, 7);											// 9, 6, 7, 5, 1
System.out.println("Size of list: " +numLinkedList.size());
numLinkedList.remove(0); //remove() with int parameter is called	// 6, 7, 5, 1
numLinkedList.remove(new Integer(5)); // to prevent confusion between integer index and Integer object.	// 6, 7, 1
System.out.println("Size of list: " +numLinkedList.size());
//TODO: Add code to print the elements in numLinkedList
for (int i=0; i<numLinkedList.size(); i++){
	System.out.println(numLinkedList.get(i));
}

}
}
