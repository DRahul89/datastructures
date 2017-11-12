package main.java.matrix;

/**
 * In MS-Paint, when we take the brush to a pixel and click, the color of the
 * region of that pixel is replaced with a new selected color. Following is the
 * problem statement to do this task. Given a 2D screen, location of a pixel in
 * the screen and a color, replace color of the given pixel and all adjacent
 * same colored pixels with the given color.
 * 
 * 
 * 
 * The idea is simple, we first replace the color of current pixel, then recur
 * for 4 surrounding points. The following is detailed algorithm.
 * 
 * 
 * // A recursive function to replace previous color 'prevC' at '(x, y)' // and
 * all surrounding pixels of (x, y) with new color 'newC' and
 * floodFil(screen[M][N], x, y, prevC, newC) 1) If x or y is outside the screen,
 * then return. 2) If color of screen[x][y] is not same as prevC, then return 3)
 * Recur for north, south, east and west. floodFillUtil(screen, x+1, y, prevC,
 * newC); floodFillUtil(screen, x-1, y, prevC, newC); floodFillUtil(screen, x,
 * y+1, prevC, newC); floodFillUtil(screen, x, y-1, prevC, newC);
 * 
 * @author rdixi3
 *
 */
public class FloodFillAlgorithm {

	public static void floodFillUtil(char[][] matrix, int x, int y, char oldVal, char newVal) {
		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix.length)
			return;
		if (matrix[x][y] != oldVal)
			return;
		floodFillUtil(matrix, x + 1, y, oldVal, newVal);
		floodFillUtil(matrix, x, y + 1, oldVal, newVal);
		floodFillUtil(matrix, x - 1, y, oldVal, newVal);
		floodFillUtil(matrix, x, y - 1, oldVal, newVal);
	}

	void replaceSurrounded(char mat[][],int M,int N)
	{
	   // Step 1: Replace all 'O'  with '-'
	   for (int i=0; i<M; i++)
	      for (int j=0; j<N; j++)
	          if (mat[i][j] == 'O')
	             mat[i][j] = '-';
	 
	   // Call floodFill for all '-' lying on edges
	   for (int i=0; i<M; i++)   // Left side
	      if (mat[i][0] == '-')
	        floodFillUtil(mat, i, 0, '-', 'O');
	   for (int i=0; i<M; i++)  //  Right side
	      if (mat[i][N-1] == '-')
	        floodFillUtil(mat, i, N-1, '-', 'O');
	   for (int i=0; i<N; i++)   // Top side
	      if (mat[0][i] == '-')
	        floodFillUtil(mat, 0, i, '-', 'O');
	   for (int i=0; i<N; i++)  // Bottom side
	      if (mat[M-1][i] == '-')
	        floodFillUtil(mat, M-1, i, '-', 'O');
	 
	   // Step 3: Replace all '-' with 'X'
	   for (int i=0; i<M; i++)
	      for (int j=0; j<N; j++)
	         if (mat[i][j] == '-')
	             mat[i][j] = 'X';
	 
	}

}
