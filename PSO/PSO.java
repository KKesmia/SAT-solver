package PSO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import Exacte.Reader_Cnf;


public class PSO {
	public static int def_popu = 750;
	public static int def_iter = 1000;
	public static double def_c1 = 1;
	public static double def_c2 = 1.5;
	public static double def_w = 1.8;
	
	private Reader_Cnf b;
	private double c1,c2,w;
	private int iterations;
	private int population;
	//private double tar_error;
	
	//Though is not used for our case cause we have discret target not continous
	private ArrayList<Solution> particles;
	private Solution gbest;
	
	private static Random random = new Random();
	
	public PSO(String path) throws IOException {
		super();
		this.c1 = PSO.def_c1;
		this.c2 = PSO.def_c2;
		this.w = PSO.def_w;
		this.b = new Reader_Cnf(path);
		this.iterations = PSO.def_iter;
		this.population = PSO.def_popu;
	}
	
	public PSO(double w, double c1, double c2, int iterations, int population, String path) throws IOException {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.w = w;
		this.b = new Reader_Cnf(path);
		this.iterations = iterations;
		this.population = population;
	}
	
	public PSO(double w, double c1, double c2, int iterations, int population, Reader_Cnf b) throws IOException {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.w = w;
		this.b = b;
		this.iterations = iterations;
		this.population = population;
	}
	
	private ArrayList<Solution> Init_Population(int population){
		ArrayList<Solution> ret = new ArrayList<Solution>();
		ArrayList<int[]> check_dup = new ArrayList<int[]>();
		int c;
		int i = 0;
		int [] temp_Solution = new int[b.getVar_num()]; 
		while(i < population) {
			for(int j = 0; j < b.getVar_num(); j++) {
				c = (random.nextBoolean() ? 1 : 0);
				temp_Solution[j] = -(j+1)*c  + (j+1)*(c == 0 ? 1:0);
			}
			if (!check_dup.contains(temp_Solution)) { check_dup.add(temp_Solution); i++;}
			temp_Solution = new int[b.getVar_num()];
		}
		
		for (int[] t : check_dup) ret.add(new Solution(t,tools.check(t,this.b),0));

		return ret;
	}
	
	private void move() {
		double c; 
		for(Solution particle : particles) {
			if(particle != gbest) {
				c = (this.w * particle.getVelocity()) + (c1*random.nextDouble()) * (particle.getPbest().getFitness() - particle.getFitness()) + 
					(random.nextDouble()*c2) * (this.gbest.getFitness() - particle.getFitness());
				particle.setVelocity(c);
				particle.move(b);
				particle.flip(b);
			}
		}
	}
	
	public String Execution() {
		this.particles = this.Init_Population(this.population);
		int i  = 0;
		while(i != this.iterations) {
			gbest = tools.max(particles);
			if(gbest.getFitness() == b.getClau_num()) break;
			this.move();			
			i++;
		}
		String re;
		//system.out.println(i+"eme :"+gbest.getFitness());
		re = gbest.getFitness() + " ";
		for(int e : gbest.getGenes()) re = re +e +",";
		
		return re;
	}
	

	
	
}
