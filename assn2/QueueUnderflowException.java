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
 * Filename : QueueUnderflowException.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */
public class QueueUnderflowException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3180143913625862076L;

	public QueueUnderflowException(){
		
	}
	
	public QueueUnderflowException(String s){
		super(s);
	}
}
