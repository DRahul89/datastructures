package main.java.bitalgo;

public class RotateAndReverseBits {

	public static int leftRotate(int times, int num) {
		int mask = 1 << 7;
		int one = 1;
		for (int i = 0; i < times; i++) {
			if ((num & mask) != 0) {
				num = (num << 1) | one;
			} else {
				num = (num << 1);
			}
		}
		return num;
	}

	public static int rightRotate(int times, int num) {
		int one = 1;
		int mask = 1 << 7;
		for (int i = 0; i < times; i++) {
			if ((num & mask) != 0) {
				num = (num >> 1) | mask;
			} else {
				num = (num >> 1);
			}
		}
		return num;
	}

	public static int reverseBits(int num) {
		int one = 1;
		int mask = 1 << 3;
		while (mask >= one) {
			if (((num & mask) != 0) & ((num & one) == 0)) {
				num = num | one;
				num = num ^ mask;
			} else if (((num & mask) == 0) & ((num & one) != 0)) {
				num = num | mask;
				num = num ^ one;
			}
			one = one << 1;
			mask = mask >> 1;
		}
		return num;
	}

	public static boolean checkPalindromeBit(int num) {
		int count = 0;
		while (Math.pow(2, count) < num)
			count++;
		int one = 1;
		int mask = 1 << count - 1;
		while (mask >= one) {
			if ((((num & mask) > 0) && ((num & one)>0) || (((num & mask) == 0) && ((num & one) == 0)))) {
				one = one << 1;
				mask = mask >> 1;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(leftRotate(2, 16));
		System.out.println(rightRotate(2, 16));
		System.out.println(reverseBits(3));
		System.out.println(checkPalindromeBit(13));
	}

}
