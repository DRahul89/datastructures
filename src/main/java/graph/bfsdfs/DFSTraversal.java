package main.java.graph.bfsdfs;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;
import main.java.stack.LLStack;

//only for connected graph for all reachable vertices
public class DFSTraversal {

	public static void dfsTraversalRecursive(boolean[] visited, AdjacencyListGraph adjacencyListGraph, char source) {
		int sourceIndex = adjacencyListGraph.getGraphVertexIndex(source);
		visited[sourceIndex] = true;
		System.out.print(source + "-->");
		AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[sourceIndex].getNextVertices();
		while (null != adjacencyListGraphNode) {
			int index = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
			if (!visited[index]) {
				dfsTraversalRecursive(visited, adjacencyListGraph, adjacencyListGraphNode.getVerticeslabel());

			}
			adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
		}

	}

	public static void dfsTraversalByStack(final AdjacencyListGraph adjacencyListGraph, final char source) {
		boolean[] visited = new boolean[adjacencyListGraph.getVertexCount()];
		LLStack<Integer> llstack = new LLStack<Integer>();
		int sourceIndex = adjacencyListGraph.getGraphVertexIndex(source);
		llstack.push(sourceIndex);
		System.out.print(source + "-->");
		visited[sourceIndex] = true;
		while (!llstack.isEmpty()) {
			int node = llstack.peek();
			int adjVertex = getAdjNonVisitedVertex(adjacencyListGraph, visited, node);
			if (adjVertex == -1) {
				llstack.pop();
			} else {
				llstack.push(adjVertex);
				visited[adjVertex] = true;
			}
		}

	}

	private static int getAdjNonVisitedVertex(final AdjacencyListGraph adjacencyListGraph, boolean[] visited,
			int node) {
		AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[node].getNextVertices();
		while (null != adjacencyListGraphNode) {
			int index = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
			if (!visited[index]) {
				System.out.print(adjacencyListGraphNode.getVerticeslabel() + "-->");
				return index;
			}
			adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
		}
		return -1;
	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(8);
		boolean[] visited = new boolean[8];
		adjacencyListGraph.addVertex('a');
		adjacencyListGraph.addVertex('b');
		adjacencyListGraph.addVertex('c');
		adjacencyListGraph.addVertex('d');
		adjacencyListGraph.addVertex('e');
		adjacencyListGraph.addVertex('f');
		adjacencyListGraph.addVertex('g');
		adjacencyListGraph.addVertex('h');
		adjacencyListGraph.addEdge('a', 'b');
		adjacencyListGraph.addEdge('b', 'c');
		adjacencyListGraph.addEdge('b', 'h');
		adjacencyListGraph.addEdge('c', 'd');
		adjacencyListGraph.addEdge('c', 'e');
		adjacencyListGraph.addEdge('e', 'f');
		adjacencyListGraph.addEdge('e', 'g');
		adjacencyListGraph.addEdge('e', 'h');
		dfsTraversalRecursive(visited, adjacencyListGraph, 'a');
		System.out.println("");
		dfsTraversalByStack(adjacencyListGraph, 'a');
		System.out.println("");
		BFSTraversal.bfs(adjacencyListGraph, 'a');
	}

}
