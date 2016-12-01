package main.java.graph.disjointsetalgo;

/**
 * By rank and path compression
 * 
 * @author rahul2065
 *
 */
public class UnionFindAlgoByRank {

	public static void createSet(Subset[] subsets) {
		for (int i = 0; i < subsets.length; i++) {
			subsets[i].setParent(i);
			subsets[i].setRank(0);
		}
	}

	public static int find(Subset[] subsets, int element) {
		if (subsets[element].getParent() == element) {
			return element;
		}
		subsets[element].setParent(find(subsets, subsets[element].getParent()));
		return subsets[element].getParent();
	}

	public static void union(Subset[] subsets, int first, int second) {
		int firstSet = find(subsets, first);
		int secondSet = find(subsets, second);
		if (subsets[firstSet].getRank() < subsets[secondSet].getRank()) {
			subsets[firstSet].setParent(secondSet);
		} else if (subsets[firstSet].getRank() > subsets[secondSet].getRank()) {
			subsets[secondSet].setParent(firstSet);
		} else if (subsets[firstSet].getRank() == subsets[secondSet].getRank()) {
			subsets[firstSet].setParent(secondSet);
			subsets[secondSet].setRank(subsets[secondSet].getRank() + 1);
		}
	}

	public static boolean isCycle(final Graph graph) {
		Subset[] parent = new Subset[graph.getVertex()];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = new Subset();
		}
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
