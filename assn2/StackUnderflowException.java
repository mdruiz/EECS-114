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
 * Filename : StackUnderflowException.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class StackUnderflowException extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6353615961903561518L;

	public StackUnderflowException(){
		
	}
	
	public StackUnderflowException(String s){
		super(s);
	}
	
	
}
