package main.java.mathematical;

public class BinaryWithoutConsecutiveOne {

	public static int possibleString(int input) {
		int totalPossibleStrings = pow(2, input);
		int consecutivePossible = 0;
		for (int j = 2; j <= input; j++) {
			for (int k = 0; k < input; k++) {
				if (k + j <= input) {
					consecutivePossible++;
				} else {
					break;
				}
			}

		}
		return totalPossibleStrings - consecutivePossible;
	}

	private static int pow(int input, int count) {
		if (count == 0)
			return 1;
		for (int i = 1; i < count; i++) {
			input = input * 2;
		}
		return input;
	}

	public static void main(String[] args) {
		System.out.println(possibleString(4));
	}

}
