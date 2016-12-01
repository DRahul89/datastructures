package main.java.linkedlist;

public class ReverseList {

	public static <E> ListNode<E> reverseList(ListNode<E> head) {
		ListNode<E> previous = null;
		ListNode<E> current = head;
		ListNode<E> next = null;
		while (current != null) {
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
		}
		head = previous;
		return head;

	}

	public static <E> ListNode<E> reverseListInGroupOfK(ListNode<E> head, int k) {
		ListNode<E> previous = null;
		ListNode<E> current = head;
		ListNode<E> next = null;
		int count = 0;
		while (count < k && current != null) {
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
			count++;
		}
		if (next != null)
			head.setNextNode(reverseListInGroupOfK(next, k));
		return previous;

	}

	public static <E> ListNode<E> reverseListInGroupOfKAlternative(ListNode<E> head, int k) {
		ListNode<E> previous = null;
		ListNode<E> current = head;
		ListNode<E> next = null;
		int count = 0;
		while (count < k && current != null) {
			next = current.getNextNode();
			current.setNextNode(previous);
			previous = current;
			current = next;
			count++;
		}
		if (head != null)
			head.setNextNode(current);
		count = 0;
		while (count < k - 1 && current != null) {
			current = current.getNextNode();
			count++;
		}
		if (current != null)
			current.setNextNode(reverseListInGroupOfK(current.getNextNode(), k));
		return previous;

	}

}
