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
 * Filename : WordLadder.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */
public class WordLadder {

	public WordLadder(String start, String end, SimpleList <String> dict ){
		//	create a stack of strings
		MyStack <String> StringStack = new MyStack<String>();
		//	push the start word on this stack
		StringStack.push(start);
		//	create a queue of stacks
		MyQueue<MyStack<String>> StackQueue = new  MyQueue<MyStack<String>>();
		//	enqueue this stack
		StackQueue.push(StringStack);
		//	while the queue is not empty
		while( StackQueue.isEmpty() == false){
			MyStack<String> currentStack = StackQueue.front();
			//	for each word in the dictionary
			for(int i=0; i < dict.size(); i++){
				//MyStack<String> currentStack = StackQueue.front();
				//	if a word is 1-letter different in any pos than top string of the front stack
				int check = checkDifference(dict.getAt(i) , currentStack.top());
				if(check == 1){
					//System.out.println(dict.getAt(i));
					//	if this word is the end word
					if(dict.getAt(i).equals(end)){
						// Done! The front stack plus this word is your word ladder.
						// output this word ladder
						System.out.println("Word Ladder Complete!");
						System.out.println(dict.getAt(i));
						print(currentStack);
						return;
					}
					//	make a copy of the front stack
					MyStack<String> copyStack = new MyStack<String>(currentStack);
					//	push the found word onto the copy
					copyStack.push(dict.getAt(i));
					//	enqueue the copy.
					StackQueue.push(copyStack);
				}
			}
			//	dequeue front stack
			StackQueue.pop();
		}
	}
	
	public int checkDifference(String one, String two){
		int count = 0;
		for(int i=0; i<5;i++){
			if(one.charAt(i) != two.charAt(i)){
				count++;
			}
		}
		return count;
	}
	
	private void print(MyStack<String> Ladder){
		while(Ladder.isEmpty() == false){
			System.out.println(Ladder.top());
			Ladder.pop();
		}
			
		
	}
}
