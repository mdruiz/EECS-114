import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Mario
 * Last Name:  Ruiz
 * Lab Section: 1A
 * email address: mdruiz@uci.edu
 *
 *
 * Assignment: lab8
 * Filename : Graph.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Graph {
	ArrayList<Vertex> graphList;
	Vertex test_source;
	
	private class Vertex{
		private ArrayList<Vertex> neighbors;
		private int distance;
		private String label;
		
		public Vertex(String label){
			this.label = label;
			this.distance = -1;
			this.neighbors = new ArrayList<Vertex>();
		}
	}
	
	public Graph(String filename){
		build_graph(filename);
	}
	
	void build_graph(String filename){
		File newFile = new File(filename);
		Scanner s;
		try{
			s = new Scanner(newFile);
			int numNodes = s.nextInt();
			graphList = new ArrayList<Vertex>();
			int numEdges = s.nextInt();
			for(int i=0; i<numNodes ; i++){
				Vertex newVertex = new Vertex(s.next());
				graphList.add(newVertex);
			}
			for(int i=0; i<numEdges ; i++){
				String current = s.next();
				String newNeighbor = s.next();
				int curr = -1;
				int next = -1;
				
				for(int j=0; j<graphList.size(); j++){
					if (current.equals(graphList.get(j).label)){
						curr = j;
						break;
					}
				}
				for(int k=0; k<graphList.size(); k++){
					if (newNeighbor.equals(graphList.get(k).label)){
						next = k;
						break;
					}
				}
				Vertex temp = graphList.get(curr);
				Vertex temp1 = graphList.get(next);
				temp.neighbors.add(temp1);
			}			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	void display(){
		for(int i=0; i<graphList.size(); i++){
			Vertex temp = graphList.get(i);
			System.out.print(temp.label+" -> ");
			for(int j=0; j<temp.neighbors.size(); j++){
				System.out.print(temp.neighbors.get(j).label+", ");
			}
			if (temp.neighbors.size()==0){
				System.out.print("empty");
			}
			System.out.println();
		}
	}
	
	void display_levels(){
		System.out.println("(Label , Distance)");
		for(int i=0; i<graphList.size(); i++){
			Vertex temp = graphList.get(i);
			System.out.println(temp.label+" , "+temp.distance);
		}
	}
	
	void set_levels(Vertex source){
		for(int i=0; i<graphList.size(); i++){
			graphList.get(i).distance = -1;
		}
		Queue<Vertex> queue = new LinkedList<Vertex>();
		source.distance = 0;
		queue.add(source);
		while(queue.size() != 0){
			Vertex temp = queue.remove();
			ArrayList<Vertex> current = temp.neighbors;
			for(int i=0; i<current.size(); i++){
				if(current.get(i).distance == -1){
					current.get(i).distance = temp.distance +1;
					queue.add(current.get(i));
				}
			}
		}
	}
	
	boolean is_connected(Vertex source_vertex){
		for (int i=0; i<graphList.size();i++){
			if(graphList.get(i).distance == -1){
				return false;
			}
		}
		return true;
	}
	
	////***** setting source node ****////
	void set_source_and_levels(int index){
		test_source = graphList.get(index); 
		set_levels(test_source);
	}
	
	void test_is_connected(){
		System.out.println("Is the entire graph connected: "+is_connected(test_source));
	}
	
}
