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
 * Filename : SimpleList.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class SimpleList <T> {
	private Node head;
		
	private class Node {
		private T value;
		private Node next;

		public Node(T value, Node next) {
			 this.setElement(value);
			 this.setNext(next);
		}

		// Accessor methods
		public T getElement() { return value; }
		public Node getNext() { return next; }
		
		// Modifier methods
		public void setElement(T v) { value = v; }
		public void setNext(Node n) { next = n; }
	}
		
	public SimpleList(){
		this.head = null;
	}
	
	public SimpleList(SimpleList <T> rhs){ // - Constructor. Instantiates this list as a deep copy of rhs.
		this.head = null;
		Node tempNode = rhs.head;
		if (tempNode == null){
			return;
		}
		while(tempNode.getNext() != null){
			this.pushBack(tempNode.getElement());
			tempNode = tempNode.getNext();
		}
		this.pushBack(tempNode.getElement());
		System.out.println("List copied ");
		
	}
	
	
	public Node previous(Node curr){// - Returns the previous node for the specified node curr.
		Node tempNode = head;
		if (this.size() == 0 || head == curr){
			return null;
		}
		for (int i=0; i<this.size()-1; i++){
			if(tempNode.getNext() == curr ){
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public Node next(Node curr){// - Returns the next node for the specified node curr.
		Node tempNode = head;
		if (this.size() == 0){
			return null;
		}
		for (int i=0; i<this.size(); i++){
			if (tempNode == curr){
				return tempNode.getNext();
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public T getAt(int index){// - Returns the element at the specified position in this list.
		Node tempNode = head;
		if ( index < this.size() && index > -1){
			for (int i=0; i<index; i++){
				tempNode = tempNode.getNext();
			}
			return tempNode.getElement();
		}
		else {
			System.out.println("Index Out Of Bound!");
			return null;
		}
	}
	
	public void setAt(int index, T value){// - Replaces the element at the specified position in this list with the
	//specified element.
		Node tempNode = head;
		if ( index >= this.size() || index < 0){
			System.out.println("Index Out Of Bounds! ");
			return;
		}
		for (int i=0; i<index; i++){
			tempNode = tempNode.getNext();
		}
		tempNode.setElement(value);
	}
	
	public void insertAtPos(int index, T value){// - Inserts a node with specified value at specified position
	//in the list, shifting elements starting at i to the right, if needed.
		Node newNode;
		//if adding to front of list
		if (index == 0){
			newNode = new Node(value,head);
			head =newNode;
		}
		//if adding between two nodes or end
		else if ( index <= this.size() && index>0){
			Node tempNode = head;
			for (int j=0; j<index-1; j++){
				tempNode = tempNode.getNext();
			}
			newNode = new Node(value,tempNode.getNext());
			tempNode.setNext(newNode);
		}
		// if index is out of bounds
		else{
			System.out.println("Index Out Of Bound!");
		}
	}
		
	public boolean removeAt(int index){// - Removes the element at the specified position index in this list.
	//Returns true if this list contained the specified element.
		Node tempNode = head;
		//if list is empty or index is out of bounds
		if(this.size() == 0 || index > this.size()-1 || index<0){
			System.out.println("Index Out Of Bound!");
			return false;
		}
		// if removing the only item in list
		else if (this.size() == 1){
			head = null;
		}
		//if removing first item
		else if (index == 0){ 
			head = head.getNext();
		}
		//if removing from the middle or end
		else if ( index < this.size() && index>0){
			for (int i=0; i<index-1; i++){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
		}
		return true;
	}
		
	public int size(){// - Returns the number of items in the list.
		Node tempNode = head;
		int count=0;
		while (tempNode != null){
			count++;
			tempNode = tempNode.getNext();
		}
		return count;
	}
	
	public String toString(){// - Overrides the toString() method. Returns the formatted contents of this as a
	//String. Allows for printing a MyList instance llist to standard output in following way,
	//System.out.println("llist contents = " + llist);
		return null;
	}
	
	public void pushBack(T value){
		Node newNode = new Node(value, null);
		if (this.size() == 0){
			head = newNode;
			return;
		}
		Node tempNode = head;
		for (int i=0; i<this.size()-1; i++){
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(newNode);
	}
	
}
