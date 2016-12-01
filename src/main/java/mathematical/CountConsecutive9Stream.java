package main.java.mathematical;

public class CountConsecutive9Stream {

	public static int consecutiveStreamAddTo9(char[] input) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			int sum = input[i] - '0';
			if (sum  == 9)
				count++;
			for (int j = i + 1; j < input.length; j++) {
				sum = sum + (input[j] - '0');
				if (sum % 9 == 0) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// char[] input={'4','1','8','9'};
		// char[] input = { '9', '9', '9' };
		char[] input = { '1', '8', '0', '9' };
		System.out.println(consecutiveStreamAddTo9(input));
	}
}
