package main.java.mathematical;

public class FirstKdigitOfOneByN {

	public static void printFirstKOfOneByN(int n, int k) {
		int t = 1;
		for (int i = 0; i < k; i++) {

			int number = (t * 10) / n;
			System.out.println(number);
			t = (t * 10) % n;
		}
	}

	public static void main(String[] args) {
		printFirstKOfOneByN(21,4);
	}
}
