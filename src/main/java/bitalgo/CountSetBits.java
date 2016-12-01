package main.java.bitalgo;

/**
 * By using Kernighan’s Algorithm
 * 
 * @author rahul2065
 *
 */
public class CountSetBits {

	public static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	public static int addOne(int x) {
		return (-(~x));
	}

	public static int decreaseOne(int x) {
		int one = 1;
		for (int i = 1; i <= 32; i++) {
			if ((x & one) != 0) {
				x = x ^ one;
				break;
			} else {
				x = x | one;
			}
			one = 1 << i;
		}
		return x;
	}

	public static int addOneByPattern(int x) {
		int one = 1;
		for (int i = 1; i <= 32; i++) {
			if ((x & one) != 0) {
				x = x ^ one;
			} else {
				x = x | one;
				break;
			}
			one = 1 << i;
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println(countSetBits(10));
		System.out.println(addOne(10));
		System.out.println(decreaseOne(10));
		System.out.println(addOneByPattern(-200));
	}
}
