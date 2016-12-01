package main.java.stack;

public class SortStackRecursive {
	
	public static void insertAtLast(final LLStack<Integer> stack, final int value) {
		if (stack.isEmpty()) {
			stack.push(value);
			return;
		}
		int temp = stack.pop();
		insertAtLast(stack, value);
		stack.push(temp);
	}

	public static void reverseList(final LLStack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		reverseList(stack);
		insertAtLast(stack, temp);
	}
	
	public static void sortList(final LLStack<Integer> stack, int max) {
		if (stack.isEmpty())
			return;
		int temp = stack.pop();
		if (temp > max) {
			insertAtLast(stack, temp);
			sortList(stack, temp);
		} else {
			sortList(stack, max);
			stack.push(temp);
		}

	}

	public static void sortList(final LLStack<Integer> stack) {
		if (!stack.isEmpty()) {
			sortList(stack, -10);
			reverseList(stack);
			System.out.println(stack.pop());
			sortList(stack);
		}

	}
	
	public static void main(String[] args) {
		LLStack<Integer> llStack = new LLStack<Integer>();
		llStack.push(-3);
		llStack.push(14);
		llStack.push(18);
		llStack.push(-5);
		llStack.push(30);
		sortList(llStack);
	}

}
