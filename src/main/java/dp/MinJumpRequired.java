package main.java.dp;

/**
 * Minimum jump required for reaching arr[n-1] from arr[0]
 * 
 * @author
 *
 */
public class MinJumpRequired {

	public static int minJump(int[] arr) {
		int[] jumps = new int[arr.length];
		jumps[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[i] > jumps[j] + 1) {
					jumps[i] = 1 + jumps[j];
					break;
				}
			}
		}
		return jumps[arr.length - 1];
	}

	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 1, 0, 9};
		System.out.println(minJump(arr));
	}
}
