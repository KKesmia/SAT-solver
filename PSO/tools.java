package PSO;

import java.util.ArrayList;
import Exacte.Reader_Cnf;


public class tools {
	
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
	
	static Solution max(ArrayList<Solution> c) {
		Solution j = c.get(0);
		for(Solution i : c) {
			if(j.getFitness() < i.getFitness() ) {
				j = i;
			}
		}
		return j;
	}
	
	static double sigmf(double c) {
		return 1./(1.+Math.exp(-c));
	}
}
