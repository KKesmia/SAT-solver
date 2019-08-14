package genetic_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import Exacte.Reader_Cnf;

public class tools {	
	private static Random random = new Random();
	
	static int check(int[] Poss_Solu, Reader_Cnf b) {
		int[][] M = b.getM();
		if (Poss_Solu.length < b.getClau_size()) return 0;
		int decision = 0;
		int count = 0;
		for (int i = 0; i < b.getClau_num(); i++) {
			for (int j = 0; j < b.getClau_size(); j++){
				decision = decision + Poss_Solu[Math.abs(M[i][j]) -1 ]/M[i][j] ;
			}
			if(decision > - b.getClau_size()) count++;
			decision = 0;
		}
		return count;
	}
	
	static void order(ArrayList<Solution> solus) {
	    Collections.sort(solus, new Comparator<Solution>(){
            public int compare(Solution s1, Solution s2) {            	
            	return (s1.getFitness() - s2.getFitness());
           }
	    });
	}
	
	static ArrayList<Solution> Init_Population(int population, Reader_Cnf b){
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
		
		for (int[] t : check_dup) ret.add(new Solution(t,tools.check(t,b)));

		return ret;
	}
	
	static Solution max(ArrayList<Solution> c) {
		Solution j = c.get(0);
		for(Solution i : c) {
			if(j.getFitness() < i.getFitness() ) {
				j = i;
			}
		}
		return j;
	}
	
	static Solution min(ArrayList<Solution> c) {
		Solution j = c.get(0);
		for(Solution i : c) {
			if(j.getFitness() > i.getFitness() ) {
				j = i;
			}
		}
		
		return j;
	}
	
	static boolean exist(ArrayList<Solution> c, Solution s) {
		for(Solution i : c) {
			if(i.getGenes() == s.getGenes()) return true;
		}
		return false;
	}

}
