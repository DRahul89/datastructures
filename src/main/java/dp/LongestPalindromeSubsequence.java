package main.java.dp;

/**
 * 
 * @author rdixi7
 *
 */
public class LongestPalindromeSubsequence {

	/**
	 * algo 1).if x[0]==x[n-1] return longestPalSus(str,1,n-2)+2; 2).return
	 * max(longestPalSus(str,0,n-2),longestPalSus(str,1,n-1))
	 * 
	 * @param str
	 * @param i
	 * @param j
	 * @return
	 */
	public static int longestPalSuB(String str, int i, int j) {
		if (i == j)
			return 1;
		if (str.charAt(i) == str.charAt(j) && i + 1 == j)
			return 2;

		if (str.charAt(i) == str.charAt(j))
			return longestPalSuB(str, i + 1, j - 1) + 2;

		return Math.max(longestPalSuB(str, i + 1, j), longestPalSuB(str, i, j - 1));

	}

	/**
	 * longest palindrome subsequences
	 * 
	 * @param str
	 * @return
	 */
	public static int longestPalSubBYDP(String str) {
		int[][] table = new int[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++)
			table[i][i] = 1;

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j) && l == 2) {
					table[i][j] = 2;
				} else if (str.charAt(i) == str.charAt(j)) {
					table[i][j] = table[i + 1][j - 1] + 2;
				} else {
					table[i][j] = Math.max(table[i + 1][j], table[i][j - 1]);
				}

			}
		}

		return table[0][str.length() - 1];

	}

	/**
	 * longest palindrome substring
	 * 
	 * @param str
	 * @return
	 */
	public static void longestPalSubstringDP(String str) {
		boolean[][] table = new boolean[str.length()][str.length()];
		int startIndex = -1;
		int maxLength = -1;
		for (int i = 0; i < str.length(); i++)
			table[i][i] = true;

		for (int l = 2; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j) && l == 2) {
					table[i][j] = true;
					startIndex = i;
					maxLength = 2;
				} else if (str.charAt(i) == str.charAt(j) && table[i + 1][j - 1]) {
					table[i][j] = true;
					startIndex = i;
					if (l > maxLength)
						maxLength = l;
				}

			}
		}

		System.out.println("max palindrome substring " + str.substring(startIndex, startIndex + maxLength));
		System.out.println("length of max palindrome substring " + maxLength);
	}

	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
		String str = "forgeeksskeegfor";
		longestPalSubstringDP(str);
		System.out.println(longestPalSubBYDP(seq));

	}

}
