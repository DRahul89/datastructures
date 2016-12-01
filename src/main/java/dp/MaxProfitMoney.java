package main.java.dp;

/**
 * N room contains money you have to max the money by collecting it but
 * constraint is no adjacent and no back moving
 * 
 * @author rdixi7
 *
 */
public class MaxProfitMoney {

	public static int maxMoney(int[] money, int startIndex) {
		if (startIndex >= money.length)
			return 0;
		System.out.println("ram");
		if (startIndex == money.length - 1)
			return money[startIndex];
		return Math.max(money[startIndex] + maxMoney(money, startIndex + 2), maxMoney(money, startIndex + 1));

	}

	public static int maxMoneyDP(int[] money, int startIndex, int memoized[]) {
		System.out.println("shyam");
		if (startIndex >= money.length)
			return 0;
		if (memoized[startIndex] == -1) {
			System.out.println("ram");
			if (startIndex == money.length - 1)
				return money[startIndex];

			memoized[startIndex] = Math.max(money[startIndex] + maxMoneyDP(money, startIndex + 2, memoized),
					maxMoneyDP(money, startIndex + 1, memoized));
		}
		return memoized[startIndex];
	}

	public static void main(String[] args) {
		int[] money = { 2000, 1500, 1600, 1500, 10, 1000, 2000 };
		int[] memoized = { -1, -1, -1, -1, -1, -1, -1 };
		//System.out.println(maxMoney(money, 0));
		System.out.println(maxMoneyDP(money, 0, memoized));
	}

}
