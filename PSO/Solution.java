package PSO;

import java.util.Random;
import Exacte.Reader_Cnf;

public class Solution {
	private int[] genes;
	private int fitness;
	private double velocity;
	private Solution pbest;
	private static Random random = new Random();

	public Solution(int[] genes, int fitness, double velocity) {
		super();
		this.genes = genes;
		this.fitness = fitness;
		this.velocity = velocity;
		this.pbest = new Solution(this.genes,this.fitness);
	}
	
	public Solution(int[] genes, int fitness) {
		super();
		this.genes = genes;
		this.fitness = fitness;
	}
	
	void move(Reader_Cnf b){
		int e,i = 0;
		double c =tools.sigmf(this.velocity) ;
		while(i <genes.length){
			e = ((random.nextDouble() < c) ? 1 : -1);
			genes[i] = genes[i] * e;
			i++;
		}
		this.fitness = tools.check(this.genes , b);
		if(tools.check(this.genes , b) > pbest.getFitness()) {
			pbest = new Solution(this.genes,this.fitness);
		}		
	}
	
	void flip(Reader_Cnf b){
		int size = this.genes.length,i = 0,improv = 0;
		do {
			this.genes[i] = this.genes[i]*(-1);
			if(tools.check(this.genes, b) > this.fitness) {
				improv = improv + tools.check(this.genes, b) - this.fitness;
				this.fitness = tools.check(this.genes, b);
			}
			else this.genes[i] = this.genes[i]*(-1);
			i++;
		}while(improv > 0  && i != size );
		
	}
	
	
	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public Solution getPbest() {
		return pbest;
	}

	public void setPbest(Solution pbest) {
		this.pbest = pbest;
	}

	public int[] getGenes() {
		return genes;
	}
	public void setGenes(int[] genes) {
		this.genes = genes;
	}
	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
}
