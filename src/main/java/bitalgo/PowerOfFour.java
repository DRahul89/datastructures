package main.java.bitalgo;

public class PowerOfFour {

	public static boolean isPowerOfFour(int num) {
		int count = -1;
		if ((num & (num - 1)) == 0) {
			count = 0;
			while (num > 1) {
				num = num >> 1;
				count++;
			}
		}
		return (count % 2 == 0) ? true : false;
	}

	public static int nextPowerOfTwo(int num) {
		int count = 0;
		if ((num & (num - 1)) == 0) {
			return num;
		} else {
			while (num > 0) {
				num = num >> 1;
				count++;
			}
		}
		return 1 << count;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(12));
		System.out.println(nextPowerOfTwo(17));
	}
}
