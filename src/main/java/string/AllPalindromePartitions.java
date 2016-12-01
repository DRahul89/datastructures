package main.java.string;

/**
 * 
 * A class for printing all palindrome of a string
 *
 */
public class AllPalindromePartitions {

	public static void printPalindrome(final String input) {
		if (null != input) {
			for (int i = 0; i < input.length(); i++) {
				printIntermediatePalindrome(input, i, i);
				printIntermediatePalindrome(input, i, i + 1);
			}
		}
	}

	private static void printIntermediatePalindrome(String input, int left,
			int right) {
		while (left >= 0 && right < input.length()) {
			if (input.charAt(left) == input.charAt(right)) {
				System.out.println("palindrome exists  "
						+ input.substring(left, right+1));
			}
			left--;
			right++;
		}

	}

	public static void main(String[] args) {
		printPalindrome("geeks");
	}
}
