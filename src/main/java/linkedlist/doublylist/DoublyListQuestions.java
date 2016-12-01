package main.java.linkedlist.doublylist;

public class DoublyListQuestions<E> {

	public DoublyNode<E> reverseList(DoublyNode<E> head) {
		DoublyNode<E> first = null;
		DoublyNode<E> second = head;
		while (second != null) {
			second.setPrevious(second.getNext());
			second.setNext(first);
			first = second;
			second = second.getPrevious();
		}
		head = first;
		return head;
	}
	
	public DoublyNode<E> copyListWithRandomPointers(final DoublyNode<E> head){
		DoublyNode<E> temp = head;
		while(te)
	}

}
