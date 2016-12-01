package main.java.mathematical;

public class LuckyNumber {

	public static boolean isLucky(int number, int counter) {
		if (number < counter)
			return true;

		if (number % counter == 0)
			return false;
		return isLucky((number - number / counter), counter + 1);
	}

	public static void main(String[] args) {
		System.out.println(isLucky(19, 2));
	}
}
