package main.java.string;

public class MinOperationRequired {

	public static int minOperationRequired(final String first,
			final String transform) {
		int result = 0;
		for (int i = first.length() - 1, j = transform.length() - 1; i >= 0;) {
			while (i >= 0 && first.charAt(i) != transform.charAt(j)) {
				i--;
				result++;
			}

			// If A[i] and B[j] match
			if (i >= 0) {
				i--;
				j--;
			}
		}
		return result;
	}

	public static boolean transformationPossible(String first, String transform) {
		int i = 0;
		first = first.toLowerCase();
		transform = transform.toLowerCase();
		boolean isTransormPossible = true;
		int[] count = new int[26];
		while (i < first.length()) {
			count[first.charAt(i) - 'a']++;
			i++;
		}
		i = 0;
		while (i < transform.length()) {
			count[transform.charAt(i) - 'a']--;
			i++;
		}
		for (i = 0; i < 26; i++) {
			if (count[i] != 0) {
				isTransormPossible = false;
				break;

			}
		}
		return isTransormPossible;
	}

	public static void main(String[] args) {
		System.out.println(transformationPossible("EACBD", "EABC"));
		System.out.println(minOperationRequired("EACBD", "EABCD"));
	}
}
