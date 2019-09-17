package PSO;

import java.io.IOException;

import genetic_Algorithm.Ga;


public class Try {
	public static void main(String[] args) throws IOException {
		
		double[] c1 = {0.25, 0.5, .75, 1 , 1.25, 1.5, 1.75, 2, 2.25, 2.5};
		double[] c2 = {0.25, 0.5, .75, 1 , 1.25, 1.5, 1.75, 2, 2.25, 2.5};
		double[] w = {0.2, 0.4, .6, .8 , 1, 1.2, 1.4, 1.6, 1.8, 2};
		
		int[] var_popu = { 250, 500 , 750, 1000};
		int[] var_gene = {1000, 2000, 3000 , 4000, 5000}; // generations
		PSO start;
		
		// default values w = 1, c1 = 1.25, c2 = 1.25, generations = 1000, population = 200
		
		// This is parameters settings and we process with the benchmark with 100 instance
		// repeated executions of a set of parameters , for each loop we vary one of them and fix the rest to the default values 
		
		/*		
		System.out.println("c1");
		for(double c :c1) {
			start = new PSO(1,c, 1.25, 1000, 200, "C:\\Users\\Moi\\Desktop\\test_SAT\\100\\uf100-01.cnf");
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());

		}
		
		
		System.out.println("c2");
		for(double c :c2) {
			start = new PSO(1, 1.25, c, 1000, 200, "C:\\Users\\Moi\\Desktop\\test_SAT\\100\\uf100-01.cnf");
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
		}
		
		System.out.println("w");
		for(double c :w) {
			start = new PSO(c, 1.25, 1.25, 1000, 200, "C:\\Users\\Moi\\Desktop\\test_SAT\\100\\uf100-01.cnf");
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
		}
		
		
		System.out.println("population/generations");
		for(int c :var_popu) {
			for(int x :var_gene) {
				start = new PSO(1, 1.25, 1.25, x, c, "C:\\Users\\Moi\\Desktop\\test_SAT\\100\\uf100-01.cnf");
				System.out.println(c+"--"+x+"--"+start.Execution());
				System.out.println(c+"--"+x+"--"+start.Execution());
				System.out.println(c+"--"+x+"--"+start.Execution());
			}
		}*/
		
		// testing according to time using instance of 150 and going through all the 100 files
		long timestart;
		String c;
		int i = 1;
		System.out.println("all files");
		while ( i<= 100) {			
			start = new PSO("C:\\Users\\Moi\\Desktop\\test_SAT\\uf150-0"+i+".cnf");
			stt = System.currentTimeMillis(); 
			c = start.Execution();
			System.out.print((System.currentTimeMillis() - timestart )+",");
			i++;
		}
		
	}
}




