package main.java.array;

public class ReplaceEveryWithMaxRight {

	public static void replaceWithMaxRight(int[] input) {

		int maxSoFar = input[input.length - 1];
		input[input.length - 1] = -1;
		for (int i = input.length - 2; i >= 0; i--) {
			int temp = input[i];
			input[i] = maxSoFar;
			if (temp > maxSoFar)
				maxSoFar = temp;
		}

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}

	}

	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		replaceWithMaxRight(arr);

	}

}
