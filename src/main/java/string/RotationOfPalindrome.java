package main.java.string;

/**
 * check is rotation of palindrome or not
 * 
 * @author rahul2065
 *
 */
public class RotationOfPalindrome {
	/**
	 * This function will check string is palindrome or not
	 * 
	 * @param input
	 * @return
	 */
	private static boolean isPalindrome(final String input) {
		Boolean isPalindrome = Boolean.TRUE;
		int first = 0;
		int last = input.length() - 1;
		while (first < last) {
			if (input.charAt(first++) != input.charAt(last--)) {
				isPalindrome = Boolean.FALSE;
				break;
			}
		}
		return isPalindrome;
	}

	/**
	 * This function will check string is a rotation of palindrome or not
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isPalindromeRotation(String input) {
		if (isPalindrome(input)) {
			return true;
		}
		for (int i = 0; i < input.length(); i++) {
			String firstStr = input.substring(i + 1);
			String secondStr = input.substring(0, i + 1);
			System.out.println(firstStr + secondStr);
			if (isPalindrome(firstStr + secondStr)) {
				return true;
			}

		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(isPalindromeRotation("caacb"));
	}

}
