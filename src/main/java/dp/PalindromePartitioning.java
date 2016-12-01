package main.java.dp;

/**
 * minimum cut required to cut a string in to all palindromes
 * aba|b|bbabb|a|b|aba and “a|babbbab|b|ababa for palindrome only one cut is
 * required
 * 
 * see recursion in copy
 * 
 * @author rdixi7
 *
 */
public class PalindromePartitioning {
	/**
	 * a similar logic to matrix chain multiplicaTIONS for start == end means
	 * palindrome no cut required so return 0 similarly for palindrome no cut
	 * requrired return 0 for n length string max n-1 cut required every
	 * character as palindrome
	 * 
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static int minPalindromePartitioning(final String str, int start, int end) {
		if (start == end)
			return 0;
		if (isPalindrome(str, start, end))
			return 0;
		int globalMin = Integer.MAX_VALUE;
		for (int k = start; k < end; k++) {
			int min = minPalindromePartitioning(str, start, k) + 1 + minPalindromePartitioning(str, k + 1, end);
			if (min < globalMin)
				globalMin = min;
		}
		return globalMin;

	}

	private static boolean isPalindrome(String str, int start, int end) {
		while (str.charAt(start) == str.charAt(end) && start < end) {
			start++;
			end--;
		}
		return (start >= end);
	}

	/**
	 * a dynamic programming bottom up solution table would be like matrix chain
	 * multiplication
	 * 
	 * @param str
	 * @return
	 */
	public static int minPalindromePartitioningDP(String str) {
		int[][] c = new int[str.length()][str.length()];// c[i][j] represents
														// min cut required for
														// palindrome
														// partitioning of str[i
														// to j]
		boolean[][] pal = new boolean[str.length()][str.length()];// str[i to j
																	// ] is
																	// palindrome
																	// the
																	// pal[i][j]=true
																	// else
																	// false
		for (int i = 0; i < str.length(); i++) {
			c[i][i] = 0;
			pal[i][i] = true;
		}

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j) && l == 2)
					pal[i][j] = true;
				else if (str.charAt(i) == str.charAt(j) && pal[i + 1][j - 1])
					pal[i][j] = true;

				if (pal[i][j] == true) {
					c[i][j] = 0;
				} else {
					c[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						c[i][j] = Math.min(c[i][k] + 1 + c[k + 1][j], c[i][j]);
					}
				}
			}
		}

		return c[0][str.length() - 1];

	}

	public static void main(String[] args) {
		String str = "ababbbabbababa";
		// System.out.println(minPalindromePartitioning(str, 0, str.length() -
		// 1));
		System.out.println(minPalindromePartitioningDP(str));
	}

}
