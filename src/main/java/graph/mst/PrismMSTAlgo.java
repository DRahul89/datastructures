package main.java.graph.mst;

import main.java.graph.representation.AdjacencyMatrixGraph;

public class PrismMSTAlgo {

	// A utility function to print the constructed MST stored in
	// parent[]
	public static void printMST(int parent[], int n, int graph[][]) {
		System.out.println("Edge   Weight");
		for (int i = 1; i < n; i++)
			System.out.println(parent[i] + " - " + i + "    "
					+ graph[i][parent[i]]);
	}

	private static int minKeyIndex(int[] keys, boolean[] mstkeys) {
		int minIndex = 0;
		int minVal =Integer.MAX_VALUE;
		for (int i = 1; i < keys.length; i++) {
			if (keys[i] < minVal && mstkeys[i] == false) {
				minIndex = i;
				minVal = keys[i];
			}
		}
		return minIndex;
	}

	public static void minimumSpanningTree(
			AdjacencyMatrixGraph adjacencyMatrixGraph) {

		int[] keys = new int[adjacencyMatrixGraph.getVertexCount()];
		int[] parent = new int[adjacencyMatrixGraph.getVertexCount()];
		boolean[] mstKeys = new boolean[adjacencyMatrixGraph.getVertexCount()];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = Integer.MAX_VALUE;
		}
		keys[0] = 0;
		parent[0] = -1;
		for (int v = 0; v < adjacencyMatrixGraph.getVertexCount() - 1; v++) {
			int minKey = minKeyIndex(keys, mstKeys);
			mstKeys[minKey] = true;
			for (int i = 0; i < adjacencyMatrixGraph.getVertexCount(); i++) {
				if (adjacencyMatrixGraph.getVertices()[minKey][i] != 0
						&& adjacencyMatrixGraph.getVertices()[minKey][i] < keys[i]
						&& !mstKeys[i]) {
					keys[i] = adjacencyMatrixGraph.getVertices()[minKey][i];
					parent[i] = minKey;
				}
			}
		}
		printMST(parent, adjacencyMatrixGraph.getVertexCount(),
				adjacencyMatrixGraph.getVertices());
	}
	
	public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
		
		AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(5);
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
        adjacencyMatrixGraph.setVertices(graph);
        // Print the solution
        minimumSpanningTree(adjacencyMatrixGraph);
    }

}
