package main.java.mathematical;

public class Replace0With5 {

	public static int replace0With5(int input) {
		if (input == 0)
			return 0;
		int digit = input % 10;
		if (digit == 0)
			digit = 5;

		return replace0With5(input / 10) * 10 + digit;

	}

	public static int replace0With5Iterative(int input) {
		int count = 0;
		int result = input;
		while (input  != 0) {
			int digit = input % 10;
			if (digit == 0) {
				result = result + 5 * pow(1, count);
			}
			input = input / 10;
			count++;
		}

		return result;

	}

	private static int pow(int input, int count) {
		if (count == 0)
			return 1;
		for (int i = 0; i < count; i++) {
			input = input * 10;
		}
		return input;
	}

	public static void main(String[] args) {
		System.out.println(replace0With5Iterative(1059999));
	}

}
