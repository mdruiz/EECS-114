/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: lab8
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Main {
	public static void main(String[] args){
		
		Graph test = new Graph(args[0]);
		
		System.out.println("----------------------------------------------------");
		System.out.println("Printing out graph's adjacency list (source = Nile)");
		System.out.println("----------------------------------------------------");
		
		test.display();
		
		System.out.println("----------------------------------------------------");
		System.out.println("Testing display_levels() with source = Nile");
		System.out.println("----------------------------------------------------");
		
		test.set_source_and_levels(0);
		test.display_levels();
		test.test_is_connected();
		
		System.out.println("----------------------------------------------------");
		System.out.println("Testing display_levels() with source = Mondavi");
		System.out.println("----------------------------------------------------");
		
		test.set_source_and_levels(1);
		test.display_levels();
		test.test_is_connected();
		
		System.out.println("----------------------------------------------------");
		System.out.println("Testing display_levels() with source = Lodi");
		System.out.println("----------------------------------------------------");
		
		test.set_source_and_levels(2);
		test.display_levels();
		test.test_is_connected();
		
	}
}
