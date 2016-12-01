package main.java.bitalgo;

public class AllSetBitCountWithRange {

	public static int getSetBitCount(int number) {
		int bitCount = 0;
		int one = 1;
		for (int i = 1; i <= number; i++) {
			int val = i;
			while (val != 0) {
				if ((val & one) != 0) {
					bitCount++;
				}
				val = val >> 1;
			}
		}
		return bitCount;
	}
	
	public static void main(String[] args) {
		System.out.println(getSetBitCount(8));
	}
}
