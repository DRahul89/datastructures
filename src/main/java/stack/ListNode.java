package main.java.stack;

public class ListNode<E> {

	private E data;

	private ListNode<E> nextNode;

	public ListNode(final E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public ListNode<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(ListNode<E> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", nextNode=" + nextNode + "]";
	}
	

}
