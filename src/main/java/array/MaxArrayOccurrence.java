package main.java.array;

import main.java.sorting.BubbleSort;

public class MaxArrayOccurrence {

	public static int getMaxOccuredElement(int[] input) {

		BubbleSort.sortSecond(input);
		int count = 1;
		int maxCount = -1;
		int maxOccuredElement = -1;

		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] == input[i + 1]) {
				count++;
				if (count >= maxCount) {
					maxCount = count;
					maxOccuredElement = i;
				}
			} else {
				count = 1;
			}
		}

		return maxOccuredElement != -1 ? input[maxOccuredElement] : -1;

	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 4, 3, 1, 2, 2, 4, 4 ,3,4,5,3,3,3};
		System.out.println(getMaxOccuredElement(input));
	}
}
