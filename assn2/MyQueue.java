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
 * Filename : MyQueue.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class MyQueue <T> {
	
	public SimpleList<T> Queue = new SimpleList<T>();
	
	
	public boolean isEmpty(){// - Returns true if queue is empty.
		if (Queue.size() == 0){
			return true;
		}
		return false;
	}
	
	public void push(T value){// - Inserts value onto the rear of the queue.
		Queue.insertAtPos(Queue.size(), value);
	}
	
	public void pop(){// - Removes the queue's front item. Throws a QueueUnderflowException if the queue is empty.
		try{
			if(Queue.size() == 0){
				throw new QueueUnderflowException("pop() on MyQueue of size == "+Queue.size());
			}
			Queue.removeAt(0);
		}
		catch (QueueUnderflowException e){
			e.printStackTrace();
		}
	}
	public T front(){// - Returns the front item in the queue. Throws a QueueUnderflowException if the queue is empty.
		try{
			if(Queue.size() == 0){
				throw new QueueUnderflowException("front() on MyQueue of size == "+Queue.size());
			}
		}
		catch(QueueUnderflowException e){
			e.printStackTrace();
		}
		return Queue.getAt(0);
	}

	
}
