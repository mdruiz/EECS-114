/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: Assignment 2
 * Filename : StackOverflowException.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class StackOverflowException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9144560126822686752L;
	
	public StackOverflowException() {
		
	}
	public StackOverflowException(String s){
		super(s);
	}
}
