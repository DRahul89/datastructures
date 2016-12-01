package main.java.recursion;

public class SequenceForSum {

	public static void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	public static void generateUtil(int x, int arr[], int curr_sum, int curr_idx) {
		// If current sum is equal to x, then we found a sequence
		if (curr_sum == x) {
			printArr(arr, curr_idx);
			return;
		}

		// Try placing all numbers from 1 to x-curr_sum at current index
		int num = 1;

		// The placed number must also be smaller than previously placed
		// numbers, i.e., arr[curr_idx-1] if there exists a previous number
		while (num <= x - curr_sum
				&& (curr_idx == 0 || num <= arr[curr_idx - 1])) {
			// Place number at curr_idx
			arr[curr_idx] = num;

			// Recur
			generateUtil(x, arr, curr_sum + num, curr_idx + 1);

			// Try next number
			num++;
		}
	}

	// A wrapper over generateUtil()
	public static void generate(int x) {
		int arr[] = new int[x]; // Array to store sequences on by one
		generateUtil(x, arr, 0, 0);
	}

	public static void main(String[] args) {
		int x = 3;
		generate(x);
	}
}
