package main.java.array;

/**
 * min no required to convert an array to its palindrome if only available
 * option is merge adjacent cell algo is fun(arr,i,j) if arr[i]==arr[j] then
 * func(arr,i+1,j-1) if arr[i] < arr[j] hen merge arr[i] and arr[i+1] return 1+
 * func(arr,i+1,j) else return 1+func(i,j-1);
 * 
 * @author rdixi7
 *
 */
public class MinOperationPalindrome {

	public static int minOperation(int[] arr, int i, int j, int n) {
		if (i >= n-1 || j <= 0 || i >=j)
			return 0;

		if (arr[i] == arr[j])
			return minOperation(arr, i + 1, j - 1, n);
		if (arr[i] < arr[j]) {
			arr[i + 1] = arr[i]+arr[i+1];
			return 1 + minOperation(arr, i + 1, j, n);
		} else {
			arr[j - 1] = arr[j]+arr[j-1];
			return 1 + minOperation(arr, i, j - 1, n);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 11, 14, 15, 99 };
		System.out.println(minOperation(arr, 0, arr.length - 1, arr.length));
	}

}
