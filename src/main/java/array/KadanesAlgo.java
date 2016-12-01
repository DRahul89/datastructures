package main.java.array;

/*
 * for finding the largest sum contiguous sub array
 * algo
 * 
 * Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
 */
public class KadanesAlgo {

	public static int kadaneAlgo(int[] val) {
		int maxSOFar = 0;
		int maxEndHere = 0;
		for (int i = 0; i < val.length; i++) {
			maxEndHere = maxEndHere + val[i];
			if (maxEndHere < 0)
				maxEndHere = 0;
			if (maxSOFar < maxEndHere)
				maxSOFar = maxEndHere;
		}

		return maxSOFar;
	}

	/**
	 * second which handle all negative also
	 * 
	 * @param val
	 * @return
	 */
	public static int kadaneAlgoSecond(int[] val) {
		int maxSOFar = 0;
		int curMax = 0;
		for (int i = 0; i < val.length; i++) {
			curMax = Math.max(val[i], curMax + val[i]);
			if (curMax > maxSOFar)
				maxSOFar = curMax;
		}

		return maxSOFar;
	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.err.println(kadaneAlgoSecond(a));
	}

}
