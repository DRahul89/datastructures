package main.java.linkedlist;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
