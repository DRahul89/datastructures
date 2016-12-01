package main.java.graph.bfsdfs;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;
import main.java.stack.LLStack;

/**
 * Not same as DFS here we push the element when alll its adjacent processed
 * 
 * @author rdixi7
 *
 */
public class TopologicalSorting {

	public static void topologicalSortingUtil(final AdjacencyListGraph adjacencyListGraph, LLStack<Integer> stack,
			final Boolean[] visited, final char source) {
		int sourceIndex = adjacencyListGraph.getGraphVertexIndex(source);
		visited[sourceIndex] = true;
		AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[sourceIndex].getNextVertices();
		while (null != adjacencyListGraphNode) {
			if (!visited[adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel())]) {
				topologicalSortingUtil(adjacencyListGraph, stack, visited, adjacencyListGraphNode.getVerticeslabel());
			}
			adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
		}
		stack.push(sourceIndex);
	}

	public static LLStack<Integer> topologicalSort(final AdjacencyListGraph adjacencyListGraph) {
		LLStack<Integer> stack = new LLStack<Integer>();
		Boolean[] visited = new Boolean[adjacencyListGraph.getVertexCount()];
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
		for (int i = 0; i < adjacencyListGraph.getVertexCount(); i++) {
			if (!visited[i])
				topologicalSortingUtil(adjacencyListGraph, stack, visited,
						adjacencyListGraph.getVertices()[i].getVerticeslabel());
		}
		while (!stack.isEmpty())
			System.out.print(stack.pop() + "--> ");
		return stack;

	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(6);
		adjacencyListGraph.addVertex('0');
		adjacencyListGraph.addVertex('1');
		adjacencyListGraph.addVertex('2');
		adjacencyListGraph.addVertex('3');
		adjacencyListGraph.addVertex('4');
		adjacencyListGraph.addVertex('5');
		adjacencyListGraph.addUniderictionEdge('4', '1');
		adjacencyListGraph.addUniderictionEdge('2', '3');
		adjacencyListGraph.addUniderictionEdge('3', '1');
		adjacencyListGraph.addUniderictionEdge('5', '2');
		adjacencyListGraph.addUniderictionEdge('5', '0');
		adjacencyListGraph.addUniderictionEdge('4', '0');

		System.out.println("");
		topologicalSort(adjacencyListGraph);
	}

}
