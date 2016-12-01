package main.java.array;

/**
 * algo is bcz order of array would be first aray then second array in
 * increasing oreder means all greter would be in second array so pick last of
 * first and put at last of second and adjust last of second to first in sorted
 * order Input: ar1[] = {1, 5, 9, 10, 15, 20}; ar2[] = {2, 3, 8, 13}; Output:
 * ar1[] = {1, 2, 3, 5, 8, 9} ar2[] = {10, 13, 15, 20}
 * 
 * @author rdixi7
 *
 */
public class MergeTwoArrayWithConstantSpace {

	public static void mergeSorted(int[] first, int[] second, int m, int n) {
		int j = 0;
		for (int i = n - 1; i >= 0; i--) {
			int lastOfFirst = first[m - 1];
			for (j = m - 1; first[j] > second[i]; j--) {
				first[j] = first[j - 1];
			}
			if (j != m - 1) {
				first[j + 1] = second[i];
				second[i] = lastOfFirst;
			}
		}
		for (int i = 0; i < m; i++)
			System.out.print(first[i] + " ");
		System.out.println();
		for (int i = 0; i < n; i++)
			System.out.print(second[i] + " ");

	}

	public static void main(String[] args) {
		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13 };
		mergeSorted(ar1, ar2, ar1.length, ar2.length);

	}

}
