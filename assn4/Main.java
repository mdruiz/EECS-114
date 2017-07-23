
/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: assn4
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */
public class Main {
	public static void main(String[] args)  {
		
		System.out.println("Testing Priority Queue:");
		PriorityQueue test = new PriorityQueue();
		
		Vertex newVertex = new Vertex(0, 1);
		newVertex.distance = 4;
		test.push(newVertex);
		
		newVertex = new Vertex(0, 2);
		newVertex.distance = 3;
		test.push(newVertex);

		newVertex = new Vertex(0, 3);
		newVertex.distance = 8;
		test.push(newVertex);
		
		newVertex = new Vertex(0, 4);
		newVertex.distance = 2;
		test.push(newVertex);
		
		newVertex = new Vertex(0, 5);
		newVertex.distance = 7;
		test.push(newVertex);
		
		newVertex = new Vertex(0, 6);
		newVertex.distance = 5;
		test.push(newVertex);
		
		newVertex = new Vertex(0, 7);
		newVertex.distance = 12;
		test.push(newVertex);
		
		newVertex = new Vertex(0, 8);
		newVertex.distance = 1;
		test.push(newVertex);
		
		test.print();
		
		Vertex temp = test.pop();
		System.out.println("Popping: ("+temp.current_A+","+temp.current_B+") ,"+temp.distance+" ");
		temp = test.pop();
		System.out.println("Popping: ("+temp.current_A+","+temp.current_B+") ,"+temp.distance+" ");
		temp = test.pop();
		System.out.println("Popping: ("+temp.current_A+","+temp.current_B+") ,"+temp.distance+" ");
		temp = test.pop();
		System.out.println("Popping: ("+temp.current_A+","+temp.current_B+") ,"+temp.distance+" ");
		test.print();
		
		System.out.println("=================================================");
		
		PriorityQueue test2 = new PriorityQueue();
		
		newVertex = new Vertex(0, 1);
		newVertex.distance = 8;
		test2.push(newVertex);
		
		newVertex = new Vertex(0, 2);
		newVertex.distance = 7;
		test2.push(newVertex);

		Vertex newVertex1 = new Vertex(0, 3);
		newVertex1.distance = 7;
		test2.push(newVertex1);
		
		newVertex = new Vertex(0, 4);
		newVertex.distance = 7;
		test2.push(newVertex);
		
		newVertex = new Vertex(0, 5);
		newVertex.distance = 3;
		test2.push(newVertex);
		
		Vertex newVertex2 = new Vertex(0, 6);
		newVertex2.distance = 3;
		test2.push(newVertex2);
		
		newVertex = new Vertex(0, 7);
		newVertex.distance = 3;
		test2.push(newVertex);
		
		test2.print();
		
		test2.decrease_priority(newVertex1, 2);
		test2.decrease_priority(newVertex2, 9);
		
		test2.print();
	}
	
	
}
