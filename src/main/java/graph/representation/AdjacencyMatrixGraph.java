package main.java.graph.representation;

public class AdjacencyMatrixGraph {

	private int[][] vertices;

	private int vertexCount;

	public AdjacencyMatrixGraph(final int vertexCount) {
		this.vertexCount = vertexCount;
		this.vertices = new int[vertexCount][vertexCount];
	}

	public void addEdge(final int source, final int destination,int weight) {
		if ((source <= -1 || source >= vertexCount)
				|| (destination <= -1 || destination >= vertexCount)) {
			System.out.println("No edge possible between these two vertex");
			return;
		}
		vertices[source][destination] = weight;
	}

	public void removeEdge(final int source, final int destination) {
		if ((source <= -1 || source >= vertexCount)
				|| (destination <= -1 || destination >= vertexCount)) {
			System.out.println("No edge possible between these two vertex");
			return;
		}
		vertices[source][destination] = 0;
	}

	public void printGraph() {
		for (int index = 0; index < vertices.length; index++) {
			for (int col = 0; col < vertices.length; col++) {
				System.out.println(vertices[index][col] + " ->");
			}
		}
	}

	public int[][] getVertices() {
		return vertices;
	}

	public void setVertices(int[][] vertices) {
		this.vertices = vertices;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}
	
	

}
