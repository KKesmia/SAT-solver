package Exacte;

import java.util.ArrayList;

import java.lang.Math;

public class Methods {
	private Tree T;
	private int var_num;
	private int c_size;
	private int c_num;
	private int[][] M;
	
	public Methods(Tree t, int var_num, int c_size, int[][] m, int c_num) {
		super();
		T = t;
		this.var_num = var_num;
		this.c_size = c_size;
		M = m;
		this.c_num = c_num;
	}
	
	private int Lcheck(ArrayList<Tree> Poss_Solu) {
		if (Poss_Solu.size() < c_size) return 0;
		int decision = 0;
		int count = 0;
		for (int i = 0; i < c_num; i++) {
			for (int j = 0; j < c_size; j++){
				try {
					decision = decision + Poss_Solu.get(Math.abs(M[i][j])).getV()/M[i][j] ;
				}catch (Exception e) {decision = - c_size;}
			}
			if(decision > - c_size) count++;
			decision = 0;
		}
		
		return count;
	}
	
	ArrayList<Integer> RL() {
		int i=0;
		Tree travers;
		ArrayList<Tree> pile_1 = new ArrayList<Tree>();
		pile_1.add(T);
		while(!pile_1.isEmpty()){
			ArrayList<Tree> pile_2 = new ArrayList<Tree>();
			for(i=0; i<pile_1.size(); i++) {
				travers = pile_1.get(i);
				if(Lcheck(travers.getPath()) == c_num){
					ArrayList<Integer> c = new ArrayList<Integer>();
					for(Tree e : travers.getPath()) c.add(e.getV());
					return c;
				}
				if(travers.getLeft() != null ) pile_2.add(travers.getLeft());
				if(travers.getRight() != null ) pile_2.add(travers.getRight());
			}
			if(pile_2.size() > 0) pile_1 = new ArrayList<Tree>(pile_2);
		}
		return null;
	}
	
	private int Pcheck(ArrayList<Integer> Poss_Solu) {
		if (Poss_Solu.size() < c_size) return 0;
		int decision = 0;
		int count = 0;
		for (int i = 0; i < c_num; i++) {
			for (int j = 0; j < c_size; j++){
				try {
					decision = decision + Poss_Solu.get(Math.abs(M[i][j]))/M[i][j] ;
				}catch (Exception e) {;}
			}
			if(decision > - c_size) count++;
			decision = 0;
		}
		
		return count;
	}
	
	ArrayList<Integer> SRP (){
		int d = 0;
		ArrayList<Integer> c = new ArrayList<Integer>();
		Tree travers = T;
		ArrayList<Tree> pile = new ArrayList<Tree>();
		pile.add(T);
		c.add(travers.getV());
		while (!pile.isEmpty()){
			if(travers != T) c.add(travers.getV());
			if(travers.getRight() != null ) pile.add(travers.getRight());			
			if(c.size() == var_num + 1){
				d = Pcheck(c);
				if (d == c_num){
					return c;
				}else { 
					
					travers = pile.get(pile.size() - 1);
					pile.remove(pile.size() - 1);
					while(true) {
						if(c.get(c.size()-1) > 0 ) c.remove(c.size()-1);
						else break;
					}
					c.remove(c.size()-1);
				}
			}else {
				travers = travers.getLeft();
			}	
		}
		return null;
	}
	
	private int check(ArrayList<Integer> Poss_Solu) {
		if (Poss_Solu.size() < c_size) return 0;
		int decision = 0;
		int count = 0;
		for (int i = 0; i < c_num; i++) {
			for (int j = 0; j < c_size; j++){
				try {
					decision = decision + Poss_Solu.get(Math.abs(M[i][j]))/M[i][j] ;
				}catch (Exception e) {decision = - c_size;}			}
			if(decision > - c_size) count++;
			decision = 0;
		}
		return count;
	}
	
	int ccheck(int[] Poss_Solu) {
		if (Poss_Solu.length < c_size) return 0;
		int decision = 0;
		int count = 0;
		for (int i = 0; i < c_num; i++) {
			for (int j = 0; j < c_size; j++){
				try {
					decision = decision + Poss_Solu[Math.abs(M[i][j]) -1 ]/M[i][j] ;
				}catch (Exception e) {;}
			}
			if(decision > - c_size) count++;
			decision = 0;
		}
		return count;
	}
	
	private int max(ArrayList<Tree> Poss_Solu) {
		int h = Poss_Solu.get(0).getHeu_v();
		int i = 0;
		for (int j=0; j < Poss_Solu.size(); j++){
			if(Poss_Solu.get(j).getHeu_v() > h ) { h = Poss_Solu.get(j).getHeu_v(); i = j;}
		}
		return i;
	}
	
	ArrayList<Integer> RA() {
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Tree> pile = new ArrayList<Tree>();
		Tree left,right,travers = T;
		int d = 0;
		pile.add(T);
		c.add(travers.getV());
		d = check(c);
		while(d != c_num){
			if(travers.getLeft()!= null) {
				left = travers.getLeft();
				c.add(left.getV());
				left.setHeu_v(left.getHeu_v() + check(c));
				pile.add(left);
				c.remove(c.size()-1);
			}
			if(travers.getLeft()!= null) {
				right = travers.getRight();
				c.add(right.getV());
				right.setHeu_v(right.getHeu_v() + check(c));
				pile.add(right);
				c.remove(c.size()-1);
			}
			travers = pile.get(max(pile));
			pile.remove(travers);
			while(c.size() != Math.abs(travers.getV())) {
				c.remove(c.size()-1);
			}
			c.add(travers.getV());
			d = check(c);
		}
		return c;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
