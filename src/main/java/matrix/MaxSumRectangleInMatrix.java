package main.java.matrix;

/**
 * Kadane’s algorithm for 1D array can be used to reduce the time complexity to
 * O(n^3). The idea is to fix the left and right columns one by one and find the
 * maximum sum contiguous rows for every left and right column pair. We
 * basically find top and bottom row numbers (which have maximum sum) for every
 * fixed left and right column pair. To find the top and bottom row numbers,
 * calculate sun of elements in every row from left to right and store these
 * sums in an array say temp[]. So temp[i] indicates sum of elements from left
 * to right in row i. If we apply Kadane’s 1D algorithm on temp[], and get the
 * maximum sum subarray of temp, this maximum sum would be the maximum possible
 * sum with left and right as boundary columns. To get the overall maximum sum,
 * we compare this sum with the maximum sum so far.
 * 
 * @author rdixi3
 *
 */
public class MaxSumRectangleInMatrix {

	public static int[] kadane(int[] temp) {
		int[] maxResult = { Integer.MIN_VALUE, -1, -1 };
		int localIndex = -1;
		int currentSum = 0;
		for (int i = 0; i < temp.length; i++) {
			currentSum = currentSum + temp[i];
			if (currentSum < 0) {
				currentSum = 0;
				localIndex = i + 1;
			} else if (currentSum > maxResult[0]) {
				maxResult[0] = currentSum;
				maxResult[1] = localIndex;
				maxResult[2] = i;
			}

		}

		// all numbers in temp are negative
		if (maxResult[2] == -1) {
			maxResult[0] = 0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] > maxResult[0]) {
					maxResult[0] = temp[i];
					maxResult[1] = i;
					maxResult[2] = i;
				}
			}
		}
		return maxResult;
	}

	public static void maxSumRectangle(int[][] mat, int m, int n) {

		int[] maxResult = null;
		int result = Integer.MIN_VALUE;
		int leftColInd = -1;
		int rightColInd = -1;
		int topRowInd = -1;
		int bottomRowInd = -1;
		for (int leftCol = 0; leftCol < n; leftCol++) {
			int[] temp = new int[m];
			for (int rightCol = leftCol; rightCol < n; rightCol++) {
				for (int i = 0; i < m; i++) {
					temp[i] = temp[i] + mat[i][rightCol];
				}
				maxResult = kadane(temp);
				if (maxResult[0] > result) {
					result =maxResult[0];
					leftColInd = leftCol;
					rightColInd = rightCol;
					topRowInd = maxResult[1];
					bottomRowInd = maxResult[2];
				}
			}

		}

		System.out.println("MaxSum: " + result + 
                ", range: [(" + leftColInd + ", " + topRowInd + 
                  ")(" + rightColInd + ", " + bottomRowInd + ")]");
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
		maxSumRectangle(mat, 4, 5);
	}

}
