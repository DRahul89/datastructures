package main.java.linkedlist;

public interface ListInterface<E> {

	public void insertFirst(final E data);

	public void insertLast(final E data);

	public void insertAtIndex(final int index, final E data);

	public void deleteFromIndex(final int index);

	public boolean deleteFirst();

	public boolean deleteLast();

}
