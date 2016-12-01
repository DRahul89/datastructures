package main.java.graph.mst.kruskal;

import java.util.Arrays;

import main.java.graph.disjointsetalgo.Edge;
import main.java.graph.disjointsetalgo.Graph;
import main.java.graph.disjointsetalgo.Subset;
import main.java.graph.disjointsetalgo.UnionFindAlgoByRank;

/**
 * algo 1.sort all edges by their weight 2.take min werigth and check if its not
 * finding cycle by disjoint set then include otherwise discard 3.repeat this
 * till vertex -1
 * 
 * @author rdixi7
 *
 */
public class KruskalMST {

	public static void printMST(final Edge[] edges) {
		for (Edge edge : edges) {
			if(null != edge)
			System.out.println(
					edge.getSource() + "-->" + edge.getDestination() + "  included with weight " + edge.getWeight());
		}
	}

	public static void kruskalMst(final Graph graph) {
		Subset[] subsets = new Subset[graph.getVertex()];
		Arrays.sort(graph.getEdges());
		Edge[] edges = new Edge[graph.getEdges().length];
		int me = 0;// for mst edges
		int e = 0; // for next edge
		for (int v = 0; v < graph.getVertex(); v++) {
			subsets[v] = new Subset();
		}
		UnionFindAlgoByRank.createSet(subsets);
		while (e < graph.getVertex()) {
			Edge nextEdge = graph.getEdges()[e++];
			int x = UnionFindAlgoByRank.find(subsets, nextEdge.getDestination());
			int y = UnionFindAlgoByRank.find(subsets, nextEdge.getSource());
			if (x != y) {
				edges[me++] = nextEdge;
				UnionFindAlgoByRank.union(subsets, nextEdge.getDestination(), nextEdge.getSource());
			}
		}

		printMST(edges);
	}
	
	public static void main(String[] args) {
		 int V = 4;  // Number of vertices in graph
	        int E = 5;  // Number of edges in graph
	        Graph graph = new Graph(V, E);
	 
	        // add edge 0-1
	        graph.getEdges()[0].setSource(0);
	        graph.getEdges()[0].setDestination(1);
	        graph.getEdges()[0].setWeight(10);
	 
	        // add edge 0-2
	        graph.getEdges()[1].setSource(0);
	        graph.getEdges()[1].setDestination(2);
	        graph.getEdges()[1].setWeight(6);
	 
	        // add edge 0-3
	        graph.getEdges()[2].setSource(0);
	        graph.getEdges()[2].setDestination(3);
	        graph.getEdges()[2].setWeight(5);
	 
	        // add edge 1-3
	        graph.getEdges()[3].setSource(1);
	        graph.getEdges()[3].setDestination(3);
	        graph.getEdges()[3].setWeight(15);
	 
	        // add edge 2-3
	        graph.getEdges()[4].setSource(2);
	        graph.getEdges()[4].setDestination(3);
	        graph.getEdges()[4].setWeight(4);
	 
		kruskalMst(graph);
	}
}
