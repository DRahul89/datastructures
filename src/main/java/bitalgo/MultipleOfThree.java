package main.java.bitalgo;

public class MultipleOfThree {

	public static boolean isMultipleOf3(int num) {
		int evenCount = 0;
		int oddCount = 0;
		if (num == 0)
			return true;
		if (num == 1)
			return false;
		while (num > 0) {
			if ((num & 1) == 1)
				oddCount++;
			num = num >> 1;
			if ((num & 1) == 1)
				evenCount++;
			num = num >> 1;
		}
		return isMultipleOf3(Math.abs(evenCount - oddCount));
	}

	public static void main(String[] args) {
		System.out.println(isMultipleOf3(14));
	}
}
