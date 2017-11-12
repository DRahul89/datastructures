package main.java.matrix;

public class BooleanMatrix {

	/**
	 * proble is to find k such that all element of kth row are zero and kth col
	 * 1 algo there could be only one such k so start searching from top corner
	 * 
	 * @param input
	 * @param m
	 * @param n
	 * @return
	 */
	public static int kRowZeroKColOne(int[][] input, int m, int n) {
		int row=0;
		int col=n-1;
		int result=-1;
		while(row<m && col > 0){
			//this row could be a solution
			if(input[row][col]==0){
				int j=col-1;
				while(j>0 && (row==col || input[row][j]==0))
					j--;
				if(j==0){
					result = row;
					break;
				}
				else{
					row++;
				}
			}
			//this col could be a solution
			if(input[row][col]==1){
				int i=row+1;
				while(i < m-1 && (row==col || input[i][col]==1))
					i++;
				if(i==m-1){
					result=col;
					break;
				}else{
					col--;
				}
					
			}
		}
		
		if(result != -1){
			for(int i=0;i<m;i++){
				if(input[i][result]!=1 && i!=result)
					return -1;
			}
			for(int j=0;j<n;j++){
				if(input[result][j]!=0 && j!=result)
					return -1;
			}
			System.out.println("index found is "+ result);
			return result;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int mat[][] = {{0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1}};
		kRowZeroKColOne(mat, 5, 5);
	}
}
