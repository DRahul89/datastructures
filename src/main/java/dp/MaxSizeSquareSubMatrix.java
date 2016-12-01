package main.java.dp;

/**
 * find max size square sub matrix with all ones
 * 
 * algo is create one more aarray s[i][j] where each s[i][j] is max square
 * matrix size including m[i][j] and s[i][j] is rightmost bottom most cell if
 * m[i][j] is 1 then s[i][j] = min(s[i][j-1],s[i-1][j].s[i-1][j-1])+1; else
 * s[i][j] =0 then find max value cell
 * 
 * @author rdixi7
 *
 */
public class MaxSizeSquareSubMatrix {

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

	/**
	 * copy first row and col as it is
	 * 
	 * @param m
	 */
	public static void maxSizeSquare(int[][] m) {
		int[][] s = new int[m.length][m[0].length];
		for (int i = 0; i < m.length; i++)
			s[i][0] = m[i][0];
		for (int j = 0; j < m[0].length; j++)
			s[0][j] = m[0][j];
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[0].length; j++) {
				if (m[i][j] == 1) {
					s[i][j] = min(s[i][j - 1], s[i - 1][j], s[i - 1][j - 1]) + 1;
				} else {
					s[i][j] = 0;
				}
			}
		}
		int maxValue = Integer.MIN_VALUE;
		int row = -1;
		int col = -1;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (s[i][j] > maxValue) {
					maxValue = s[i][j];
					row = i;
					col = j;

				}
			}
		}

		System.out.println("size of max sub matrix " + maxValue);
		System.out.println("end cell of matrix  " + "(" + row + "," + col + ")");
	}

	public static void main(String[] args) {
		int M[][] = new int[][] { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		maxSizeSquare(M);
	}

}
