import java.util.ArrayList;

public class Graph {

	private ArrayList<ArrayList<Integer>> matrix;
	private int size; 

	public Graph (int n) {
		this.matrix = new ArrayList<ArrayList<Integer>>(n);
		this.size = n; 
		for (int i = 0; i < size; i++) {
			matrix.add(i, new ArrayList<Integer>(n));
			for (int j = 0; j < size; j++) {
				matrix.get(i).add(j, 0);
			}
		}
	}

	public void insert_node() {
		for (int i = 0; i < size; i++) {
			matrix.get(i).add(0);
		}
		ArrayList<Integer> newNode = new ArrayList<Integer>(size++);
		for (int i = 0; i < size; i++) {
			newNode.add(i, 0);
		}
		matrix.add(newNode);
		
	}

	public void insert_edge(int n1, int n2) {
		if(!matrix.get(n1).isEmpty() && !matrix.get(n2).isEmpty()) {
			matrix.get(n2).set(n1, 1);
			matrix.get(n1).set(n2, 1);
		} else {
			matrix.get(n2).add(n1, 1);
			matrix.get(n1).add(n2, 1);
		}
	}

	public void neighborhood (int n) {
		String ret = new String();
		for (int i = 0; i < size; i++) {
			if (matrix.get(n).get(i) == 1) {
				ret+= i + " ";
			}
		}
		ret = "Neighborhood of " + n + " : " + ret;
		System.out.println(ret);
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(2);
		graph.insert_node();
		graph.insert_edge(1, 0);
		graph.insert_edge(0, 1);
		graph.insert_edge(1, 2);
		graph.neighborhood(1);
		graph.print();
	}

}
