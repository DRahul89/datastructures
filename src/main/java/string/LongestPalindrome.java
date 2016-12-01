package main.java.string;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindromeString("1234"));
		System.out.println(longestPalindromeString("12321"));
		System.out.println(longestPalindromeString("9912321456"));
		System.out.println(longestPalindromeString("9912333321456"));
		System.out.println(longestPalindromeString("12145445499"));
		System.out.println(longestPalindromeString("1223213"));
		System.out.println(longestPalindromeString("abb"));
	}

	private static String intermediatePalindrome(final String input, int left,
			int right) {
		while (left >= 0 && right < input.length()
				&& input.charAt(left) == input.charAt(right)) {
			left--;
			right++;
		}
		return input.substring(left + 1, right);
	}

	// O n^2
	private static char[] longestPalindromeString(final String input) {
		if (null == input)
			return null;
		String longest = input.substring(0, 1);
		for (int i = 0; i < input.length() - 1; i++) {
			String palindrome = intermediatePalindrome(input, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			palindrome = intermediatePalindrome(input, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest.toCharArray();
	}
}
