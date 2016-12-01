package main.java.bitalgo;

/**
 * Swap two nibbles
 * 
 * @author rahul2065
 *
 */
public class SwapTwoNumbers {

	public static void swapNumbers(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

	public static void main(String[] args) {
		swapNumbers(1, 2);

	}
}
