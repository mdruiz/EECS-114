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
 * Filename : Jug.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */

public class Jug {
	int Ca, Cb, N, fA, fB, eA, eB, pAB, pBA;

	public Jug(int Ca, int Cb, int N, int fA, int fB, int eA, int eB, int pAB, int pBA){
		this.Ca = Ca;	// capacity of Jug A
		this.Cb = Cb;	// capacity of Jug B
		this.N = N;		// goal in B
		this.fA = fA;	// cost to fill A
		this.fB = fB;	// cost to fill B
		this.eA = eA;	// cost to empty A
		this.eB = eB;	// cost to empty B
		this.pAB = pAB;	// cost to pour A to B
		this.pBA = pBA;	// cost to pour B to A
	}
	
	public int solve(){
		if(Ca<=0 || Ca>Cb || Cb<N || Cb>1000){
			System.out.println("Input is invalid");
			return -1;
		}
		Graph graph = new Graph(Ca,Cb,N,fA,fB,eA,eB,pAB,pBA);
		//Checking if I should use BFS or Dijkstra's
		if(fA==1 && fB==1 && eA==1 && eB==1 && pAB==1 && pBA==1){
			graph.set_levels();		//BFS
		}
		else{
			graph.set_levels2();	//Dijkstra's
		}
		int solution = graph.solve(N);
		return solution;
	}
	
	public int test(){
		if(Ca<=0 || Ca>Cb || Cb<N || Cb>1000){
			System.out.println("Input is invalid");
			return -1;
		}
		Graph test = new Graph(Ca,Cb,N,fA,fB,eA,eB,pAB,pBA);
		
		//Checking if I should use BFS or Dijkstra's
		if(fA==1 && fB==1 && eA==1 && eB==1 && pAB==1 && pBA==1){
			test.set_levels();		//BFS
		}
		else{
			test.set_levels2();	//Dijkstra's
		}
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Printing out graph's adjacency list");
		System.out.println("-------------------------------------------------------------");
		test.display();
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Printing all possible nodes and number of steps from start");
		System.out.println("-------------------------------------------------------------");
		test.display_levels();
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Printing out result");
		System.out.println("-------------------------------------------------------------");
		int solution = test.solve(N);
		return solution;
	}
	
	public static void main(String[] args){
		Jug die_hard;
		
		//Attempting to use wrong values
		die_hard = new Jug(5, 4, 4, 1, 2, 3, 4, 5, 6);
		die_hard.solve();
		
		System.out.println("-------------------------------------------------------------");
		
		//Solving using BFS
		die_hard = new Jug(3,5,4,1,1,1,1,1,1);
		die_hard.solve();
		
		System.out.println("-------------------------------------------------------------");
		
		//Solving using Dijkstra's
		die_hard = new Jug(3,5,4,1,2,3,4,5,6);
		die_hard.solve();
		
		//Use to .test() instead of .solve() to test everything. 
		//(Prints AdjacencyList , all Vertices distances from source, and finds solution)
		
		//die_hard.test();
	}
	
}
