package main.java.backtracking;

public class PermutationOfString {

	public static void allPermutation(char[] str, int start, int end) {
		if (start >= end){
			System.out.println(str);
			return;
		}
		for (int i = start; i <= end; i++) {
			swap(str, start, i);
			allPermutation(str, start+1, end);
			swap(str, start, i);
		}
	}

	private static void swap(char[] str, int start, int end) {
		char temp = str[start];
		str[start] = str[end];
		str[end] = temp;

	}

	public static void main(String[] args) {
		char[] str = { 'a', 'b', 'c' };
		allPermutation(str, 0, 2);
	}
}
