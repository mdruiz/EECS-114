
/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: Assignment 1
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
	
	char[] charArray = {'M','a','r','i','o',' ','R','u','i','z'};
	MyList testList = new MyList(charArray,10);
	testList.print();
	System.out.println("Size of list is: " +testList.size());
	testList.pushFront('9');
	testList.pushBack('5');
	testList.print();
	System.out.println("Size of list is: " +testList.size());
	testList.remove(7);
	testList.remove('z');
	testList.print();
	System.out.println("Is 'r' in the list: " +testList.contains('r'));
	System.out.println("Is 'w' in the list: " +testList.contains('w'));
	System.out.println("Testing the get method: " +testList.get(4));
	testList.set(2, '3');
	testList.print();
	testList.popFront();
	testList.popBack();
	testList.print();
	testList.insertAtPos(8, 'K');
	testList.insertAfter(6, 'r');
	testList.insertBefore(1, '6');
	testList.print();
	System.out.println("Size of list is: " +testList.size());
	testList.swap(1, 9);
	testList.print();
	testList.reverse();
	testList.print();
	//testList.removeAll('z');//need to fix this end case

	System.out.println("Testing find(char) method: " +testList.find('o'));
	System.out.println("/////////////////////");
	System.out.println("Testing toString() method: " + testList.toString());
	
	
	MyList copyList = new MyList(testList);
	copyList.print();
	System.out.println(copyList.size());
	System.out.println("Are the two lists equal: " +testList.equals(copyList));
	copyList.set(8, '2');
	copyList.print();
	testList.print();
	System.out.println("Are the two lists equal: " +testList.equals(copyList));
	MyList sub = new MyList();
	sub = testList.subList(3, 9);
	sub.print();
	
}
}
