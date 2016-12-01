package main.java.dp;

public class MatrixChainMultiplication {
	/**
	 * dimension of A[i] matrix A(i-1)*A(i)
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	public static int matrixChainOrder(int[] arr, int i, int j) {
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int val = matrixChainOrder(arr, i, k) + arr[i - 1] * arr[k] * arr[j] + matrixChainOrder(arr, k + 1, j);
			if (val < min)
				min = val;
		}
		return min;
	}

	/**
	 * dimension of A[i] matrix A(i-1)*A(i)
	 * 
	 * @param arr
	 * @param n
	 * @param k
	 * @return
	 */
	public static int matrixChainOrderDP(int[] arr, int n) {
		int[][] mat = new int[n][n];// mat[i][j] is min number of computation
									// for matrix A[i] A[i+1]...A[j]
		for (int i = 0; i < n; i++)
			mat[i][i] = 0;
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				mat[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int res = mat[i][k] + mat[k + 1][j] + arr[i - 1] * arr[j] * arr[k];
					if (res < mat[i][j])
						mat[i][j] = res;

				}
			}
		}
		return mat[1][n - 1];
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + matrixChainOrderDP(arr,n));
	}

}
