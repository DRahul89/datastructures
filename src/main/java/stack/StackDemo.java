package main.java.stack;

public class StackDemo {

	public static void arrayStachDemo() {
		ArrayListStack<String> stringStack = new ArrayListStack<String>(10);
		for (int i = 0; i < 10; i++) {
			stringStack.push("abc" + i);
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("popped array stack element " + stringStack.pop());
		}
	}

	public static void insertAtLast(final LLStack<String> stack, final String value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		String temp = stack.pop();
		insertAtLast(stack, value);
		stack.push(temp);
	}

	public static void reverseList(final LLStack<String> stack) {
		if (stack.isEmpty()) {
			return;
		}
		String temp = stack.pop();
		reverseList(stack);
		insertAtLast(stack, temp);
	}

	public static void llStachDemo() {
		LLStack<String> llStack = new LLStack<String>();
		for (int i = 0; i < 10; i++) {
			System.out.println("abc" + i);
			llStack.push("abc" + i);
		}
		reverseList(llStack);
		for (int i = 0; i < 10; i++) {
			System.out.println("popped list stack element " + llStack.pop());
		}
	}

	

	public static void main(String[] args) {
		// llStachDemo();
		// arrayStachDemo();
	}

}
