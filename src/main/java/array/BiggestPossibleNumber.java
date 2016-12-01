package main.java.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * {54, 546, 548, 60}, the arrangement 6054854654
 * 
 * @author rdixi7
 *
 */
public class BiggestPossibleNumber {
	/**
	 * this method sort according to xy or yx which number is greater
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static Comparator<Integer> myComparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer x, Integer y) {
			String xy = x + "" + y;
			String yx = y + "" + x;
			if (xy.compareTo(yx) == 0)
				return 0;
			return xy.compareTo(yx) > 0 ? -1 : 1;
		}

	};

	public static void printBiggestPossibleNumber(Integer[] input) {

		Arrays.sort(input, BiggestPossibleNumber.myComparator);

		for (int i = 0; i < input.length; i++)
			System.out.print(input[i]);

	}

	public static void main(String[] args) {
		Integer[] input = { 548, 546, 54, 60 };
		printBiggestPossibleNumber(input);
	}
}
