package main.java.string;

/**
 * Contains the method for string pattern matching code
 * 
 *
 */
public class StringPatterMatching {
	/**
	 * Naive algo for string matching
	 * 
	 * @param text
	 * @param pattern
	 */
	public void naiveStringMatchingAlgo(final String text, final String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		for (int i = 0; i <= (textLength - patternLength); i++) {
			int j = 0;
			for (j = 0; j < patternLength; j++) {
				if (text.charAt(i + j) == pattern.charAt(j)) {
					continue;
				} else {
					break;
				}
			}
			if (j == patternLength) {
				System.out.println("pattern matched found at " + i);
			}
		}

	}

	/**
	 * intermediate function for calculating lps
	 * 
	 * @param pattern
	 * @return
	 */
	private int[] computeLps(final String pattern) {
		int len = 0;// length of previous longest prefix suffix
		int lps[] = new int[pattern.length()];
		lps[0] = 0;
		int i = 1;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i++] = 0;
				}

			}

		}
		return lps;
	}

	/**
	 * KMP algo for string matching
	 * 
	 * @param text
	 * @param pattern
	 */
	public void kmpStringMatchingAlgo(final String text, final String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		int lps[] = computeLps(pattern);
		int i = 0;
		int j = 0;
		while (i < textLength) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if (j == patternLength) {
				System.out.println("pattern matched found at " + (i - j));
				j = lps[j - 1];
			} else if (i < textLength && text.charAt(i) != pattern.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}

			}

		}
	}

}
