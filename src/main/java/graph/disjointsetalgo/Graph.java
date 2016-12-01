package main.java.graph.disjointsetalgo;

public class Graph {
	// no of vertex or no of edges
	private int vertex;
	private int edgeCount;
	private Edge[] edges;

	public Graph(int vertex, int edge) {
		this.vertex = vertex;
		this.edgeCount = edge;
		edges = new Edge[edge];
		for (int i = 0; i < edge; i++)
			edges[i] = new Edge();
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getEdgeCount() {
		return edgeCount;
	}

	public void setEdgeCount(int edgeCount) {
		this.edgeCount = edgeCount;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public void setEdges(Edge[] edges) {
		this.edges = edges;
	}

}
