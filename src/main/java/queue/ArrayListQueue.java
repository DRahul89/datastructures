package main.java.queue;

public class ArrayListQueue {

	private int capacity;

	private int front;

	private int rear;

	private int[] arrayQueue;

	public ArrayListQueue(final int size) {
		this.capacity = size;
		this.front = -1;
		this.rear = -1;
		arrayQueue = new int[capacity];
	}

	public Boolean isEmpty() {
		return (rear == -1);
	}

	public Boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public int queueSize() {
		return (capacity + rear - front + 1) % capacity;
	}

	public void enQueue(final int data) {
		if (isFull()) {
			// resize another option
			throw new RuntimeException("queuue is full");
		} else {
			System.out.println("element for enqueue :" + data);
			rear = (rear + 1) % capacity;
			arrayQueue[rear] = data;
		}
	}

	public int deQueue() {
		int data = 0;
		if (isEmpty()) {
			throw new RuntimeException("queue is empty");
		} else {
			front = (front + 1) % capacity;
			data = arrayQueue[front];
		}
		return data;
	}

}
