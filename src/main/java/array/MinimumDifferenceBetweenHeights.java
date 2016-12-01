package main.java.array;

/**
 * Sort array in increasing order Initialize maximum and minimum elements. maxe
 * = arr[n-1], mine = arr[0] If k is more than difference between maximum and
 * minimum, add/subtract k to all elements as k cannot decrease the difference.
 * Example {6, 4}, k = 10. In sorted array, update first and last elements.
 * arr[0] += k; // arr[0] is minimum and k is +ve arr[n-1] -= k; // arr[n-1] is
 * maximum and k is -ve Initialize mac and min of modified array (only two
 * elements have been finalized) new_max = max(arr[0], arr[n-1]), new_min =
 * min(arr[0], arr[n-1]) Finalize middle n-2 elements. Do following for every
 * element arr[j] where j lies from 1 to n-2. If current element is less than
 * min of modified array, add k. Else If current element is more than max of
 * modified array, subtract k. arr[j] is between new_min and new_max. If arr[j]
 * is closer to new_max, subtract k Else add k to arr[j]. Update new_max and
 * new_min if required new_max = max(arr[j], new_max), new_min = min(arr[j],
 * new_min) Returns difference between new_max and new_min return (new_max –
 * new_min);
 * 
 * @author rdixi7
 *
 */
public class MinimumDifferenceBetweenHeights {

	// implementation same as algo

}
