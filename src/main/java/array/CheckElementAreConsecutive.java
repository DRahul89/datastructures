package main.java.array;

/**
 * algo if max-min+1=n and all elemnts are distinct then elements would be
 * consecutive
 * 
 * @author rdixi7
 *
 */
public class CheckElementAreConsecutive {

	public static int getMax(int[] input) {
		int max = -1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max)
				max = input[i];
		}
		return max;
	}

	public static int getMin(int[] input) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (input[i] < min)
				min = input[i];
		}
		return min;
	}

	/**
	 * for distinct we negate every element
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isConsecutive(final int[] input) {
		int min = getMin(input);
		int max = getMax(input);
		if (max - min + 1 == input.length) {
			for (int i = 0; i < input.length; i++) {
				int index = 0;
				if (input[i] < 0)
					index = -input[i] - min;
				else
					index = input[i] - min;
				if (input[index] > 0)
					input[index] = -input[index];
				else
					return false;
			}
		} else
			return false;
		return true;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 5, 3, 2, 6 };
		System.out.println(isConsecutive(arr));
	}

}
