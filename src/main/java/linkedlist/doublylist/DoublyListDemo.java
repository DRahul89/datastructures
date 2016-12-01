package main.java.linkedlist.doublylist;

public class DoublyListDemo {

	public static void main(String[] args) {
		DoublyNode<String> head = new DoublyNode<String>("rahul");
		DoublyLinkedList<String> dl = new DoublyLinkedList<>(head);
		// dl.insertAtIndex(1, "shakti");
		dl.insertLast("rupesh");
		dl.insertAtIndex(3, "shakti");
		// dl.deleteFirst();
		// dl.deleteLast();
		dl.printList(dl.getHead());

		DoublyListQuestions<String> que = new DoublyListQuestions<>();
		dl.setHead(que.reverseList(dl.getHead()));
		System.out.println("----------------------");
		dl.printList(dl.getHead());
	}
}
