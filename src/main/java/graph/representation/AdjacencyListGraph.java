package main.java.graph.representation;

public class AdjacencyListGraph {

	private AdjacencyListGraphNode[] vertices;

	private int count;

	private int vertexCount;

	public AdjacencyListGraph(final int vertexCount) {
		this.vertices = new AdjacencyListGraphNode[vertexCount];
		this.vertexCount = vertexCount;
		this.count = 0;
	}

	public void addVertex(final char vertexLabel) {
		if (count > vertexCount) {
			throw new RuntimeException("Graph is complete ");
		}
		vertices[count++] = new AdjacencyListGraphNode(vertexLabel);
	}

	public void addEdge(final char source, final char destination) {
		int firstVertexIndex = getGraphVertexIndex(source);
		int secondVertexIndex = getGraphVertexIndex(destination);
		if (firstVertexIndex == -1 || secondVertexIndex == -1) {
			System.out.println("No edge possible between these two vertex");
			return;
		}
		addEdgeNode(destination, firstVertexIndex);
		addEdgeNode(source, secondVertexIndex);
	}

	private void addEdgeNode(final char destination, int firstVertexIndex) {
		AdjacencyListGraphNode adjacencyListGraphNode = vertices[firstVertexIndex].getNextVertices();
		if (null != adjacencyListGraphNode) {
			while (null != adjacencyListGraphNode.getNextVertices()) {
				adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
			}
			adjacencyListGraphNode.setNextVertices(new AdjacencyListGraphNode(destination));
		} else {
			vertices[firstVertexIndex].setNextVertices(new AdjacencyListGraphNode(destination));
		}
	}
	
	private void addEdgeNodeWithWeight(final char destination, int firstVertexIndex,int weight) {
		AdjacencyListGraphNode adjacencyListGraphNode = vertices[firstVertexIndex].getNextVertices();
		if (null != adjacencyListGraphNode) {
			while (null != adjacencyListGraphNode.getNextVertices()) {
				adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
			}
			adjacencyListGraphNode.setNextVertices(new AdjacencyListGraphNode(destination,weight));
		} else {
			vertices[firstVertexIndex].setNextVertices(new AdjacencyListGraphNode(destination,weight));
		}
	}

	public void addUniderictionEdge(final char source, final char destination) {
		int firstVertexIndex = getGraphVertexIndex(source);
		int secondVertexIndex = getGraphVertexIndex(destination);
		if (firstVertexIndex == -1 || secondVertexIndex == -1) {
			System.out.println("No edge possible between these two vertex");
			return;
		}
		addEdgeNode(destination, firstVertexIndex);
	}

	public void addUniderictionEdge(final char source, final char destination, final int weight) {
		int firstVertexIndex = getGraphVertexIndex(source);
		int secondVertexIndex = getGraphVertexIndex(destination);
		if (firstVertexIndex == -1 || secondVertexIndex == -1) {
			System.out.println("No edge possible between these two vertex");
			return;
		}
		addEdgeNodeWithWeight(destination, firstVertexIndex,weight);
	}

	public void printGraph() {
		for (int index = 0; index < vertices.length; index++) {
			System.out.print(vertices[index].getVerticeslabel() + " ->");
			AdjacencyListGraphNode adjacencyListGraphNode = vertices[index].getNextVertices();
			while (null != adjacencyListGraphNode) {
				System.out.print(adjacencyListGraphNode.getVerticeslabel() + " ->");
				adjacencyListGraphNode = adjacencyListGraphNode.getNextVertices();
			}
			System.out.println("");
		}
	}

	public int getGraphVertexIndex(final char vertexLabel) {
		for (int index = 0; index < vertices.length; index++) {
			if (vertices[index].getVerticeslabel() == vertexLabel) {
				return index;
			}
		}
		return -1;
	}

	public AdjacencyListGraphNode[] getVertices() {
		return vertices;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public static void main(String[] args) {
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(5);
		adjacencyListGraph.addVertex('0');
		adjacencyListGraph.addVertex('1');
		adjacencyListGraph.addVertex('2');
		adjacencyListGraph.addVertex('3');
		adjacencyListGraph.addVertex('4');
		adjacencyListGraph.addEdge('0', '1');
		adjacencyListGraph.addEdge('0', '4');
		adjacencyListGraph.addEdge('1', '3');
		adjacencyListGraph.addEdge('1', '4');
		adjacencyListGraph.addEdge('1', '2');
		adjacencyListGraph.addEdge('4', '3');
		adjacencyListGraph.addEdge('2', '3');
		adjacencyListGraph.printGraph();
	}

}
