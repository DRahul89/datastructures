package main.java.bitalgo;

public class SwapBitsWithPosition {

	public static int swapBitsWithPosition(int number, int pos1, int pos2,
			int length) {
		int first = 1 << pos1;
		int second = 1 << pos2;
		for (int i = 0; i < length; i++) {
			if ((number & first) == 0 && (number & second) != 0) {
				number = number | first;
				number = number ^ second;
			}else if ((number & first) != 0 && (number & second) == 0) {
				number = number | second;
				number = number ^ first;
			}
			first = first << 1;
			second = second << 1;

		}
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println(swapBitsWithPosition(47,1,5,3));
	}

}
