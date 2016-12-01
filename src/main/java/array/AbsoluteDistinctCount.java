package main.java.array;

/**
 * algo is initialize total count as total element then decrease fro duplicates
 * and find sum =0 for any two elements and decrease count
 * 
 * @author rdixi7
 *
 */
public class AbsoluteDistinctCount {

	public static int getAbsoluteDistinctCount(int[] input) {
		int count = input.length;
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			while (left < right && input[left] == input[left + 1]) {
				left++;
				count--;
			}
			while (left < right && input[right] == input[right - 1]) {
				right--;
				count--;
			}

			int sum = input[left] + input[right];
			if (sum == 0) {
				count--;
				left++;
				right--;
			} else if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int arr[] = {-2, -1, 0, 1, 1};
		System.out.println(getAbsoluteDistinctCount(arr));
	}
}
