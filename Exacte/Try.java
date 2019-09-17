package Exacte;

import java.io.IOException;
import java.util.ArrayList;

public class Try {

	public static void main(String[] args) throws IOException {
		long start;
	      	
		// in case of attemoting to figure out the performence according to time.
		// this though reaquires you to download the benchmark files and update the path below.
		// Idealy to test an algorithm according to time we do not use print instructions so feel free to swap em out
		for (int i=1; i<=100; i++) {
			Reader_Cnf_Exc Book = new Reader_Cnf_Exc("PATH UPDATE HERE"+i+".cnf");
			
			// u can display the tree of solutions by decommenting this instruction
			//Book.traverseInOrder(Book.getT());
			
			Methods met = new Methods(Book.getT(), Book.getVar_num(), Book.getClau_size(), 
			Book.getM(), Book.getClau_num());
			start = System.currentTimeMillis(); 
			
			//Depth first
			//System.out.println(met.SRP());
			
			//Heuristic
			//System.out.println(met.RA());
			
			//Breadth first
			//System.out.println(met.RL());
			
			System.out.print((System.currentTimeMillis() - start )+",");
		}
	}

}
