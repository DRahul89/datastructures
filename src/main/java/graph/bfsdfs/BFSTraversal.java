package main.java.graph.bfsdfs;

import main.java.graph.representation.AdjacencyListGraph;
import main.java.graph.representation.AdjacencyListGraphNode;
import main.java.queue.LLQueue;

public class BFSTraversal {

	public static void bfs(AdjacencyListGraph adjacencyListGraph, char source) {
		boolean[] visited = new boolean[adjacencyListGraph.getVertexCount()];
		LLQueue<Integer> llqueue = new LLQueue<Integer>();
		int sourceIndex = adjacencyListGraph.getGraphVertexIndex(source);
		llqueue.enQueue(sourceIndex);
		visited[sourceIndex] = true;
		while (!llqueue.isEmpty()) {
			int node = llqueue.deQueue();
			System.out.print(adjacencyListGraph.getVertices()[node].getVerticeslabel() + "-->");
			AdjacencyListGraphNode adjacencyListGraphNode = adjacencyListGraph.getVertices()[node].getNextVertices();
			while (null != adjacencyListGraphNode) {
				int index = adjacencyListGraph.getGraphVertexIndex(adjacencyListGraphNode.getVerticeslabel());
				if (!visited[index]) {
					llqueue.enQueue(index);
					visited[index] = true;
				}
				adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
			}
		}

	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(4);
		adjacencyListGraph.addVertex('0');
		adjacencyListGraph.addVertex('1');
		adjacencyListGraph.addVertex('2');
		adjacencyListGraph.addVertex('3');
		adjacencyListGraph.addUniderictionEdge('0', '1');
		adjacencyListGraph.addUniderictionEdge('0', '2');
		adjacencyListGraph.addUniderictionEdge('1', '2');
		adjacencyListGraph.addUniderictionEdge('2', '0');
		adjacencyListGraph.addUniderictionEdge('2', '3');
		adjacencyListGraph.addUniderictionEdge('3', '3');
		bfs(adjacencyListGraph, '2');
	}

}
