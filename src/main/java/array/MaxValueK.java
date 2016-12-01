package main.java.array;

/**
 * Max value K such that there must be at least K elements greater than or equal
 * to k
 * 
 * with the upper statement it is clear that value of k can't be greater than n
 * 
 * @author rdixi7
 *
 */
public class MaxValueK {

	public static int maxValueKWithKelement(int[] input, int n) {
		int temp[] = new int[n + 1];
		int sum = 0;
		int result = -1;
		for (int i = 0; i < n; i++) {
			if (input[i] < n)
				temp[input[i]]++;
			else
				temp[n]++;
		}

		for (int i = n; i >= 0; i--) {
			sum = sum + temp[i];
			if (sum >= i) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 8, 10 };
		System.out.println(maxValueKWithKelement(arr, 5));
	}

}
