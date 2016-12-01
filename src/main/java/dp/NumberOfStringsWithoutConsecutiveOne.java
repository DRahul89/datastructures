package main.java.dp;

/**
 * Algo is a[i] is a number of strings of length i ends with 0 b[i] is number of
 * strings of length i ends with 1 so recurrence relation could be formed a[i] =
 * a[i-1]+b[i-1] because we could append 1 to string ends with either 1 or 0
 * similarly
 * 
 * b[i] = a[i-1]
 * 
 * @author rdixi7
 *
 */
public class NumberOfStringsWithoutConsecutiveOne {

	public static int lengthOfStrings(int n) {
		int a[] = new int[n + 1];
		int b[] = new int[n + 1];
		a[1] = 1;
		b[1] = 1;
		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		return a[n] + b[n];
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfStrings(3));
	}

}
