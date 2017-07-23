import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
 * Filename : Graph.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Graph {
	//ArrayList<Vertex> graphList;
	Vertex[][] graphList;
	Vertex test_source;
	int Ca, Cb, N, fA, fB, eA, eB, pAB, pBA;
	ArrayList<String> solution;
	
	public Graph(int Ca, int Cb, int N, int fA, int fB, int eA, int eB, int pAB, int pBA){
		this.Ca = Ca;	// capacity of Jug A
		this.Cb = Cb;	// capacity of Jug B
		this.N = N;		// goal in B
		this.fA = fA;	// cost to fill A
		this.fB = fB;	// cost to fill B
		this.eA = eA;	// cost to empty A
		this.eB = eB;	// cost to empty B
		this.pAB = pAB;	// cost to pour A to B
		this.pBA = pBA;	// cost to pour B to A
		build_graph();
	}
	
	void build_graph(){
		//graphList = new ArrayList<Vertex>();
		graphList = new Vertex[Ca+1][Cb+1];
		//making nodes for all possible situations
		for(int i =0; i<=Ca; i++){
			for(int j=0; j<=Cb; j++){
				Vertex newVertex = new Vertex(i,j);
				graphList[i][j] = newVertex;
			}
		}
		//connecting nodes to neighbors
		for(int i =0; i<=Ca; i++){
			for(int j=0; j<=Cb; j++){
				int curr_A = graphList[i][j].current_A;
				int curr_B = graphList[i][j].current_B;
				//fill A
				if(curr_A != Ca){
					graphList[i][j].neighbors.add(graphList[Ca][j]);
				}
				//fill B
				if(curr_B != Cb){
					graphList[i][j].neighbors.add(graphList[i][Cb]);
				}
				//empty A
				if(curr_A != 0){
					graphList[i][j].neighbors.add(graphList[0][j]);
				}
				//empty B
				if(curr_B != 0){
					graphList[i][j].neighbors.add(graphList[i][0]);
				}
				//pour A into B
				if(curr_A != 0 && curr_B != Cb){
					int tempA, tempB;
					tempB = curr_A + curr_B;
					tempA = 0;
					if(tempB > Cb){
						tempA = tempB-Cb;
						tempB = Cb;
					}
					graphList[i][j].neighbors.add(graphList[tempA][tempB]);
				}
				//pour B into A
				if(curr_B != 0 && curr_A != Ca){
					int tempA, tempB;
					tempA = curr_A + curr_B;
					tempB = 0;
					if (tempA > Ca){
						tempB = tempA - Ca;
						tempA = Ca;
					}
					graphList[i][j].neighbors.add(graphList[tempA][tempB]);
				}
			}
		}
	}

	void display(){
		for(int i =0; i<=Ca; i++){
			for(int j=0; j<=Cb; j++){
				Vertex temp = graphList[i][j];
				System.out.print("("+temp.current_A+","+temp.current_B+") -> ");
				for(int k=0; k<temp.neighbors.size();k++){
					System.out.print("("+temp.neighbors.get(k).current_A+","+temp.neighbors.get(k).current_B+") , ");
				}
				System.out.println();
			}
		}
	}
	//BFS
	void set_levels(){
		for(int i =0; i<=Ca; i++){
			for(int j=0; j<=Cb; j++){
				graphList[i][j].distance = -1;
				graphList[i][j].parent = null;
			}
		}
		Queue<Vertex> queue = new LinkedList<Vertex>();
		Vertex source = graphList[0][0];
		source.distance = 0;
		queue.add(source);
		while(queue.size() != 0){
			Vertex temp = queue.remove();
			ArrayList<Vertex> current = temp.neighbors;
			for(int i=0; i<current.size(); i++){
				if(current.get(i).distance == -1){
					current.get(i).distance = temp.distance +1;
					current.get(i).parent = temp;
					queue.add(current.get(i));
				}
			}
		}
	}
	//Dijkstra's
	void set_levels2(){
		//init-single-source
		PriorityQueue pQueue = new PriorityQueue();
		for(int i =0; i<=Ca; i++){
			for(int j=0; j<=Cb; j++){
				graphList[i][j].distance = 1000000;
				graphList[i][j].parent = null;
				pQueue.push(graphList[i][j]);
			}
		}
		Vertex source = graphList[0][0];
		source.distance = 0;
		while(!pQueue.isEmpty()){
			Vertex temp = pQueue.pop();
			ArrayList<Vertex> current = temp.neighbors;  
			for(int i=0; i<current.size(); i++){
				if(!(pQueue.contains(current.get(i)))){
					continue;
				}
				int alt = temp.distance + findWeight(temp,current.get(i));
				if(alt < current.get(i).distance){
					current.get(i).distance = alt;
					current.get(i).parent = temp;
					pQueue.decrease_priority(current.get(i), alt);
				}
			}
		}
	}
	
	private int findWeight(Vertex source, Vertex current) {
		if(source.current_A == current.current_A){
			//eB or fB
			if(current.current_B == 0){
				return eB;
			}
			else{
				return fB;
			}
		}
		else if(source.current_B == current.current_B){
			//eA or fA
			if(current.current_A == 0){
				return eA;
			}
			else{
				return fA;
			}
		}
		else{
			//pAB or pBA occured
			if(source.current_A > current.current_A ){
				return pAB;
			}
			else{
				return pBA;
			}
		}
	}

	void display_levels(){
		for(int i =0; i<=Ca; i++){
			for(int j=0; j<=Cb; j++){
				Vertex temp = graphList[i][j];
				System.out.println("("+temp.current_A+","+temp.current_B+") , "+temp.distance);
			}
		}
	}
	
	int solve(int goal){
		Vertex current = graphList[0][goal];
		solution = new ArrayList<String>();
		//for(int i=0; i< graphList[0][goal].distance; i++){
		while(!(current.current_A == 0 && current.current_B ==0)){
			if(current.parent == null){
				break;
			}
			if(current.parent.current_A == current.current_A){
				//eB or fB
				if(current.current_B == 0){
					solution.add("empty B");
				}
				else{
					solution.add("fill B");
				}
			}
			else if(current.parent.current_B == current.current_B){
				//eA or fA
				if(current.current_A == 0){
					solution.add("empty A");
				}
				else{
					solution.add("fill A");
				}
			}
			else{
				//pAB or pBA occured
				if(current.parent.current_A > current.current_A ){
					solution.add("pour A into B");
				}
				else{
					solution.add("pour B into A");
				}
			}
			current = current.parent;	
		}
		if(current.current_A == 0 && current.current_B ==0){
			System.out.println("Solution found :");
			print_solution();
			System.out.println("Success "+graphList[0][N].distance);
			return 1;
		}
		else{
			System.out.println("Solution does not exist");
			return 0;
		}
	}
	
	void print_solution(){
		int size = solution.size();
		for(int i=size; i>0; i--){
			System.out.println(solution.get(i-1));
		}
	}
	
}
