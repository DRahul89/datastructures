package main.java.array;

/**
 * algo is find max contiguous by cadane algo then find total sum and min
 * contiguous by cadanes algo then subtract total sum and minimum contiguous
 * 
 * @author rdixi7
 *
 */
public class CirrcularSumArray {

	public static int kadaneAlgo(int[] val) {
		int maxSOFar = 0;
		int maxEndHere = 0;
		for (int i = 0; i < val.length; i++) {
			maxEndHere = maxEndHere + val[i];
			if (maxEndHere < 0)
				maxEndHere = 0;
			if (maxSOFar < maxEndHere)
				maxSOFar = maxEndHere;
		}

		return maxSOFar;
	}

	public static int getMaxCircularSumArray(int[] input) {
		int totalSum = 0;
		int maxContiSum = kadaneAlgo(input);
		int[] invertedArr = new int[input.length];
		for (int i = 0; i < input.length; i++)
			invertedArr[i] = -input[i];
		int minContSum = kadaneAlgo(invertedArr);
		for (int i = 0; i < input.length; i++)
			totalSum = totalSum + input[i];

		int circularSum = totalSum - (-minContSum);

		return Math.max(maxContiSum, circularSum);
	}

	public static void main(String[] args) {
		int[] arr = { 10, -3, -4, 7, 6, 5, -4, -1 };
		System.out.println(getMaxCircularSumArray(arr));
	}
}
