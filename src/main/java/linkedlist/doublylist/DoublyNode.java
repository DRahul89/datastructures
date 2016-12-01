package main.java.linkedlist.doublylist;

public class DoublyNode<E> {

	private E data;

	private DoublyNode<E> next;

	private DoublyNode<E> previous;

	public DoublyNode(final E data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public DoublyNode<E> getNext() {
		return next;
	}

	public void setNext(DoublyNode<E> next) {
		this.next = next;
	}

	public DoublyNode<E> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyNode<E> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "DoublyNode [data=" + data + ", next=" + next + ", previous=" + previous + "]";
	}

}
