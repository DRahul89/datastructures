package main.java.hashtable;

import java.util.HashMap;

/**
 * Algo for this we count distinct of k window now we use that value for further
 * calculation
 *
 *
 */
public class DistinctElementOfAllWindowSizeK {

	/**
	 * calculate distinct 1) Create an empty hash map. Let hash map be hM
	 * 
	 * 2) Initialize distinct element count ‘dist_count’ as 0.
	 * 
	 * 3) Traverse through first window and insert elements of first window to
	 * hM. The elements are used as key and their counts as value in hM. Also
	 * keep updating ‘dist_count’
	 * 
	 * 4) Print ‘dist_count’ for first window.
	 * 
	 * 3) Traverse through remaining array (or other windows). ….a) Remove the
	 * first element of previous window. …….If the removed element appeared only
	 * once …………..remove it from hM and do “dist_count–” …….Else (appeared
	 * multiple times in hM) …………..decrement its count in hM
	 * 
	 * ….a) Add the current element (last element of new window) …….If the added
	 * element is not present in hM …………..add it to hM and do “dist_count++”
	 * …….Else (the added element appeared multiple times) …………..increment its
	 * count in hM
	 * 
	 * Below is implementation of above approach.
	 * 
	 * JavaC++
	 * 
	 * @param entry
	 * @param k
	 */
	public static void distinctElementInKSizeWindow(final int[] entry, final int k) {
		HashMap<Integer, Integer> dist = new HashMap<>();
		int distCount = 0;
		for (int i = 0; i < k; i++) {
			if (null != dist.get(entry[i])) {
				int count = dist.get(entry[i]);
				dist.put(entry[i], count+1);
			} else {
				dist.put(entry[i],1);
				distCount++;
			}
		}
		System.out.println("first window dist count =" + distCount);
		for (int i = k; i < entry.length; i++) {
			if (null!=dist.get(entry[i - k]) && dist.get(entry[i - k]) == 1) {
				dist.remove(entry[i - k]);
				distCount--;
			} else {
				int count = dist.get(entry[i-k]);
				dist.put(entry[i-k], count--);
			}
			// add new element
			if (dist.get(entry[i]) == null) {
				dist.put(entry[i],1);
				distCount++;
			} else {
				int count = dist.get(entry[i]);
				if(count==1){
					distCount--;
				}
				dist.put(entry[i], count++);
			}
			System.out.println("window dist count =" + distCount);
		}
	}
	
	public static void main(String[] args) {
		int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        distinctElementInKSizeWindow(arr, k);
	}
}
