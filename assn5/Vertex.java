import java.util.ArrayList;

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
 * Filename : Vertex.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */
public class Vertex{
		public ArrayList<Vertex> neighbors;
		public int distance;
		public int current_A;
		public int current_B;
		public Vertex parent;
		
		public Vertex(int current_A, int current_B){
			this.distance = -1;
			this.neighbors = new ArrayList<Vertex>();
			this.current_A = current_A;
			this.current_B = current_B;
			this.parent = null;
		}
	}