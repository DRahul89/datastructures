package main.java.string;

/**
 * 
 * abc is subsequence of artbkjhc this class will check this
 * 
 *
 */
public class CheckSubsequence {
	/**
	 * check whether first is sequence of second
	 * 
	 * @param fist
	 * @param second
	 * @return
	 */
	public static boolean checkSequence(final String first, final String second) {
		Boolean isSequence = false;
		int firstIndex = 0;
		int secondIndex = 0;
		while (secondIndex < second.length()) {
			if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
				firstIndex++;
			}
			secondIndex++;
			if (firstIndex == first.length()) {
				isSequence = true;
				break;
			}
		}
		return isSequence;
	}

	public static void main(String[] args) {
		System.out.println(checkSequence("gksrek", "geeksforgeeks"));
	}

}
