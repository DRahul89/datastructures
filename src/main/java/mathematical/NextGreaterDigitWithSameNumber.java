package main.java.mathematical;

/**
 * 
 *
 */
public class NextGreaterDigitWithSameNumber {

	public static void nextGreaterNumber(char[] numbers) {

		if (!isEncreasingNumber(numbers) && !isDecreasingMethod(numbers)) {
			int indexOfSwap = findIndexOfSwap(numbers);
			generateNextGreater(numbers, indexOfSwap);
		}

	}

	private static void generateNextGreater(char[] numbers, int indexOfSwap) {
		int nextElementIndex = -1;
		char mainElement = numbers[indexOfSwap];
		char nextElement = ':';
		for (int i = indexOfSwap + 1; i < numbers.length; i++) {
			if (mainElement < numbers[i] && numbers[i] < nextElement) {
				nextElement = numbers[i];
				nextElementIndex = i;
			}
		}
		char temp = numbers[indexOfSwap];
		numbers[indexOfSwap] = numbers[nextElementIndex];
		numbers[nextElementIndex] = temp;
		sort(numbers, indexOfSwap + 1);
	}

	public static void sort(final char[] input, int startIndex) {
		int length = input.length;
		boolean swapped = true;
		for (int i = length - 1; i >= startIndex && swapped; i--) {
			for (int j = startIndex; j <= i - 1; j++) {
				swapped = false;
				if (input[j] > input[j + 1]) {
					char temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					swapped = true;
				}
			}
		}
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
	}

	private static int findIndexOfSwap(char[] numbers) {
		int indexOfSwap = -1;
		for (int i = numbers.length - 1; i > 0; i--) {
			if (numbers[i - 1] < numbers[i]) {
				indexOfSwap = i - 1;
				break;
			}
		}
		return indexOfSwap;
	}

	private static boolean isDecreasingMethod(char[] numbers) {
		boolean isDecreasing = Boolean.TRUE;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i + 1]) {
				isDecreasing = Boolean.FALSE;
			}
		}
		if (isDecreasing) {
			System.out.println("Not Possible");
		}
		return isDecreasing;
	}

	private static boolean isEncreasingNumber(char[] numbers) {
		boolean isEncreasing = Boolean.TRUE;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				isEncreasing = Boolean.FALSE;
			}
		}
		if (isEncreasing) {
			char temp = numbers[numbers.length - 1];
			numbers[numbers.length - 1] = numbers[numbers.length - 2];
			numbers[numbers.length - 2] = temp;
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i]);
			}
		}
		return isEncreasing;
	}

	public static void main(String[] args) {
		char digits[] = { '5', '3', '4', '9', '7', '6' };
		char digitsSecond[] = { '5', '4', '3', '2', '1' };
		char digitsThird[] = { '1', '2', '3', '4', '5' };
		nextGreaterNumber(digitsThird);
	}

}
