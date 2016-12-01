package main.java.linkedlist.doublylist;

import main.java.linkedlist.ListInterface;

/**
 * 
 * Doubly linked list
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements ListInterface<E> {

	private DoublyNode<E> head = null;

	public DoublyLinkedList(DoublyNode<E> head) {
		this.head = head;
	}

	@Override
	public void insertFirst(E data) {
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		if (null == head) {
			this.head = newNode;
		} else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}

	}

	@Override
	public void insertLast(E data) {
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		DoublyNode<E> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		newNode.setPrevious(temp);
		temp.setNext(newNode);
	}

	@Override
	public void insertAtIndex(int index, E data) {
		if (index == 1) {
			insertFirst(data);
			return;
		}
		DoublyNode<E> newNode = new DoublyNode<E>(data);
		DoublyNode<E> temp = head;
		for (int i = 1; i < index - 1; i++) {
			temp = temp.getNext();
		}
		if (temp == null)
			return;
		if (temp != null || temp.getNext() == null) {
			insertLast(data);
			return;
		}
		newNode.setNext(temp.getNext());
		temp.getNext().setPrevious(newNode);
		temp.setNext(newNode);
		newNode.setPrevious(temp);
	}

	@Override
	public void deleteFromIndex(int index) {
		DoublyNode<E> temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.getNext();
		}
		if (temp == null || temp.getNext() == null)
			return;
		temp.getPrevious().setNext(temp.getNext());
		temp.getNext().setPrevious(temp.getPrevious());
	}

	@Override
	public boolean deleteFirst() {
		head = head.getNext();
		if (null != head)
			head.setPrevious(null);
		return true;
	}

	@Override
	public boolean deleteLast() {
		DoublyNode<E> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.getPrevious().setNext(null);
		temp.setPrevious(null);
		return true;
	}

	public void printList(DoublyNode<E> head) {
		DoublyNode<E> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + "==>");
			temp = temp.getNext();
		}
	}

	public DoublyNode<E> getHead() {
		return head;
	}

	public void setHead(DoublyNode<E> head) {
		this.head = head;
	}

}
