package main.java.linkedlist;

public class LinkedList<E> implements ListInterface<E> {

	private ListNode<E> headNode;

	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	public void addElemenetToList(E data) {
		ListNode<E> newNode = new ListNode<E>(data);
		if (null == headNode) {
			headNode = newNode;
		} else {
			newNode.setNextNode(headNode);
			headNode = newNode;
		}
	}

	@Override
	public void insertFirst(E data) {
		ListNode<E> newNode = new ListNode<E>(data);
		if (null == headNode) {
			headNode = newNode;
		} else {
			newNode.setNextNode(headNode);
			headNode = newNode;
		}

	}

	@Override
	public void insertLast(E data) {
		ListNode<E> newNode = new ListNode<E>(data);
		if (null == headNode) {
			headNode = newNode;
		} else {
			ListNode<E> temp = headNode;
			while (temp.getNextNode() != null)
				temp = temp.getNextNode();
			temp.setNextNode(newNode);
		}

	}

	@Override
	public void insertAtIndex(int index, E data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFromIndex(int index) {
		if (index == 0)
			deleteFirst();
		ListNode<E> temp = headNode;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.getNextNode();
		}
		if (temp == null || temp.getNextNode() == null)
			return;
		temp.setNextNode(temp.getNextNode().getNextNode());

	}

	@Override
	public boolean deleteFirst() {
		Boolean isDeleted = Boolean.TRUE;
		if (headNode == null) {
			isDeleted = false;
		} else {
			ListNode<E> temp = headNode;
			headNode = headNode.getNextNode();
			temp.setNextNode(null);
		}
		return isDeleted;
	}

	@Override
	public boolean deleteLast() {
		Boolean isDeleted = Boolean.TRUE;
		if (headNode == null) {
			isDeleted = false;
		} else {
			ListNode<E> temp = headNode;
			while (temp.getNextNode().getNextNode() != null) {
				temp = temp.getNextNode();
			}
			temp.getNextNode().setNextNode(null);
		}
		return isDeleted;
	}

	public ListNode<E> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(ListNode<E> headNode) {
		this.headNode = headNode;
	}

	@Override
	public String toString() {
		return "LinkedList [headNode=" + headNode + "]";
	}

	public int listLength(final ListNode<E> head) {
		if (head == null)
			return 0;
		else
			return 1 + listLength(head.getNextNode());
	}

	public boolean searchKey(final ListNode<E> head, final E data) {
		if (head == null)
			return false;
		if (head.getData().equals(data))
			return true;
		else
			return searchKey(head.getNextNode(), data);
	}

}
