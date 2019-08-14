package Exacte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader_Cnf_Exc {
	private String path;
	private int Var_num;
	private int Clau_num;
	private int Clau_size;
	private int[][] M;
	private Tree t = new Tree(0);
	
	public Reader_Cnf_Exc(String path) throws IOException {
		super();
		this.setPath(path);
		String st; 
		String[] temp;
		File file = new File(path); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		while ((st = br.readLine()) != null){
			 temp = st.split(" ");
			 if (temp.length == 8) Clau_size = Integer.parseInt(temp[temp.length - 1]);
			 if (temp.length == 5 && temp[0].equalsIgnoreCase("p")) {
				 this.Clau_num = Integer.parseInt(temp[temp.length - 1]);
				 this.Var_num = Integer.parseInt(temp[temp.length - 3]);
				 this.M= new int[Clau_num][Clau_size];
				 break;
			 }
		}
		if ((st = br.readLine()) != null) {
			temp = st.split(" ");
			for(int j=0; j<Clau_size; j++) {
				this.M[0][j] = Integer.parseInt(temp[j+1]);
			}
		}
		
		for(int i=1; i<Clau_num ; i++){
			if ((st = br.readLine()) != null) {
				temp = st.split(" ");
				for(int j=0; j<Clau_size; j++) {
					this.M[i][j] = Integer.parseInt(temp[j]);
				}
			}
		}
		br.close();
		Construire(this.t,1,Var_num);
		Tree.pathology(t,Var_num);
	}
			
	
	private void Construire(Tree root, int value, int limit) {
		if (value <= limit){
			root.setLeft(new Tree(-1*value));
			Construire(root.getLeft(),value+1,limit);
			root.setRight(new Tree(value));
			Construire(root.getRight(),value+1,limit);
		}
	}
	
	void traverseInOrder(Tree node) {
	    if (node != null) {
	    	System.out.println(node.getPath().size()+" " + node.getV());
	    	traverseInOrder(node.getLeft());
	    	traverseInOrder(node.getRight());
	    }
	}
	
	public String getPath() {
		return path;
	}

	public int getVar_num() {
		return Var_num;
	}


	public void setVar_num(int var_num) {
		Var_num = var_num;
	}


	public int getClau_num() {
		return Clau_num;
	}


	public void setClau_num(int clau_num) {
		Clau_num = clau_num;
	}


	public int getClau_size() {
		return Clau_size;
	}


	public void setClau_size(int clau_size) {
		Clau_size = clau_size;
	}


	public int[][] getM() {
		return M;
	}


	public void setM(int[][] m) {
		M = m;
	}


	public void setPath(String path) {
		this.path = path;
	}

	public Tree getT() {
		return t;
	}

	public void setT(Tree t) {
		this.t = t;
	}
}
