package main.java.mathematical;

public class AverageOfStream {

	public static float avgNumber(float prevAvg, int newNum, int n) {
		return ((prevAvg * n) + newNum) / (n + 1);

	}

	public static void streamAvg(int arr[]) {
		float avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg = avgNumber(avg, arr[i], i);
			System.out.println("Average of" + (i + 1) + " numbers is %f \n"
					+ avg);
		}
		return;
	}

	public static int countNumberWithout3Digit(int num) {
		int totalWithoutThree = 0;
		for (int i = 1; i <= num; i++) {
			int currentNum = i;
			boolean containsThree = false;
			while (currentNum > 0) {
				if (currentNum % 10 == 3) {
					containsThree = true;
					break;
				}
				currentNum = currentNum / 10;
			}
			if (!containsThree)
				totalWithoutThree++;
		}
		return totalWithoutThree;

	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60 };
		//streamAvg(arr);
		System.out.println(countNumberWithout3Digit(45));
	}

}
