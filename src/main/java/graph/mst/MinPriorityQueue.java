package main.java.graph.mst;

public class MinPriorityQueue {

	private int count;

	private int capacity;

	private HeapNode[] heap;

	public MinPriorityQueue(int capacity) {
		this.capacity = capacity;
		this.count = this.capacity - 1;
		this.heap = new HeapNode[capacity];
	}
	
	

}
