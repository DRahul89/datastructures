package main.java.array;

/**
 * maintain four array leftMin,leftMax,rightMin,rightMax
 * 
 * leftMax[0 to i] rightMax[i+1 to n] by cadan's algo leftMin[0 to i]
 * rightMin[i+1 to n] by cadane's algo and then find the max difference
 *
 */
public class MaxContiguousSubArraySumDifference {

	public static int maxLeftSubArraySum(int[] val, Integer[] sum) {
		int maxSOFar = val[0];
		int curMax = val[0];
		sum[0] = maxSOFar;
		for (int i = 1; i < val.length; i++) {
			curMax = Math.max(val[i], curMax + val[i]);
			if (curMax > maxSOFar)
				maxSOFar = curMax;
			sum[i] = maxSOFar;
		}
		return maxSOFar;
	}

	public static int maxRightSubArraySum(int[] val, Integer[] sum) {
		int maxSOFar = val[val.length - 1];
		int curMax = val[val.length - 1];
		sum[val.length - 1] = maxSOFar;
		for (int i = val.length - 2; i >= 0; i--) {
			curMax = Math.max(val[i], curMax + val[i]);
			if (curMax > maxSOFar)
				maxSOFar = curMax;
			sum[i] = maxSOFar;
		}
		return maxSOFar;
	}

	public static int maxDifference(int[] input) {
		int maxResult = -1;
		Integer[] leftMax = new Integer[input.length];
		Integer[] rightMax = new Integer[input.length];
		Integer[] leftMin = new Integer[input.length];
		Integer[] rightMin = new Integer[input.length];
		maxLeftSubArraySum(input, leftMax);
		maxRightSubArraySum(input, rightMax);
		int[] invertedArr = new int[input.length];
		for (int i = 0; i < input.length; i++)
			invertedArr[i] = -input[i];
		maxLeftSubArraySum(invertedArr, leftMin);
		maxRightSubArraySum(invertedArr, rightMin);
		for (int i = 0; i < input.length; i++) {
			leftMin[i] = -leftMin[i];
			rightMin[i] = -rightMin[i];
		}

		for (int i = 0; i < input.length - 1; i++) {
			int firstMax = Math.abs(leftMax[i] - rightMin[i + 1]);
			int secondMax = Math.abs(leftMin[i] - rightMax[i + 1]);
			if (Math.max(firstMax, secondMax) > maxResult)
				maxResult = Math.max(firstMax, secondMax);
		}
		return maxResult;
	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxDifference(a));
	}

}
