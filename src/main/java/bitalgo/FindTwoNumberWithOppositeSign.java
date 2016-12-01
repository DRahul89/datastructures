package main.java.bitalgo;

public class FindTwoNumberWithOppositeSign {

	public static boolean isOppositeSign(int first, int second) {
		int result = first ^ second;
		boolean isOpposite = false;
		if (result < 0)
			isOpposite = true;
		return isOpposite;
	}
	
	public static void main(String[] args) {
		System.out.println(isOppositeSign(100,100));
	}

}
