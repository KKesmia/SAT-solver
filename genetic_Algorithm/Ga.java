package genetic_Algorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import Exacte.Reader_Cnf;

public class Ga {
	
	public static int def_popu = 1000;
	public static int def_gene = 4000;
	public static double def_cr = 0.8;
	public static double def_mt = 0.04;
	
	private int population;
	private int generation;
	private double cross_rate;
	private double muta_rate;
	private ArrayList<Solution> solus;
	private ArrayList<Solution> parents;
	private ArrayList<Solution> children;
	private Solution best;
	private Reader_Cnf book;
	private Random rand = new Random();
	
	public Ga(int population, int generation, double cross_rate, double muta_rate, Reader_Cnf book) {
		super();
		this.population = population;
		this.generation = generation;
		this.cross_rate = cross_rate;
		this.muta_rate = muta_rate;
		this.book = book;
	}
	
	public Ga(String path) throws IOException {
		super();
		this.population = Ga.def_popu;
		this.generation = Ga.def_gene;
		this.cross_rate = Ga.def_cr;
		this.muta_rate = Ga.def_mt;
		this.book = new Reader_Cnf(path);
	}
	
	public Ga(int population, int generation, double cross_rate, double muta_rate, String path) throws IOException {
		super();
		this.population = population;
		this.generation = generation;
		this.cross_rate = cross_rate;
		this.muta_rate = muta_rate;
		this.book = new Reader_Cnf(path);
	}
	
	private void Initialize() throws IOException {
		solus = tools.Init_Population(population, book);
		best = tools.max(solus);
		parents = new ArrayList<Solution>();
		children = new ArrayList<Solution>();
		tools.order(solus);
	}
	
	private void Selection() {
		int par_num = (int) Math.round(population * cross_rate);
		for(int i = population - par_num; i < population; i++ ) {
			parents.add(solus.get(i));
		}
	}
	
	private void cross_over() {
		int x,chlds_num = (int) Math.round(population * cross_rate);
		Solution par_1, par_2;
		int[] chld_1 = null, chld_2 = null;
		ArrayList<int[]> check_dup = new ArrayList<int[]>();
		while(chlds_num != 0) {
			x = rand.nextInt(parents.size() / 2);
			par_1 = parents.get(x);
			par_2 = parents.get(x*2);
			x = par_1.getGenes().length;
			chld_1 = new int[x];
			chld_2 = new int[x];
			for (int i = 0; i < par_1.getGenes().length; i++) {
				x = (rand.nextBoolean() ? 1 : 0);
				chld_1[i] = x*par_1.getGenes()[i] + (x == 0 ? 1:0)*par_2.getGenes()[i];
				chld_2[i] = (x == 0 ? 1:0)*par_1.getGenes()[i] + x*par_2.getGenes()[i];
			}
			if( (chld_1 != par_1.getGenes() && chld_2 != par_1.getGenes() ) 
					&& (!check_dup.contains(chld_1) && !check_dup.contains(chld_1)) ) {
				if(chlds_num  == 1 ) {
					if(tools.check(chld_1, book) >= tools.check(chld_2, book) ) check_dup.add(chld_1);
					if(tools.check(chld_1, book) <= tools.check(chld_2, book) ) check_dup.add(chld_2);
					chlds_num--;
				}else {
					check_dup.add(chld_1);
					check_dup.add(chld_2);
					chlds_num = chlds_num - 2;
				}
			}
		}
		for (int[] i :check_dup) children.add(new Solution(i,tools.check(i, book)));
	} 
	
	private void mutation() {
		double x;
		for(Solution i : solus) {
			x = rand.nextDouble() / 10;
			if(muta_rate <= x) {
				x = rand.nextInt(i.getGenes().length-1);
				i.getGenes()[(int) x] = i.getGenes()[(int) x] * -1;
			}	
		}
	}
	
	private void offspring() {
		for (Solution i : children) {
			if(! tools.exist(solus, i)){
				solus.remove(solus.indexOf(tools.min(solus)));
				solus.add(i);
			}
		}
	}	
	
	public String Execution() throws IOException{
		String reponse;
		int i = 0;
		this.Initialize();
		
		//System.out.println(solus.size());
		//System.out.println(best.getFitness());
		//System.out.println(tools.min(solus).getFitness());

		while(i != this.generation) {
			this.Selection();			

			this.cross_over();	

			this.offspring();
			
			this.mutation();

			tools.order(solus);
			
			parents = new ArrayList<Solution>();
			children = new ArrayList<Solution>();
			best = (tools.max(solus).getFitness() > best.getFitness() ? tools.max(solus) : best );
			if(best.getFitness() == book.getClau_num()) break;
			i++;
		}
		
		reponse = best.getFitness() +" ";
		for(int j : best.getGenes()) reponse = reponse + j +",";
		//System.out.println(reponse);
		return reponse;
	}
	

}
