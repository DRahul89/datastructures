package main.java.stack;

public class MaxParanthesisLength {

	public static int findMax(int first, int second) {
		return first > second ? first : second;
	}

	public static int maxParanthesis(final String paranth) {
		int result = 0;
		LLStack<Integer> index = new LLStack<Integer>();
		index.push(-1);
		for (int i = 0; i < paranth.length(); i++) {
			char paranthesis = paranth.charAt(i);
			if (paranthesis == '(') {
				index.push(i);
			} else {
				index.pop();
				if (!index.isEmpty()) {
					result = findMax(result, i - index.peek());
				} else {
					index.push(i);
				}

			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		System.out.println(maxParanthesis("()(()))))"));
	}
}
