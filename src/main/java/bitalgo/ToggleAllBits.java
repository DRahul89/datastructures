package main.java.bitalgo;

public class ToggleAllBits {

	public static int toggleBits(int num) {
		int one = 1;
		for (int j = 0; j < 32; j++) {
			num = num ^ one;
			one = one << 1;
		}
		return num;
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

	public static int getAbs(int num) {
		if (num > 0)
			return num;
		else
			return addOneByPattern(toggleBits(num));
	}

	public static int modulus(int number, int devidor) {
		return number & (devidor - 1);
	}

	public static int turnOffBitWithPosition(int position, int num) {
		int mask = 1 << position - 1;
		return (num ^ mask) & num;
	}

	public static void main(String[] args) {
		System.out.println(getAbs(6));
		System.out.println(modulus(6, 4));
		System.out.println(turnOffBitWithPosition(3, 15));
	}

}
