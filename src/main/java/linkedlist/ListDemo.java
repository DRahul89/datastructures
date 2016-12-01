package main.java.linkedlist;

public class ListDemo {

	private static void reverseList(final LinkedList<String> list) {
		ListNode<String> headNode = list.getHeadNode();
		ListNode<String> nextNode = null;
		ListNode<String> tempNode = null;
		while (null != headNode) {
			nextNode = headNode.getNextNode();
			headNode.setNextNode(tempNode);
			tempNode = headNode;
			headNode = nextNode;
		}
		list.setHeadNode(tempNode);
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < 10; i++) {
			list.addElemenetToList("" + i);
		}
		System.out.println(list);
		// reverseList(list);
		ListNode<String> temp = ReverseList.reverseListInGroupOfKAlternative(list.getHeadNode(), 3);
		System.out.println(temp);

	}
}
