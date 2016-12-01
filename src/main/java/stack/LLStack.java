package main.java.stack;

public class LLStack<E> {

	private ListNode<E> top;

	public boolean isEmpty() {
		return (null == top);
	}

	public void push(E data) {
		ListNode<E> newNode = new ListNode<E>(data);
		if (null == top) {
			top = newNode;
		} else {
			newNode.setNextNode(top);
			top = newNode;
		}
	}
	public E peek() {
		if (isEmpty()) {

		}
		E data = top.getData();
		return data;
	}

	public E pop() {
		if (isEmpty()) {

		}
		E data = top.getData();
		top = top.getNextNode();
		return data;
	}

	@Override
	public String toString() {
		return "LLStack [top=" + top + "]";
	}

}
