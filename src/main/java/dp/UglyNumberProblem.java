package main.java.dp;

/**
 * UGLY NUMBERS ARE NUMBERS WHOSE ONLY PRIME FACTORS ARE 2,3 OR 5 algo take 3
 * sequence 1*2,2*2,3*2,4*2......... 1*3,2*3,3*3,4*3.........
 * 1*5,2*5,3*5,4*5............. each element of these sequence is a ugly number
 * now use merge logic to find all ugly number take three pointers select min
 * every time and increment that pointer
 *
 */
public class UglyNumberProblem {

	private static int min(int editDistance, int editDistance2, int editDistance3) {
		int min = -1;
		if (editDistance < editDistance2) {
			min = editDistance;
		} else {
			min = editDistance2;
		}
		if (min > editDistance3)
			min = editDistance3;
		return min;
	}

	public static void printUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		for (int i = 1; i < n; i++) {
			int multipleOf2 = 2 * ugly[i2];
			int multipleOf3 = 3 * ugly[i3];
			int multipleOf5 = 5 * ugly[i5];
			ugly[i] = min(multipleOf2, multipleOf3, multipleOf5);
			if (ugly[i] == multipleOf2) {
				i2++;
				multipleOf2 = multipleOf2 * 2;
			}
			if (ugly[i] == multipleOf3) {
				i3++;
				multipleOf3 = multipleOf3 * 3;
			}
			if (ugly[i] == multipleOf5) {
				i5++;
				multipleOf5 = multipleOf5 * 5;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(ugly[i]);
		}
	}

	public static void main(String[] args) {
		printUglyNumber(10);
	}
}
