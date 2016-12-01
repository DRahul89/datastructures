package main.java.stack;

public class SortStackOptimize {

	public static void insertSorted(final LLStack<Integer> stack, int value) {
		if (stack.isEmpty() || stack.peek() < value) {
			stack.push(value);
		} else {
			int temp = stack.pop();
			insertSorted(stack, value);
			stack.push(temp);
		}
	}

	public static void sortList(final LLStack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sortList(stack);
			insertSorted(stack, temp);
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
		while (!llStack.isEmpty()) {
			System.out.println(llStack.pop());
		}
	}

}
