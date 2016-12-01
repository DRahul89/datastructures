package main.java.graph.representation;

public class AdjacencyListGraphNode {

	private char verticeslabel;

	private int weight;

	private AdjacencyListGraphNode nextVertices;

	public AdjacencyListGraphNode(final char verticeslabel) {
		this.verticeslabel = verticeslabel;
		this.nextVertices = null;

	}

	public AdjacencyListGraphNode(final char verticeslabel, final int weight) {
		this.verticeslabel = verticeslabel;
		this.nextVertices = null;
		this.weight = weight;

	}

	public char getVerticeslabel() {
		return verticeslabel;
	}

	public void setVerticeslabel(char verticeslabel) {
		this.verticeslabel = verticeslabel;
	}

	public AdjacencyListGraphNode getNextVertices() {
		return nextVertices;
	}

	public void setNextVertices(AdjacencyListGraphNode nextVertices) {
		this.nextVertices = nextVertices;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
