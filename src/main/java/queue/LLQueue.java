package main.java.queue;

public class LLQueue<E> {

	private ListNode<E> front;

	private ListNode<E> rear;

	public LLQueue() {

	}

	public Boolean isEmpty() {
		return (front == null);
	}

	public void enQueue(final E data) {
		ListNode<E> newNode = new ListNode<E>(data);
		if (rear == null) {
			rear = newNode;
			front = rear;
		} else {
			rear.setNextNode(newNode);
			rear = newNode;
		}
	}

	public E peek() {
		return front != null ? front.getData() : null;
	}

	public E deQueue() {
		E data;
		if (front == null) {
			throw new RuntimeException("queue if empty");
		} else {
			data = front.getData();
			front = front.getNextNode();
			if (front == null)
				rear = null;
		}
		return data;
	}

}
