
/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: assn5
 * Filename : PriorityQueue.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */
public class PriorityQueue {
	
	private Vertex h[];
	private int queueSize; // the number of items stored in h
	public static final int CAPACITY = 100;
	
	public PriorityQueue(){
		this.h = new Vertex[CAPACITY];
		this.queueSize = 0;
	}
	
	public PriorityQueue(Vertex[] A){
		this.h = new Vertex[CAPACITY]; //Initialize h of size CAPACITY
		//Copy A into h
		for (int i=0; i < A.length; i++){
			this.h[i]= A[i];
		}
		this.queueSize = A.length;
		buildPriorityQueue();
	}

	public void buildPriorityQueue(){
		for (int i = (queueSize/2)-1; i >= 0; i--){
			trickleDown(i);
		}
	}
	
	public Vertex front(){
		if (this.queueSize == 0){
			throw new IndexOutOfBoundsException("queue is empty!");
		}
		return this.h[0];
	}
	
	public boolean isEmpty(){// - Returns true if queue is empty.
		if (queueSize == 0){
			return true;
		}
		return false;
	}
	
	public Vertex pop(){
		if(this.queueSize == 0){
			throw new IndexOutOfBoundsException("queue is empty!");
		}
		Vertex result = this.h[0];
		this.h[0] = this.h[this.queueSize-1];
		this.queueSize--;
		trickleDown(0);
		return result;
	}
	
	public void push(Vertex key){
		if(this.queueSize == this.h.length){
			throw new IndexOutOfBoundsException("queue is full!");
		}
		this.h[this.queueSize] = key;
		this.queueSize++;
		trickleUp(this.queueSize - 1);
	}
	
	private void trickleDown(int index){
		int current = index;
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		Vertex temp;
		// while the parent violates the Min Heap properties, trickle down
		while( (leftChild < this.queueSize && this.h[current].distance > this.h[leftChild].distance) || (rightChild <= this.queueSize && this.h[current].distance > this.h[rightChild].distance)){
			// if parent has two children
			if ((rightChild) <= this.queueSize){
				if( this.h[current].distance > this.h[leftChild].distance || this.h[current].distance > this.h[rightChild].distance){
					// if left child is smaller
					if(this.h[leftChild].distance < this.h[rightChild].distance){
						temp = this.h[leftChild];
						this.h[leftChild] = this.h[current];
						this.h[current] = temp;
						current = leftChild;
					}
					//if right child is smaller
					else{
						temp = this.h[rightChild];
						this.h[rightChild] = this.h[current];
						this.h[current] = temp;
						current = rightChild;
					}
				}
			}
			//if parent only has one child
			else if(leftChild <= this.queueSize){
				if( this.h[current].distance > this.h[leftChild].distance){
					temp = this.h[leftChild];
					this.h[leftChild] = this.h[current];
					this.h[current]= temp;		
					current = leftChild;
				}
			}
			else{
				break;
			}
			leftChild = 2*current + 1;
			rightChild = 2*current + 2;
		}
	}
	
	private void trickleUp(int index){
		int current = index;
		int parent = (index - 1)/2;
		Vertex temp;
		while (this.h[parent].distance > this.h[current].distance ){
			temp = this.h[parent];
			this.h[parent] = this.h[current];
			this.h[current] = temp;
			current = parent;
			parent = (current - 1)/2;
		}
	}
	
	public void decrease_priority(Vertex current, int distance){
		for(int i=0;i<queueSize;i++){
			if(this.h[i].equals(current)){
				this.h[i].distance = distance;
				buildPriorityQueue();
				return;
			}
		}
	}
	
	public boolean contains(Vertex current){//returns true if it contains
		for(int i=0;i<queueSize;i++){
			if(this.h[i].equals(current)){
				return true;
			}
		}
		return false;
	}
	
	public void print(){
		System.out.println("Printing Priority Queue:");
		int current=0;
		int total = 1;
		for(int i=0; i < this.queueSize;i++){
			if(i == ((current*2)+total)){
				System.out.println();
				if (current == 0){
					current++;
				}
				else{
					current = current *2;
				}
				total = i;
			}
			
			System.out.print(this.h[i].distance+ " ");
			
		}
		System.out.println(" ");
	}
}
