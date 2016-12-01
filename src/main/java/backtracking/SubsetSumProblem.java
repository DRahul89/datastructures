package main.java.backtracking;

/**
 * algo based on subset tree if(subset is satisfying the constraint) print the
 * subset exclude the current element and consider next element else generate
 * the nodes of present level along breadth of tree and recur for next levels
 * 
 * @author
 *
 */
public class SubsetSumProblem {

	public static void subsetSum(int[] elements, int[] subset, int start, int targetSum, int currentSum) {
		if (currentSum == targetSum) {
			for (int i = 0; i < subset.length; i++)
				System.out.print(subset[i] + " ");
			System.out.println();
			subset[start-1] = -1;
			subsetSum(elements, subset, start, targetSum, currentSum - elements[start - 1]);
			return;
		}
		for (int i = start; i < elements.length; i++) {
			subset[start] = elements[i];
			subsetSum(elements, subset, i + 1, targetSum, currentSum + elements[i]);
			subset[start] = -1;
		}
	}

	public static void main(String[] args) {
		int weights[] = { 10, 5, 18, 12, 20, 15 };
		int[] subsetSum = new int[weights.length];
		subsetSum(weights, subsetSum, 0, 35, 0);
	}

}
