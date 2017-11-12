package main.java.hashtable;

import java.util.HashMap;
import java.util.Map;
class Pair{
	public Pair(int i2, int j2) {
		i=i2;
		j=j2;
	}
	int i;
	int j;
}
/**
 * question on pairing of array element
 * 
 * @author rdixi3
 *
 */
public class PairOfElementQuestions {
	/**
	 * 3 cases 1).calculate current fremainder if this remainder devide the K in
	 * to two halves then there must be two same lelemnt exists 2).if remainder
	 * 0 then even such element
	 * 
	 * 3)else remainder frequency == k-remainder frequency
	 * 
	 * @param elem
	 * @param k
	 * @return
	 */
	public static boolean canAllPairDivisibleByK(int[] elem, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int i = 0; i < elem.length; i++) {
			int rem = elem[i] % k;
			Integer element = frequency.get(rem);
			if (null != element) {
				frequency.put(rem, element + 1);
			} else {
				frequency.put(rem, 1);
			}
		}
		for (int i = 0; i < elem.length; i++) {
			int rem = elem[i] % k;
			if (2 * rem == k) {
				if (frequency.get(rem) % 2 != 0)
					return false;
			}
			if (rem == 0) {
				if (frequency.get(rem) % 2 != 0)
					return false;
			}
			if (frequency.get(rem) != frequency.get(k - rem))
				return false;
		}
		return true;
	}

	/**
	 * find if a+b=c+d exists
	 * @param elem
	 * @return
	 */
	public static boolean twoPairOfEqualSumExists(int[] elem){
		Map<Integer,Pair> pairSumMap=new HashMap<>();
		for(int i=0;i<elem.length-1;i++){
			for(int j=i+1;j<elem.length;j++){
				int sum = elem[i]+elem[j];
				if(pairSumMap.containsKey(sum)){
					Pair oldPair=pairSumMap.get(sum);
					System.out.println("("+elem[i]+","+elem[j]+")=="+"("+elem[oldPair.i]+","+elem[oldPair.j]+")");
					return true;
				}else{
					pairSumMap.put(sum, new Pair(i,j));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 92, 75, 65, 48, 45, 35 };
		int k = 10;
		int arr2[] = {3, 4, 7, 1, 2, 9, 8};
		System.out.println(twoPairOfEqualSumExists(arr2));
		//System.out.println(canAllPairDivisibleByK(arr, k));
	}
}
