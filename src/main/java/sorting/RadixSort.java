package main.java.sorting;

/**
 * sort the number array by digits use count sort as subroutine
 * 
 * @author rdixi7
 *
 */
public class RadixSort {

	public static int getMax(Integer[] input) {
		int max = -1;
		for (int i = 0; i < input.length; i++) {
			if (max < input[i])
				max = input[i];
		}
		return max;
	}

	public static void countSort(final Integer[] input, final int range, int exp) {
		int[] rangeArray = new int[range];
		int[] temp = new int[input.length];
		for (int i = 0; i < range; i++) {
			rangeArray[i] = 0;
		}
		for (int i = 0; i < input.length; i++) {
			rangeArray[(input[i] / exp) % 10] = rangeArray[(input[i] / exp) % 10] + 1;
		}

		for (int i = 1; i < range; i++) {
			rangeArray[i] = rangeArray[i] + rangeArray[i - 1];
		}

		for (int i = input.length-1; i >= 0; i--) {
			temp[rangeArray[(input[i] / exp) % 10] - 1] = input[i];
			rangeArray[(input[i] / exp) % 10] = rangeArray[(input[i] / exp) % 10] - 1;
		}

		for (int i = 0; i < input.length; i++) {
			input[i] = temp[i];
		}

	}
	
	public static void radixSort(Integer [] input){
		int max = getMax(input);
		for(int i=1;(max/i) > 0 ;i=i*10)
			countSort(input, 10, i);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		Integer arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
	}

}
