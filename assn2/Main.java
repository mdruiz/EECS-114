import java.io.File;
import java.io.FileNotFoundException;
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
 * Assignment: Assignment 2
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
		SimpleList<String> newDict = new SimpleList<String>();
		//File Dictionary = new File("words.dict");
		File Dictionary = new File(args[0]);
		int i = 0;
		try{
			Scanner s = new Scanner(Dictionary);
			while(s.hasNext()){
				newDict.insertAtPos(i, s.next());
				i++;
			}
			s.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		@SuppressWarnings("unused")
		//WordLadder test = new WordLadder("style", "slate", newDict);
		WordLadder test = new WordLadder(args[1], args[2], newDict);
		
	}

}
