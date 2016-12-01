package main.java.mathematical;

public class FibonacciNumber {

	/**
	 * f[n]=f[n-1]+f[n-2]
	 * 
	 * @param n
	 * 
	 * @return f[n]
	 */
	public static int fibonacciNumber(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
	}

	/**
	 * f[n]=f[n-1]+f[n-2]
	 * 
	 * @param n
	 * 
	 * @return f[n]
	 */
	public static int fibonacciNumberByDynamicProgramming(int n) {

		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int counter = 2; counter <= n; counter++)
			fib[counter] = fib[counter - 1] + fib[counter - 2];
		return fib[n];

	}

	public static void main(String[] args) {
		System.out.println(fibonacciNumberByDynamicProgramming(9));
	}

}
