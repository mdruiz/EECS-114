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
 * Filename : DoublyLinkedList.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 


import java.util.Collection;

public class DoublyLinkedList<T> {
	private int numNodes;
	private Node<T> head;
	private Node<T> tail;
	
private class Node<T> {
//TODO: add fields here
	public Node<T> next;
	public Node<T> previous;
	public T element;
	
	public Node() {
		this.element = null;
		this.next = null;
		this.previous = null;
		
	}
	public Node(T t) {
		this.element = t;
		this.next = null;
		this.previous = null;
	}
}

public DoublyLinkedList () {
	this.head = null;
	this.tail = null;
	this.numNodes = 0;
}
public DoublyLinkedList (Collection<? extends T> c) {}

/**
 *  Adds an element to a node and places it in the given location of the list.
 *  
 * @param index the position in which to place the new element.
 * @return nothing.
 */
public void add(int index, T t){
	Node<T> newNode= new Node<T>(t);
	//if adding to empty list
	if(numNodes == 0){
		head = newNode;
		tail = newNode;
		numNodes++;
		System.out.println("New item added to list!");
	}
	//if adding to front
	else if (index == 0){
		head.previous = newNode;
		newNode.next = head;
		head =newNode;
		numNodes++;
		System.out.println("New item added to list!");
	}
	//if adding between two nodes
	else if ( index < numNodes && index>0){
		Node<T> frontNode = head;
		Node<T> backNode = head;
		for (int i=0; i<index; i++){
			frontNode = frontNode.next;
		}
		backNode = frontNode.previous;
		
		newNode.next = frontNode;
		newNode.previous = backNode;
		frontNode.previous = newNode;
		backNode.next = newNode;
		numNodes++;
		System.out.println("New item added to list!");
	}
	//if adding at the end
	else if (index == numNodes){
		tail.next = newNode;
		newNode.previous = tail;
		newNode = tail;
		numNodes++;
		System.out.println("New item added to list!");
	}
	// if index is out of bounds
	else{
		System.out.println("Index Out Of Bound!");
	}
}

/**
 *  Removes the item at the specified position.
 *  
 * @param index the position of the item to delete
 * @return the element of the item being deleted from the list.
 */
public T remove(int index) {
	//Node<T> currentNode = null;
	Node<T> removeNode = null;
	//if list is empty or index is out of bounds
	if(numNodes == 0 || index > numNodes-1 || index<0){
		System.out.println("Index Out Of Bound!");
		return null;
	}
	// if removing the only item in list
	else if (numNodes == 1){
		removeNode = head ;
		head = null;
		tail = null;
	}
	//if removing first item
	else if (index == 0){ 
		removeNode = head;
		head = head.next;
		head.previous = null;
	}
	//if removing from the middle
	else if ( index < numNodes-1 && index>0){
		removeNode = head;
		for (int i=0; i<index; i++){
			removeNode = removeNode.next;
		}
		removeNode.previous.next = removeNode.next;
		removeNode.next.previous = removeNode.previous;
	}
	//if removing the last item
	else if (index == numNodes-1){
		removeNode = tail;
		tail = tail.previous;
		tail.next = null;
	}
	numNodes--;
	System.out.println("Item removed from list");
	return removeNode.element;
}

/**
 *  Removes the item with the specified value.
 *  
 * @param o the value to look for and remove from the list.
 * @return the element of the item being removed.
 */
public T remove(Object o) {
	Node<T> currentNode = head;
	if (numNodes == 0){
		return null;
	}
	//if first item is removed
	if (currentNode.element.equals(o)){
		if (numNodes==1){
			head = null;
			tail = null;
		}
		else{
			head = head.next;
			head.previous = null;
		}
		numNodes--;
		System.out.println("Item removed from list");
		return currentNode.element;
	}
	else{
		for (int i=0; i<numNodes-1; i++){
			currentNode = currentNode.next;
			if (currentNode.element.equals(o)){
				//if removing the last item
				if (currentNode.next == null){
					currentNode = tail;
					tail = tail.previous;
					tail.next = null;
				}
				//if removing from the middle
				else{
					currentNode.previous.next = currentNode.next;
					currentNode.next.previous = currentNode.previous;
				}
				System.out.println("Item removed from list");
				numNodes--;
				return currentNode.element;
			}
		}
	}
	return null;
}

/**
  *  Returns the element at the specified position.
  *  
  * @param index the position in which to look for.
  * @return the element at the given position in the list. If the index is out of range (index < 0 || index >=size())
  */
public T get(int index) {
	Node<T> currentNode = head;
	if ( index < numNodes && index > -1){
		for (int i=0; i<index; i++){
			currentNode = currentNode.next;
		}
		return currentNode.element;
	}
	else {
		System.out.println("Index Out Of Bound!");
		return null;
	}
}

/**
 *  Returns the amount of items in the list.
 *  
 * @param none.
 * @return the amount of items in the list.
 */
public int size() {	return numNodes;}

/**
 *  Checks if the list is empty.
 *  
 * @param none
 * @return true if the list is empty or false if its not.
 */
public boolean isEmpty() {
	if (numNodes == 0){
		return true;
	}
	else
		return false;
}
}

