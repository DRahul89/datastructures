package main.java.array;

/**
 * algo is arr[i to j] is even sum subarray if cumulative sum array
 * (temp[j]-temp[i])%2 ==0 so we would count the number of times it become even
 * and odd then choose any two of them for condition (temp[j]-temp[i])%2 ==0 by
 * c(n,2)=n*(n-1)/2
 * 
 * @author rdixi7
 *
 */
public class EvenSumSubarraysCount {

	public static int getSubArrayCount(int[] input) {
		int[] temp = {1,0};
		int sum = 0;
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			sum = (sum + input[i])%2;
			temp[sum]++;
		}
		result = result + (temp[0] * (temp[0] - 1) / 2);
		result = result + (temp[1] * (temp[1] - 1) / 2);
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 4, 1};
		System.out.println("subarrays with even sum "+getSubArrayCount(arr));
		
	}
}
