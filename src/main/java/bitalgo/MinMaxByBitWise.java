package main.java.bitalgo;

public class MinMaxByBitWise {

	public static int findMin(int first, int second) {

		return second ^ ((first ^ second) & -(first < second ? 1 : 0));

	}

	public static int findMin(int first, int second, int third) {

		int min = second ^ ((first ^ second) & -(first < second ? 1 : 0));
		return third ^ ((min ^ third) & -(min < third ? 1 : 0));

	}

	public static int findMax(int first, int second) {
		return first ^ ((first ^ second) & -(first < second ? 1 : 0));
	}

	public static int findMax(int first, int second, int third) {
		int max = first ^ ((first ^ second) & -(first < second ? 1 : 0));
		return max ^ ((max ^ third) & -(max < third ? 1 : 0));
	}

	public static void main(String[] args) {
		System.out.println(findMax(1, 2, 3));
	}

}
