import java.util.*;

public class GraphL {

	private ArrayList<LinkedList<Integer>> adj;
	private int size; 

	public GraphL (int n) {
		this.adj = new ArrayList<LinkedList<Integer>>(n);
		this.size = n; 
		for (int i = 0; i < size; i++) {
			adj.add(i, new LinkedList<Integer>());
		}
	}

	public void insert_node() {
		LinkedList<Integer> newNode = new LinkedList<Integer>();
		adj.add(newNode);
		size++;
	}

	public void insert_edge(int n1, int n2) {
		if (!adj.get(n1).contains(n2)) {
			adj.get(n1).add(n2);
			adj.get(n2).add(n1);
		}
	}

	public void neighborhood (int n) {
		String ret = new String();
		ret = adj.get(n).toString();
		ret = "Neighborhood of " + n + " : " + ret;
		System.out.println(ret);
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(i + " -> " + adj.get(i).toString());
		}
	}

	public static void main(String[] args) {
		GraphL graph = new GraphL(2);
		graph.insert_node();
		graph.insert_edge(1, 0);
		graph.neighborhood(1);
		graph.print();
	}
}