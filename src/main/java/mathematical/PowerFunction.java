package main.java.mathematical;

public class PowerFunction {

	public static int powerWithoutMultiplication(int number, int power) {
		int increment = number;
		int value = number;
		for (int i = 0; i < power-1; i++) {
			for (int j = 0; j < number-1; j++) {
				value = value + increment;
			}
			increment = value;
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(powerWithoutMultiplication( 5,3));
	}
}
