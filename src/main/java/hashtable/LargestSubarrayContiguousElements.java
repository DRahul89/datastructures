package main.java.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * algo is diff between min and max must be equal to difference between strt and
 * end index
 * 
 * @author rdixi3
 *
 */
public class LargestSubarrayContiguousElements {

	public static int largestContiguousSubarrayWithoutDuplicate(int[] elem) {
		int maxLen = -1;
		for (int i = 0; i < elem.length-1; i++) {
			int max = elem[i];
			int min = elem[i];
			for (int j = i+1; j < elem.length; j++) {
				if (elem[j] > max)
					max = elem[j];
				if (elem[j] < min)
					min = elem[j];
				if(max-min == j-i){
					maxLen = Math.max(maxLen,j-i+1);
				}
			}
		}
		return maxLen;
	}
	
	public static int largestContiguousSubarrayWithDuplicate(int[] elem) {
		int maxLen = -1;
		Set<Integer> unique=null;
		for (int i = 0; i < elem.length-1; i++) {
			int max = elem[i];
			int min = elem[i];
			unique=new HashSet<>();
			unique.add(elem[i]);
			for (int j = i+1; j < elem.length; j++) {
				//this subarray cant contain contiguous
				if(unique.contains(elem[j])){
					break;
				}
				if (elem[j] > max)
					max = elem[j];
				if (elem[j] < min)
					min = elem[j];
				if(max-min == j-i){
					maxLen = Math.max(maxLen,j-i+1);
				}
				unique.add(elem[j]);
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		int arr2[] =  {10, 12, 12, 10, 10, 11, 10};
		System.out.println(largestContiguousSubarrayWithoutDuplicate(arr));
		System.out.println(largestContiguousSubarrayWithDuplicate(arr2));
	}

}
