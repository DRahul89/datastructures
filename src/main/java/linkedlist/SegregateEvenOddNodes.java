package main.java.linkedlist;

/**
 * best is create two list one even and one odd then merge
 * 
 * @author rdixi7
 *
 */
public class SegregateEvenOddNodes {

	public static ListNode<Integer> segregateEvenOdd(ListNode<Integer> head) {
		ListNode<Integer> current = head;
		ListNode<Integer> end = current;
		boolean isFirst = true;
		while (end.getNextNode() != null) {
			end = end.getNextNode();
		}
		ListNode<Integer> newEnd = end;
		if ((current.getData() % 2) == 0) {
			head = current;
			isFirst = false;
		} else {
			newEnd.setNextNode(current);
			newEnd = newEnd.getNextNode();
		}
		while (current.getNextNode() != end) {
			if ((current.getNextNode().getData() % 2) == 0) {
				if (isFirst) {
					head = current.getNextNode();
					isFirst = false;
				}
				current = current.getNextNode();
			} else if ((current.getNextNode().getData() % 2) != 0) {
				newEnd.setNextNode(current.getNextNode());
				current.setNextNode(current.getNextNode().getNextNode());
				newEnd = newEnd.getNextNode();
			}
		}
		if ((current.getNextNode().getData() % 2) != 0) {
			newEnd.setNextNode(current.getNextNode());
			current.setNextNode(current.getNextNode().getNextNode());
			newEnd = newEnd.getNextNode();
			newEnd.setNextNode(null);
		}
		return head;

	}

	public static <E> ListNode<E> deleteAlternative(ListNode<E> head) {
		ListNode<E> temp = head;
		while (temp != null && temp.getNextNode()!= null) {
			temp.setNextNode(temp.getNextNode().getNextNode());
			temp = temp.getNextNode();
		}
		return head;
	}
	
	public static <E> ListNode<E> deleteAlternativeRecursive(ListNode<E> head) {
		if(head == null )
			return null;
		head.setNextNode(deleteAlternativeRecursive(head.getNextNode()!= null ? head.getNextNode().getNextNode():null));
		return head;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		/*
		 * list.addElemenetToList(17); list.addElemenetToList(15);
		 * list.addElemenetToList(8); list.addElemenetToList(12);
		 * list.addElemenetToList(10); list.addElemenetToList(5);
		 * list.addElemenetToList(4); list.addElemenetToList(1);
		 * list.addElemenetToList(7); list.addElemenetToList(6);
		 */
		for (int i = 1; i < 6; i++) {
				list.addElemenetToList(i);
		}

		System.out.println(list);
		ListNode<Integer> head = deleteAlternativeRecursive(list.getHeadNode());
		System.out.println(head);

	}

}
