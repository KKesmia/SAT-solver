package Exacte;
import java.lang.Math;
import java.util.ArrayList;

public class Tree {
	private int v;
	private int heu_v;
	private Tree left,right;
	private ArrayList<Tree> path = new ArrayList<Tree>();
	
	public int getHeu_v() {
		return heu_v;
	}

	public void setHeu_v(int heu_v) {
		this.heu_v = heu_v;
	}

	public Tree(int v) {
		super();
		this.v = v;
		this.heu_v = Math.abs(v);
	}
	
	public Tree(int v,ArrayList<Tree> path) {
		super();
		this.v = v;
		this.heu_v = Math.abs(v);
		this.path = path;
	}
	
	static void pathology(Tree t, int var_num){
		ArrayList<Tree> pile = new ArrayList<Tree>();
		ArrayList<Tree> path = new ArrayList<Tree>();
		Tree travers = t;
		pile.add(t);
		path.add(travers);
		t.setPath(path);
		pile.add(travers.getRight());
		travers = t.getLeft();
		while (!pile.isEmpty()){
			try {
				path.add(travers);
				travers.setPath(new ArrayList<Tree>(path));
				if(travers.getRight() != null ) pile.add(travers.getRight());
				if(travers.getLeft() != null) travers = travers.getLeft();
			
				if(path.size() == var_num + 1) {
					travers = pile.get(pile.size() - 1);
					pile.remove(pile.size() - 1);
					while(true) {
						if(path.get(path.size() -1).getV() > 0 ) path.remove(path.size()-1);
						else break;
					}
				path.remove(path.size()-1);
				}
			}catch (Exception e){
				;
			}
		}
	}
	public ArrayList<Tree> getPath() {
		return path;
	}

	public void setPath(ArrayList<Tree> path) {
		this.path = path;
	}

	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public Tree getLeft() {
		return left;
	}
	public void setLeft(Tree left) {
		this.left = left;
	}
	public Tree getRight() {
		return right;
	}
	public void setRight(Tree right) {
		this.right = right;
	}
	
	
	

}
