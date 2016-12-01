package main.java.dp;

/**
 * its same as knpsack and coin chaNGE PROBLEM
 * 
 * @author rdixi7
 *
 */
public class CuttingRodProblem {

	public static int optimizedValueOfCut(int[] val, int n, int rodLength) {

		if (n == 0 || rodLength == 0)
			return 0;
		if (n > rodLength)
			return optimizedValueOfCut(val, n - 1, rodLength);

		return Math.max(val[n - 1] + optimizedValueOfCut(val, n, rodLength - n),
				optimizedValueOfCut(val, n - 1, rodLength));

	}

	/**
	 * 
	 * @param val
	 * @param n
	 * @param rodLength
	 * @return
	 */
	public static int rodCut(int[] val, int n) {

		if (n <= 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, val[i] + rodCut(val, n - i - 1));
		}
		return max;

	}

	public static int rodCutDP(int[] val, int n) {
		int[] rodCut = new int[n + 1];
		rodCut[0] = 0;
		for (int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				max = Math.max(max,val[j]+rodCut[i-j-1]);
			}
			rodCut[i] = max;
		}
		return rodCut[n];

	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println(optimizedValueOfCut(arr, size, size));
		System.out.println(rodCutDP(arr, size));
	}

}
