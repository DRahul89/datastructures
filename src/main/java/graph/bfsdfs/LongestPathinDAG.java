package main.java.graph.bfsdfs;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;
import main.java.stack.LLStack;

public class LongestPathinDAG {

	public static void longestPathProblem(final AdjacencyListGraph adjacencyListGraph, final char source) {
		int[] dist = new int[adjacencyListGraph.getVertexCount()];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MIN_VALUE;
		}
		dist[adjacencyListGraph.getGraphVertexIndex(source)] = 0;
		LLStack<Integer> stack = TopologicalSorting.topologicalSort(adjacencyListGraph);
		while (!stack.isEmpty()) {
			int index = stack.pop();
			if (dist[index] != Integer.MIN_VALUE) {
				AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[index]
						.getNextVertices();
				while (null != adjacencyListGraphNode) {
					if (dist[adjacencyListGraph
							.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel())] < dist[index]
									+ adjacencyListGraphNode.getWeight()) {
						dist[adjacencyListGraph
								.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel())] = dist[index]
										+ adjacencyListGraphNode.getWeight();
					}
					adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
				}
			}
		}

		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(6);
		adjacencyListGraph.addVertex('0');
		adjacencyListGraph.addVertex('1');
		adjacencyListGraph.addVertex('2');
		adjacencyListGraph.addVertex('3');
		adjacencyListGraph.addVertex('4');
		adjacencyListGraph.addVertex('5');
		adjacencyListGraph.addUniderictionEdge('0', '1', 5);
		adjacencyListGraph.addUniderictionEdge('0', '2', 3);
		adjacencyListGraph.addUniderictionEdge('1', '3', 6);
		adjacencyListGraph.addUniderictionEdge('1', '2', 2);
		adjacencyListGraph.addUniderictionEdge('2', '4', 4);
		adjacencyListGraph.addUniderictionEdge('2', '5', 2);
		adjacencyListGraph.addUniderictionEdge('2', '3', 7);
		adjacencyListGraph.addUniderictionEdge('3', '5', 1);
		adjacencyListGraph.addUniderictionEdge('3', '4', -1);
		adjacencyListGraph.addUniderictionEdge('4', '5', -2);
		longestPathProblem(adjacencyListGraph, '1');
	}
}
