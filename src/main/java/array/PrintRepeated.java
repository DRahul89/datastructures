package main.java.array;

/**
 * algo is Traverse the array. Do following for every index i of A[]. { check
 * for sign of A[abs(A[i])] ; if positive then make it negative by
 * A[abs(A[i])]=-A[abs(A[i])]; else // i.e., A[abs(A[i])] is negative this
 * element (ith element of list) is a repetition }
 * 
 * @author rdixi7
 *
 */
public class PrintRepeated {

	public static void printRepeated(int[] input) {
		for (int i = 0; i < input.length; i++) {

			if (input[Math.abs(input[i])] > 0) {
				input[Math.abs(input[i])] = -input[Math.abs(input[i])];
			} else {
				System.out.print("repeated element " + i +" ");
			}

		}
	}
	
	
	

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		printRepeated(arr);
	}

}
