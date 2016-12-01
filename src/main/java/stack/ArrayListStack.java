package main.java.stack;

import java.util.Arrays;

public class ArrayListStack<E> {
	private int capacity;
	private int top;
	private E[] data;

	@SuppressWarnings("unchecked")
	public ArrayListStack(final int capacity) {
		this.top = -1;
		this.capacity = capacity;
		data = (E[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top + 1 == capacity);
	}

	public void push(E value) {
		if (isFull()) {
			System.out.println("stack is full");
		}
		data[++top] = value;

	}

	public E pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
		}
		
		return data[top--];

	}

	@Override
	public String toString() {
		return "ArrayListStack [capacity=" + capacity + ", top=" + top
				+ ", data=" + Arrays.toString(data) + "]";
	}

}
