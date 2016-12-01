package main.java.graph.bfsdfs;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;
import main.java.stack.LLStack;

/**
 * algo is in dfs traversal if next visited already iun stack then cycle existss
 * 
 * @author rdixi7
 *
 */
public class FindCycleInDirectedGraph {

	public static boolean isCycleExists(final AdjacencyListGraph adjacencyListGraph, final char source,
			final boolean[] visited, final boolean[] elemInStack) {

		LLStack<Integer> llstack = new LLStack<Integer>();
		int sourceIndex = adjacencyListGraph.getGraphVertexIndex(source);
		llstack.push(sourceIndex);
		visited[sourceIndex] = true;
		elemInStack[sourceIndex] = true;
		while (!llstack.isEmpty()) {
			int node = llstack.peek();
			int adjVertex = getAdjNonVisitedVertex(adjacencyListGraph, visited, node, elemInStack);
			if (adjVertex == -2) {
				System.out.println("cycle exisits");
				return true;
			} else if (adjVertex == -1) {
				llstack.pop();
				elemInStack[node] = false;
			} else {
				llstack.push(adjVertex);
				visited[adjVertex] = true;
				elemInStack[adjVertex] = true;
			}
		}
		return false;
	}

	private static int getAdjNonVisitedVertex(final AdjacencyListGraph adjacencyListGraph, boolean[] visited, int node,
			boolean[] elemInStack) {
		AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[node].getNextVertices();
		while (null != adjacencyListGraphNode) {
			int index = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
			if (elemInStack[index]) {
				return -2;
			}
			if (!visited[index]) {
				return index;
			}
			adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
		}
		return -1;
	}

	public static boolean cycleExists(final AdjacencyListGraph adjacencyListGraph) {
		boolean[] visited = new boolean[adjacencyListGraph.getVertexCount()];
		boolean[] elemInStack = new boolean[adjacencyListGraph.getVertexCount()];
		for (int i = 0; i < adjacencyListGraph.getVertexCount(); i++) {
			if (isCycleExists(adjacencyListGraph, adjacencyListGraph.getVertices()[i].getVerticeslabel(), visited,
					elemInStack)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(4);
		adjacencyListGraph.addVertex('0');
		adjacencyListGraph.addVertex('1');
		adjacencyListGraph.addVertex('2');
		adjacencyListGraph.addVertex('3');
		// adjacencyListGraph.addUniderictionEdge('0', '1');
		// adjacencyListGraph.addUniderictionEdge('2', '0');
		// adjacencyListGraph.addUniderictionEdge('1', '2');
		// adjacencyListGraph.addUniderictionEdge('2', '3');
		// adjacencyListGraph.addUniderictionEdge('3', '3');
		adjacencyListGraph.addUniderictionEdge('0', '1');
		adjacencyListGraph.addUniderictionEdge('2', '3');
		adjacencyListGraph.addUniderictionEdge('2', '1');
		adjacencyListGraph.addUniderictionEdge('3', '2');
		System.out.println(cycleExists(adjacencyListGraph));
	}

}
