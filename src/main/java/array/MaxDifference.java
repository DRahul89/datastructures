package main.java.array;

/**
 * Maximum difference between two elements such that larger element appears
 * after the smaller number
 * 
 * @author rdixi7
 *
 */
public class MaxDifference {
	/**
	 * First find the difference between the adjacent elements of the array and
	 * store all differences in an auxiliary array diff[] of size n-1. Now this
	 * problems turns into finding the maximum sum subarray of this difference
	 * array. Thanks to Shubham Mittal for suggesting this solution.
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	int maxDiff(int arr[], int n) {
		// Initialize diff, current sum and max sum
		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {
			// Calculate current diff
			diff = arr[i + 1] - arr[i];

			// Calculate current sum
			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			// Update max sum, if needed
			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		return max_sum;
	}

}
