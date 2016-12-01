package main.java.string;

/**
 * 
 * Max substring with K unique
 *
 */
public class MaxSubStringWithKUnique {
	/**
	 * Return false if less than K unique otherwise true
	 * 
	 * @param count
	 * @param k
	 * @return
	 */
	private static boolean isLessThanK(int[] count, int k) {
		int val = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				val++;
			}
		}
		return (k >= val);
	}

	public static String maxSubStringWithkUnique(final String input, final int k) {
		int[] count = new int[26];
		int startIndex = 0;
		int endIndex = 0;
		int maxWindowSize = 0;
		int maxWindowStart = 0;
		for (int i = 0; i < input.length(); i++) {
			count[input.charAt(i) - 'a']++;
			endIndex++;
			while (!isLessThanK(count, k)) {
				count[input.charAt(startIndex) - 'a']--;
				startIndex++;

			}
			if (endIndex - startIndex + 1 > maxWindowSize) {
				maxWindowSize = endIndex - startIndex + 1;
				maxWindowStart = startIndex;
			}
		}
		return input.substring(maxWindowStart, maxWindowSize + maxWindowStart
				- 1);

	}

	public static void main(String[] args) {
		System.out.println(maxSubStringWithkUnique("aabacbebebe", 3));

	}

}
