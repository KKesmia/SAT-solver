package genetic_Algorithm;

import java.io.IOException;

public class Try {
	public static void main(String[] args) throws IOException {
		
		Ga start;
		int i =1;
		double[] var_cross = {0.1, 0.2, .3, .4 , .5, .6, .7, .8, .9, 1};
		double[] var_muta = {0.01, 0.02, 0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.1};
		
		int[] var_popu = { 250, 500 , 750, 1000};
		int[] var_gene = {1000, 2000, 4000, 6000 , 8000, 10000};
		// default values generations = 250, population = 100, var_cross = 0.5, var_muta = 0.1
		/*
		System.out.println("cross");
		for(double c :var_cross) {
			start = new Ga(100 , 250 ,c ,0.1,"C:\\Users\\Moi\\Desktop\\test_SAT\\uf75-01.cnf");
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());

		}
		
		
		System.out.println("muta");
		for(double c :var_muta) {
			start = new Ga(100 ,250 ,0.5 , c,"C:\\Users\\Moi\\Desktop\\test_SAT\\125\\uf125-01.cnf");
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
			System.out.println(c+"--"+start.Execution());
		}
		*/
		/*
		System.out.println("popu/gene");
		for(int c :var_popu) {
			for(int x :var_gene) {
				start = new Ga(c ,x ,0.5 ,0.1,"C:\\Users\\Moi\\Desktop\\test_SAT\\uf150-01.cnf");
				System.out.println(c+"--"+x+"--"+start.Execution());
				System.out.println(c+"--"+x+"--"+start.Execution());
				System.out.println(c+"--"+x+"--"+start.Execution());
			}
		}
		*/
		long timestart;
		String c;
		
		System.out.println("all files");
		while ( i<= 100) {			
			start = new Ga("C:\\Users\\Moi\\Desktop\\test_SAT\\uf150-0"+i+".cnf");
			stt = System.currentTimeMillis(); 
			c = start.Execution();
			System.out.print((System.currentTimeMillis() - timestart )+",");
			i++;
		}
		
		
		
	}
}
