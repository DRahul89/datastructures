package main.java.stack;

/**
 * Consecutive days for which rates were less or equal
 * 
 * @author rdixi7
 *
 */
public class StockSpanProblem {

	public static void calculateSpan(final int[] price) {
		int span[] = new int[price.length];
		span[0] = 1;
		for (int i = 1; i < price.length; i++) {
			span[i] = 1;
			for (int j = i - 1; (j >= 0) && (price[j] < price[i]); j--) {
				span[i] = (i - j) + 1;
			}
		}
		for (int i = 0; i < span.length; i++)
			System.out.println(span[i]);

	}

	public static void calculateSpanbByStack(final int[] price) {
		int span[] = new int[price.length];
		LLStack<Integer> spanStack = new LLStack<Integer>();
		spanStack.push(0);
		span[0] = 1;
		for (int i = 1; i < price.length; i++) {
			System.out.println(i +" "+spanStack);
			while (!spanStack.isEmpty() && price[spanStack.peek()] < price[i])
				spanStack.pop();
			span[i] = spanStack.isEmpty() ? i + 1 : i - spanStack.peek();
			spanStack.push(i);

		}

		for (int i = 0; i < span.length; i++)
			System.out.println(span[i]);

	}

	public static void main(String[] args) {
		int price[] = { 10, 4, 5, 90, 120, 80 };
		calculateSpanbByStack(price);
	}

}
