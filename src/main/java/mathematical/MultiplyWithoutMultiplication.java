package main.java.mathematical;

/**
 * without loop,multiplication and division
 * 
 * @author rahul2065
 *
 */
public class MultiplyWithoutMultiplication {

	public static int multiply(final int first, int second) {

		if (second == 0)
			return 0;
		if (second < 0)
			return -multiply(first, -second);

		return first + multiply(first, second - 1);

	}

	public static void main(String[] args) {
		System.out.println(multiply(3, -4));
	}

}
