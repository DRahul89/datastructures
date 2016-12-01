package main.java.concurrency.lock;

public class Test {

	public static String reverseString(String reverse) {
		if (reverse.length() < 2) {
			return reverse;
		}
		return reverseString(reverse.substring(1)) + reverse.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println(reverseString("rahul"));
	}

}
