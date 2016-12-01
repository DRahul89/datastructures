package main.java.linkedlist;

/**
 * 1 method use stach 2 method by recursion
 * 
 * @author rdixi7
 *
 */
public class LinkedListPalindrome {

	public static <E> ListNode<E> checkPalindromeRecursion(ListNode<E> head, ListNode<E> temp) {

		if (head == null)
			return temp;
		temp = checkPalindromeRecursion(head.getNextNode(), temp);
		if (temp == null) {
			System.out.println("Not a palindrome");
			System.exit(0);
		}

		if (head.getData().equals(temp.getData())) {
			return null != temp.getNextNode() ? temp.getNextNode() : temp;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addElemenetToList("A");
		list.addElemenetToList("A");
		list.addElemenetToList("A");
		list.addElemenetToList("B");
		System.out.println(list);
		ListNode<String> temp = checkPalindromeRecursion(list.getHeadNode(), list.getHeadNode());
		if (null != temp) {
			System.out.println("Palindrome List");
		} 
	}

}
