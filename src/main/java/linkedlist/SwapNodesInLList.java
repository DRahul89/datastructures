package main.java.linkedlist;

/**
 * Algo is four cases 1)-any one of key belongs to head 2)-any one of them
 * belongs to tail 3)-they are adjacent or not 4)-any one of them present or not
 * 
 * @author rdixi7
 *
 */
public class SwapNodesInLList {

	public <E> void swapNodes(final E firstkey, final E secondKey, ListNode<E> head) {
		ListNode<E> prevFirst = null;
		ListNode<E> currentFirst = head;
		// find previous node and current link
		while (currentFirst != null) {
			if (currentFirst.getData().equals(firstkey))
				break;
			prevFirst = currentFirst;
			currentFirst = currentFirst.getNextNode();
		}

		ListNode<E> prevSecond = null;
		ListNode<E> currentSecond = head;
		// find previous node and current link
		while (currentSecond != null) {
			if (currentSecond.getData().equals(secondKey))
				break;
			prevSecond = currentSecond;
			currentSecond = currentSecond.getNextNode();
		}

		if (currentFirst == null || currentSecond == null)
			return;

		// head cases for first
		if (prevFirst != null) {
			prevFirst.setNextNode(currentSecond);
		} else {
			head = currentSecond;
		}

		// head cases for second
		if (prevSecond != null) {
			prevSecond.setNextNode(currentFirst);
		} else {
			head = currentFirst;
		}

		ListNode<E> temp = currentFirst.getNextNode();
		currentFirst.setNextNode(currentSecond.getNextNode());
		currentSecond.setNextNode(temp);

	}

}
