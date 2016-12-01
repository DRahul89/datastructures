package main.java.linkedlist;

public class LinkedListLoopDetection<E> {

	public void detectAndRemoveLoop(final ListNode<E> head) {
		ListNode<E> slowPtr = head;
		ListNode<E> fastPtr = head;
		while (fastPtr.getNextNode() != null || slowPtr != null) {
			if (slowPtr == fastPtr)
				break;
			slowPtr = slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode().getNextNode();
		}

		System.out.println("Loop Detected At " + slowPtr.getData());
		slowPtr = head;
		while (slowPtr != fastPtr) {
			slowPtr = slowPtr.getNextNode();
			fastPtr = fastPtr.getNextNode();
		}

	}

}
