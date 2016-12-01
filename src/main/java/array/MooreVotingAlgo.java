package main.java.array;

/**
 * algo to find majority element
 * 
 * Basic idea of the algorithm is if we cancel out each occurrence of an element
 * e with all the other elements that are different from e then e will exist
 * till end if it is a majority element. 2. Check if the element obtained from
 * above step is majority element.
 * 
 * @author rdixi7
 *
 */
public class MooreVotingAlgo {

	public static int mooreVotingAlgoForMajority(int[] input) {
		int maxIndex = 0;
		int count = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[maxIndex] == input[i])
				count++;
			else
				count--;
			if (count == 0) {
				maxIndex = i;
				count = 1;
			}
		}
		return input[maxIndex];
	}

	public static boolean isMajority(int[] input, int result) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == result)
				count++;
		}
		return (count >= input.length / 2) ? true : false;
	}

	public static void printMajority(int[] input) {
		int majority = mooreVotingAlgoForMajority(input);
		if (isMajority(input, majority)) {
			System.out.println("majority elem is  " + majority);
		} else {
			System.out.println("No Majority Element");
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 3, 2 };
		printMajority(a);
	}
}
