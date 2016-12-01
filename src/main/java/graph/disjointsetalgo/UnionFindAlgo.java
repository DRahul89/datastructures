package main.java.graph.disjointsetalgo;

/**
 * 
 * find cycle in an undirected graph
 *
 */
public class UnionFindAlgo {

	private static void createSet(int[] parent) {
		for (int i = 0; i < parent.length; i++)
			parent[i] = -1;
	}

	/**
	 * a utility function to create the subset of the element i
	 * 
	 * @param parent
	 * @param element
	 * @return
	 */
	private static int find(int[] parent, int element) {
		if (parent[element] == -1)
			return element;
		return find(parent, parent[element]);
	}

	private static void union(int[] parent, int first, int second) {
		int firstSet = find(parent, first);
		int secondSet = find(parent, second);
		parent[firstSet] = secondSet;
	}

	public static boolean isCycle(final Graph graph) {
		int[] parent = new int[graph.getVertex()];
		createSet(parent);
		for (int i = 0; i < graph.getEdgeCount(); i++) {
			int firsSet = find(parent, graph.getEdges()[i].getSource());
			int secondSet = find(parent, graph.getEdges()[i].getDestination());
			if (firsSet == secondSet)
				return true;
			union(parent, firsSet, secondSet);
		}
		return false;
	}

	public static void main(String[] args) {
		/*
		 * Let us create following graph 0 | \ | \ 1-----2
		 */
		int V = 3, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.getEdges()[0].setSource(0);
		graph.getEdges()[0].setDestination(1);

		graph.getEdges()[1].setSource(1);
		graph.getEdges()[1].setDestination(2);

		 graph.getEdges()[2].setSource(0);
		 graph.getEdges()[2].setDestination(2);

		if (isCycle(graph) == true)
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}

}
