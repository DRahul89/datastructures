package main.java.bitalgo;

/**
 * Logic is first take xor then any set bit of whole xor then devide in two sets
 * 
 * @author rahul2065
 *
 */
public class TwoNonRepeatingElement {

	public static void twoNonRepeatingElement(int[] arr) {
		int xor = arr[0];
		int firstNum = 0;
		int secondNum = 0;
		for (int i = 1; i < arr.length; i++)
			xor = xor ^ arr[i];

		int setBit = xor & (~(xor - 1));

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & setBit) != 0) {
				firstNum = firstNum ^ arr[i];
			} else {
				secondNum = secondNum ^ arr[i];
			}
		}

		System.out.println("firstNum " + firstNum + "secondNum" + secondNum);

	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11 };
		twoNonRepeatingElement(arr);
	}
}
