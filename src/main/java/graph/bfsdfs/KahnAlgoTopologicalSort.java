package main.java.graph.bfsdfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;

/**
 * Algo is 1.calculate in degree for all vertices and initiate cout of visited
 * node to 0 2.in queue all 0 indegree nodes to queue 3.remove one node from
 * queue (i). increse visited count to one (ii).decrease indegree of all
 * neighbour node node to 1 (iii) if any one become zero add to queue
 * 
 * 
 * now repeat step 3 till queue become empty if visited node is equal to no of
 * nodes then topological sort possible
 * 
 * @author rdixi7
 *
 */
public class KahnAlgoTopologicalSort {

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

	public static void topologicalsort(final AdjacencyListGraph adjacencyListGraph) {
		int[] indegre = calculateIndegree(adjacencyListGraph);
		List<Integer> sort = new LinkedList<>();
		Queue<Integer> vertexQueue = new LinkedList<>();
		for (int i = 0; i < indegre.length; i++) {
			if (indegre[i] == 0)
				vertexQueue.offer(i);
		}
		int visitedCount = 0;
		while (!vertexQueue.isEmpty()) {
			int vertex = vertexQueue.poll();
			sort.add(vertex);
			visitedCount++;
			AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[vertex].getNextVertices();
			while (null != adjacencyListGraphNode) {
				int neigIndex = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
				if ((--indegre[neigIndex]) == 0) {
					vertexQueue.offer(neigIndex);
				}

				adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
			}
		}
		if (visitedCount != adjacencyListGraph.getVertexCount()) {
			System.out.println("Cycle exists in graph");
		} else {

			for (Integer sortIndex : sort)
				System.out.print(sortIndex + "-->");

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
		topologicalsort(adjacencyListGraph);

	}
}
