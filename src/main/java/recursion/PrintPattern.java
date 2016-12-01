package main.java.recursion;

public class PrintPattern {

	public static void printPattern(final int testNumber, final int number, int variation, boolean flag) {
		System.out.println(number + " ");
		if (number <= 0)
			flag = false;
		if (testNumber == number && flag == false)
			return;
		if (flag == false)
			printPattern(testNumber, number + variation, variation, flag);
		else
			printPattern(testNumber, number - variation, variation, flag);
	}

	public static void printPattern(final int number, final int variation) {
		if (number <= 0) {
			System.out.println(number + " ");
			return;
		}
		System.out.println(number + " ");
		printPattern(number - variation, variation);
		System.out.println(number + " ");

	}

	public static void main(String[] args) {
		printPattern(10, 5);
	}
}
