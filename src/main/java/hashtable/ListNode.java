package main.java.hashtable;

/**
 * 
 * This class is a node class for list
 *
 * @param <E>
 */
public class ListNode<E, V> {

	private E key;

	private V data;

	public ListNode() {

	}

	public ListNode(final E key, final V data) {
		this.key = key;
		this.data = data;
	}

	private ListNode<E, V> nextNode;

	public E getKey() {
		return key;
	}

	public void setKey(E key) {
		this.key = key;
	}

	public V getData() {
		return data;
	}

	public void setData(V data) {
		this.data = data;
	}

	public ListNode<E, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(ListNode<E, V> nextNode) {
		this.nextNode = nextNode;
	}

}
