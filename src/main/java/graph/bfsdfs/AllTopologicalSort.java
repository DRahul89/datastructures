package main.java.graph.bfsdfs;

import java.util.LinkedList;
import java.util.List;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;

/**
 * class to print all topological sort algo basd on backtracking
 * 
 * @author rdixi7
 *
 */
public class AllTopologicalSort {

	public static int[] calculateIndegree(final AdjacencyListGraph adjacencyListGraph) {
		int[] indegre = new int[adjacencyListGraph.getVertexCount()];
		for (int v = 0; v < indegre.length; v++) {
			AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[v].getNextVertices();
			while (null != adjacencyListGraphNode) {
				indegre[adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel())]++;
				adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
			}
		}
		return indegre;
	}

	public static void allTopologicalSort(final AdjacencyListGraph adjacencyListGraph, boolean[] visited,
			int[] indegre,List<Integer> sort) {

		boolean isAllVisited = false;
		for (int v = 0; v < adjacencyListGraph.getVertexCount(); v++) {
			if (indegre[v] == 0 && visited[v] == false) {
				sort.add(v);
				visited[v] = true;
				AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[v].getNextVertices();
				while (null != adjacencyListGraphNode) {
					int neigIndex = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
					--indegre[neigIndex];
					adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
				}
				allTopologicalSort(adjacencyListGraph, visited,indegre,sort);

				visited[v] = false;
				sort.remove(sort.size() - 1);
				adjacencyListGraphNode = adjacencyListGraph.getVertices()[v].getNextVertices();
				while (null != adjacencyListGraphNode) {
					int neigIndex = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
					++indegre[neigIndex];
					adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
				}
				isAllVisited = true;
			}
		}
		if (!isAllVisited) {
			for (Integer sortIndex : sort)
				System.out.print(sortIndex + "-->");
				System.out.println();

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
		adjacencyListGraph.addUniderictionEdge('4', '1');
		adjacencyListGraph.addUniderictionEdge('2', '3');
		adjacencyListGraph.addUniderictionEdge('3', '1');
		adjacencyListGraph.addUniderictionEdge('5', '2');
		adjacencyListGraph.addUniderictionEdge('5', '0');
		adjacencyListGraph.addUniderictionEdge('4', '0');
		boolean[] visited = new boolean[6];
		int[] indegre = calculateIndegree(adjacencyListGraph);
		List<Integer> sort = new LinkedList<>();
		allTopologicalSort(adjacencyListGraph, visited, indegre,sort);

	}

}
