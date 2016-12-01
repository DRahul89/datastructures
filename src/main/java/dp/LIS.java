package main.java.dp;

/**
 * <10 ,22 , 9 , 33 ,21 ,50 , 41, 60> length 5 <10 , 22 ,33 ,50 ,60>
 * 
 * one more imp question longest bitonic sequence so calculate lis from left to
 * right then right to left and return max of lis + lds -1 similarly maximum
 * length chain of pairs by same method
 */
public class LIS {

	public static int largestIncreasingSubsequence(int[] arr) {
		int max = -1;
		int[] lis = new int[arr.length];
		for (int i = 0; i < lis.length; i++)
			lis[i] = 1;

		for (int i = 1; i < lis.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}

		return lis[arr.length - 1];
	}

	public static int largestIncreasingSumSubsequence(int[] arr) {
		int max = -1;
		int[] sum = new int[arr.length];
		for (int i = 0; i < sum.length; i++)
			sum[i] = arr[i];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && sum[i] < sum[j] + arr[i])
					sum[i] = sum[j] + arr[i];
			}
		}

		for (int i = 1; i < sum.length; i++) {
			if (sum[i] > max)
				max = sum[i];
		}

		return max;
	}

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int arrSum[] = { 1, 101, 2, 3, 100, 4, 5 };
		System.out.println("Length of lis is " + largestIncreasingSubsequence(arr) + "\n");
		System.out.println("max sum of sub sequence is " + largestIncreasingSumSubsequence(arrSum) + "\n");
	}

}
