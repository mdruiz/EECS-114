
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
 * Filename : MyStack.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class MyStack <T>{

	final private int CAPACITY = 4000;		// - size of the stack's internal array
	private int t;		// - index to the position of the top item in the stack
	private T[] data; 	// - array that holds contents of the stack
	
	@SuppressWarnings("unchecked")
	public MyStack (){// - Constructor. Initializes and allocates an empty stack.
		this.data = (T[]) new Object[CAPACITY];
		this.t = -1;
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(MyStack<T> rhs){
		this.data = (T[]) new Object[CAPACITY];
		this.t = -1;
		int i = 0;
		while(rhs.data[i] != null){
			this.data[i] = rhs.data[i];
			this.t++;
			i++;
		}
	}
	
	public boolean isEmpty(){// - Returns true if stack is empty.
		if (this.t == -1){
			return true;
		}
		return false;
	}
	
	public int size(){// - Returns the size of the stack.
		return t+1;
	}
	
	public void push(T value){// - Inserts value onto the top of the stack. Throws a StackOverflowException
	//if the stack is full.
		try{
			if (this.size() == CAPACITY){
				throw new StackOverflowException("push() on MyStack with CAPACITY == "+this.CAPACITY+", size == "+this.size());
			}
			this.data[t+1] = value;
			t++;
		}
		catch(StackOverflowException e){
			e.printStackTrace();
		}
	}
	
	public void pop(){// - Removes the stack's top item. Throws a StackUnderException if the stack is empty. 
		try{
			if (this.isEmpty() == true){
				throw new StackUnderflowException("pop() on MyStack of size == "+this.size());
			}
			this.data[this.t] = null;
			this.t--;
		}
		catch(StackUnderflowException e){
			e.printStackTrace();
		}
	}
	
	public T top(){// - Returns the stack's top item. Throws a StackUnderException if the stack is empty.
		try{
			if (this.isEmpty() == true){
				throw new StackUnderflowException("top() on MyStack of size == "+this.size());
			}
		}
		catch(StackUnderflowException e){
			e.printStackTrace();
		}
		return this.data[this.t];
	}
}
