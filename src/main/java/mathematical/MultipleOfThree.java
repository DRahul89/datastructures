package main.java.mathematical;

/**
 * A number is multiple of 3 or not
 * 
 * @author rahul2065
 *
 */
public class MultipleOfThree {

	public static int isMultipleOf3(int n) {
		int odd_count = 0;
		int even_count = 0;

		/*
		 * Make no positive if +n is multiple of 3 then is -n. We are doing this
		 * to avoid stack overflow in recursion
		 */
		if (n < 0)
			n = -n;
		if (n == 0)
			return 1;
		if (n == 1)
			return 0;

		while (n > 0) {
			/*
			 * If odd bit is set then increment odd counter
			 */
			if ((n & 1) == 1)
				odd_count++;
			n = n >> 1;

			/*
			 * If even bit is set then increment even counter
			 */
			if ((n & 1) == 1)
				even_count++;
			n = n >> 1;
		}

		return isMultipleOf3(Math.abs(odd_count - even_count));
	}

	public static int multiplyWith7(int n) {
		return ((n << 3) - n);
	}

	public static int multiplyWith9(int n) {
		return ((n << 3) + n);
	}

	public static void main(String[] args) {
		System.out.println(isMultipleOf3(21));
		System.out.println(multiplyWith7(3));
		System.out.println(multiplyWith9(3));
	}

}
