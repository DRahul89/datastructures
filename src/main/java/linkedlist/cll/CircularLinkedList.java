package main.java.linkedlist.cll;

import main.java.linkedlist.ListInterface;
import main.java.linkedlist.ListNode;

/**
 * 
 * Implementation of circular linked list in this list head would always point
 * towards the tail
 *
 * @param <E>
 */
public class CircularLinkedList<E> implements ListInterface<E> {

	private ListNode<E> head;

	@Override
	public void insertFirst(final E data) {
		ListNode<E> newNode = new ListNode<>(data);
		if (head == null) {
			this.head = newNode;
			newNode.setNextNode(head);
		} else {
			ListNode<E> temp = head;
			while (temp.getNextNode() != head) {
				temp = temp.getNextNode();
			}
			newNode.setNextNode(head);
			temp.setNextNode(newNode);
			head = newNode;
		}
	}

	@Override
	public void insertLast(final E data) {
		ListNode<E> newNode = new ListNode<>(data);
		if (head == null) {
			this.head = newNode;
			newNode.setNextNode(head);
		} else {
			ListNode<E> temp = head;
			while (temp.getNextNode() != head) {
				temp = temp.getNextNode();
			}
			newNode.setNextNode(head);
			temp.setNextNode(newNode);
		}
	}

	@Override
	public void insertAtIndex(int index, E data) {
		ListNode<E> newNode = new ListNode<>(data);
		if (index == 0)
			insertFirst(data);
		ListNode<E> temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.getNextNode();
		}
		if (temp == null)
			return;
		newNode.setNextNode(temp.getNextNode());
		temp.setNextNode(newNode);

	}

	@Override
	public void deleteFromIndex(int index) {
		if (index == 0)
			deleteFirst();
		ListNode<E> temp = head;
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
		if (head == null) {
			isDeleted = false;
		} else if (head == head.getNextNode()) {
			head = null;
		} else {
			ListNode<E> temp = head;
			while (temp.getNextNode() != head) {
				temp = temp.getNextNode();
			}
			temp.setNextNode(head.getNextNode());
			head = head.getNextNode();
		}
		return isDeleted;
	}

	@Override
	public boolean deleteLast() {
		Boolean isDeleted = Boolean.TRUE;
		if (head == null) {
			isDeleted = false;
		} else if (head == head.getNextNode()) {
			head = null;
		} else {
			ListNode<E> temp = head;
			while (temp.getNextNode().getNextNode() != head) {
				temp = temp.getNextNode();
			}
			temp.getNextNode().setNextNode(null);
			temp.setNextNode(head);
		}
		return isDeleted;
	}

	@Override
	public String toString() {
		return "CircularLinkedList [head=" + head + "]";
	}

}
