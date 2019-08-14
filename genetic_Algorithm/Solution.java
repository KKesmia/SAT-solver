package genetic_Algorithm;

public class Solution {
	private int[] genes;
	private int fitness;
	
	
	public Solution(int[] genes, int fitness) {
		super();
		this.genes = genes;
		this.fitness = fitness;
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
