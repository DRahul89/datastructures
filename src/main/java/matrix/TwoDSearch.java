package main.java.matrix;

public class TwoDSearch {

	public static boolean isElementFound(final int[][] input, final int data) {
		Boolean isFound = false;
		isFound = processColumn(input, data);
		if (!isFound) {
			isFound = processRow(input, data);
		}
		return isFound;

	}

	public static boolean isElementFoundOptimized(final int[][] input,
			final int data) {
		Boolean isFound = false;
		int firstIndex = input.length - 1;
		int secondIndex = 0;
		while (firstIndex > 0 && secondIndex < input.length-1) {
			if (input[firstIndex][secondIndex] == data) {
				isFound = true;
				break;
			} else if (input[firstIndex][secondIndex] > data) {
				firstIndex--;
			} else {
				secondIndex++;
			}
		}

		return isFound;

	}

	private static Boolean processRow(int[][] input, int data) {
		for (int index = 0; index < input.length; index++) {
			if (input[0][index] == data) {
				return true;
			} else if (input[0][index] > data) {
				for (int i = 0; i < input.length; i++) {
					if (input[i][index - 1] == data) {
						return true;
					}
				}

			} else if (index == input.length - 1) {
				for (int i = 0; i < input.length; i++) {
					if (input[i][index] == data) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static Boolean processColumn(int[][] input, int data) {
		for (int index = 0; index < input.length; index++) {
			if (input[index][0] == data) {
				return true;
			} else if (input[index][0] > data) {
				for (int i = 0; i < input.length; i++) {
					if (input[index - 1][0] == data) {
						return true;
					}
				}

			} else if (index == input.length - 1) {
				for (int i = 0; i < input.length; i++) {
					if (input[index][i] == data) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(isElementFoundOptimized(mat, 100));

			}
		}

	}
}
