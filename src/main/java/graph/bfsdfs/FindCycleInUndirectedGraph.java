package main.java.graph.bfsdfs;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;
import main.java.stack.LLStack;

/**
 * same as for DAG but here we hav to chaeck that adjacent visited is not
 * itsparent bcz of acyclick
 * 
 * @author rdixi7
 *
 */
public class FindCycleInUndirectedGraph {

	public static boolean dfsTraversalByStack(final AdjacencyListGraph adjacencyListGraph, final char source,
			final boolean[] visited) {
		LLStack<Integer> llstack = new LLStack<Integer>();
		LLStack<Integer> parentStack = new LLStack<Integer>();
		int sourceIndex = adjacencyListGraph.getGraphVertexIndex(source);
		llstack.push(sourceIndex);
		visited[sourceIndex] = true;
		while (!llstack.isEmpty()) {
			int node = llstack.peek();
			parentStack.push(node);
			int adjVertex = getAdjNonVisitedVertex(adjacencyListGraph, visited, node, parentStack.peek());
			if (adjVertex == -2) {
				return true;
			} else if (adjVertex == -1) {
				llstack.pop();
				parentStack.pop();
			} else {
				llstack.push(adjVertex);
				visited[adjVertex] = true;
			}

		}
		return false;

	}

	private static int getAdjNonVisitedVertex(final AdjacencyListGraph adjacencyListGraph, boolean[] visited, int node,
			int parent) {
		AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[node].getNextVertices();
		while (null != adjacencyListGraphNode) {
			int index = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
			if (visited[index] && index != parent) {
				return -2;
			} else if (!visited[index]) {
				return index;
			}
			adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
		}
		return -1;
	}

	public static boolean isCycleExists(final AdjacencyListGraph adjacencyListGraph) {
		boolean[] visited = new boolean[adjacencyListGraph.getVertexCount()];
		for (int i = 0; i < adjacencyListGraph.getVertexCount(); i++) {
			if (!visited[i]) {
				if (dfsTraversalByStack(adjacencyListGraph, adjacencyListGraph.getVertices()[i].getVerticeslabel(),
						visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(5);
		adjacencyListGraph.addVertex('0');
		adjacencyListGraph.addVertex('1');
		adjacencyListGraph.addVertex('2');
		adjacencyListGraph.addVertex('3');
		adjacencyListGraph.addVertex('4');
		adjacencyListGraph.addEdge('0', '1');
		adjacencyListGraph.addEdge('0', '3');
		adjacencyListGraph.addEdge('3', '4');
		adjacencyListGraph.addEdge('1', '2');
		System.out.println(isCycleExists(adjacencyListGraph));
	}

}
