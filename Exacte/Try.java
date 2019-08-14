package Exacte;

import java.io.IOException;
import java.util.ArrayList;



public class Try {

	public static void main(String[] args) throws IOException {
		
		
		long start;
	
		for (int i=1; i<=100; i++) {
			Reader_Cnf_Exc Book = new Reader_Cnf_Exc("C:\\Users\\Moi\\Desktop\\test_SAT\\uf20-0"+i+".cnf");
			//Book.traverseInOrder(Book.getT());
			Methods met = new Methods(Book.getT(), Book.getVar_num(), Book.getClau_size(), 
			Book.getM(), Book.getClau_num());
			start = System.currentTimeMillis(); 
			//System.out.println("Depth first :");
			ArrayList<Integer> r = met.SRP();
			System.out.print((System.currentTimeMillis() - start )+",");
		}
	
		
		/*
		System.out.println("Heuristic :");
		System.out.println(met.RA());
		
		
		System.out.println("Breadth first :");
		System.out.println(met.RL());*/
	}

}
