
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
 * Filename : MyList.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class MyList {
	// MyList class
		private Node head;
	// Node class
	private class Node {
		private char value;
		private Node next;

		public Node(char value, Node next) {
			 this.setElement(value);
			 this.setNext(next);
		}

		// Accessor methods
		public char getElement() { return value; }
		public Node getNext() { return next; }
		
		// Modifier methods
		public void setElement(char v) { value = v; }
		public void setNext(Node n) { next = n; }
	}
	
	// Implement required methods here
	
	public MyList(){
		this.head = null;

	}
	
	public MyList(MyList rhs){
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
	
	public MyList (char[] charArray, int n){
		this.head = null;
		for (int i=0; i<n; i++){
			this.pushBack(charArray[i]);
		}
	}
	
	public boolean remove(int index){
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

	public boolean remove(char value){
		Node tempNode = head;
		if (this.size() == 0){
			return false;
		}
		//if first item is removed
		if (tempNode.getElement() == value){
			if (this.size()==1){
				head = null;
			}
			else{
				head = head.getNext();
			}
			return true;
		}
		else{
			for (int i=0; i<this.size()-1; i++){
				if (tempNode.getNext().getElement() == value ){
					//if removing from the middle or end
					tempNode.setNext(tempNode.getNext().getNext());
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		return false;
	}

	public boolean removeAll(char value){
		boolean temp = false;
		if (this.size() == 0){
			return false;
		}
		//if first item is removed
		while (head.getElement() == value){
			if (this.size()==1){
				head = null;
				return true;
			}
			else{
				head = head.getNext();
			}
			temp = true;
		}
		Node tempNode = head;
		for (int i=0; i<this.size()-1; i++){
			while (tempNode.getNext().getElement() == value ){
				//if removing from the middle or end
				tempNode.setNext(tempNode.getNext().getNext());
				temp = true;
			}
			tempNode = tempNode.getNext();
		}
		return temp;
	}
	
	public Node previous(Node curr){
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
	
	public Node next(Node curr){
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
	
	public boolean contains(char value){
		Node tempNode = head;
		if (this.size() == 0){
			return false;
		}
		for (int i=0; i<this.size(); i++){
			if (tempNode.getElement() == value){
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}
	
	public char get(int index){
		Node tempNode = head;
		if ( index < this.size() && index > -1){
			for (int i=0; i<index; i++){
				tempNode = tempNode.getNext();
			}
			return tempNode.getElement();
		}
		else {
			System.out.println("Index Out Of Bound!");
			return '\0';
		}
	}
	
	public void set(int index, char value){
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
	
	public boolean equals(MyList llist){
		if (this.size() != llist.size()){
			return false;
		}
		Node tempNode1 = this.head;
		Node tempNode2 = llist.head;
		for(int i=0; i<this.size();i++){
			if (tempNode1.getElement() != tempNode2.getElement()){
				//System.out.print("temp value is : " +tempNode1.getElement());
				return false;
			}
			tempNode1 = tempNode1.getNext();
			tempNode2 = tempNode2.getNext();
		}
		return true;
	}
	
	public void pushFront(char value){
		Node newNode= new Node(value, head);
		head = newNode;
	}
	
	public void pushBack(char value){
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
	
	public void popFront(){
		if (this.size() == 0){
			System.out.println("No items in list");
			return;
		}
		head = head.getNext();
	}
	
	public void popBack(){
		if (this.size() == 0){
			System.out.println("No items in list");
			return;
		}
		Node tempNode = head;
		for (int i=0; i<this.size()-2; i++){
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(null);
	}
	
	public void swap(int i, int j){
		if (this.size() == 0 || i > this.size() -1 || j > this.size() -1){
			System.out.println("Index Out Of Bounds! ");
			return;
		}
		Node tempNode1 = head;
		Node tempNode2 = head;
		char temp1, temp2;
		
		for (int k=0; k<i; k++){
			tempNode1 = tempNode1.getNext();
		}
		temp1 = tempNode1.getElement();
		for (int k=0; k<j; k++){
			tempNode2 = tempNode2.getNext();
		}
		temp2 = tempNode2.getElement();
		tempNode1.setElement(temp2);
		tempNode2.setElement(temp1);
		
	}
	
	public void insertAtPos(int i, char value){
		Node newNode;
		//if adding to front of list
		if (i == 0){
			newNode = new Node(value,head);
			head =newNode;
		}
		//if adding between two nodes or end
		else if ( i <= this.size() && i>0){
			Node tempNode = head;
			for (int j=0; j<i-1; j++){
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
	
	public void insertAfter(int i, char value){
		Node newNode;
		i++;
		//if adding between two nodes or end
		if ( i <= this.size() && i>0){
			Node tempNode = head;
			for (int j=0; j<i-1; j++){
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
	
	public void insertBefore(int i, char value){
		Node newNode;
		i--;
		if (i == 0){
			newNode = new Node(value,head);
			head =newNode;
		}
		//if adding between two nodes or end
		else if ( i <= this.size() && i>0){
			Node tempNode = head;
			for (int j=0; j<i-1; j++){
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
	
	public MyList subList(int fromIndex, int toIndex){
		if (fromIndex > toIndex || fromIndex < 0 || toIndex > this.size() ){
			System.out.println("Index Out Of Bounds!");
			return (new MyList());
		}
		MyList newList = new MyList(this);
		for (int i=0; i < fromIndex; i++){
			newList.popFront();
		}
		for (int i=0; i < (this.size()-toIndex); i++){
			newList.popBack();
		}
		return newList;
	}
	
	public int find(char value){
		Node tempNode = head;
		if (this.size() == 0){
			return -1;
		}
		for (int i=0; i<this.size(); i++){
			if (tempNode.getElement() == value){
				return i;
			}
			tempNode = tempNode.getNext();
		}
		return -1;
	}
	
	public int find(MyList queryStr){
		return -1;
	}
	
	public char[] toArray(){
		char[] result = new char[this.size()];
		Node tempNode = head;
		for (int i=0; i<this.size();i++){
			result[i] = tempNode.getElement();
			tempNode = tempNode.getNext();
		}
		return result;
	}
	
	public void reverse(){
		Node prev   = null;
	    Node current = head;
	    Node next;
	    while (current != null)
	    {
	        next  = current.getNext();  
	        current.setNext(prev);   
	        prev = current;
	        current = next;
	    }
	    head = prev;
	}
	
	public int size(){
		Node tempNode = head;
		int count=0;
		while (tempNode != null){
			count++;
			tempNode = tempNode.getNext();
		}
		return count;
	}
	
	public void print(){
		System.out.println("Printing List: ");
		for (int i=0; i<this.size(); i++){
			System.out.print(this.get(i));
		}
		System.out.println("");
	}
	
	public String toString(){
		String result = new String(this.toArray());
		return result;
	}
}
