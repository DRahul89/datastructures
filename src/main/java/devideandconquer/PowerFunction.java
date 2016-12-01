package main.java.devideandconquer;

/**
 * A class contains method with different complexity for power calculation
 * 
 *
 */
public class PowerFunction {
	/**
	 * Power with time complexity (n^2) T[n] = T[n-1] + 1;
	 * 
	 * @param number
	 * @param power
	 * @return
	 */
	private static int calculatePower(int number, int power) {
		if (power == 0)
			return 1;
		return number * calculatePower(number, power - 1);

	}

	/**
	 * Power with time complexity (n) T[n] = 2T[n/2] + 1;
	 * 
	 * @param number
	 * @param power
	 * @return
	 */
	private static int calculatePowerWithOrderN(int number, int power) {
		int value;
		if (power == 0)
			return 1;
		if (power % 2 == 0) {
			value = calculatePowerWithOrderN(number, power / 2)
					* calculatePowerWithOrderN(number, power / 2);
		} else {
			value = number * calculatePowerWithOrderN(number, power / 2)
					* calculatePowerWithOrderN(number, power / 2);
		}
		return value;

	}

	/**
	 * Power with time complexity (log n) T[n] = T[n/2] + 1;
	 * 
	 * @param number
	 * @param power
	 * @return
	 */
	private static int calculatePowerWithOrderlogN(int number, int power) {
		int value;
		if (power == 0)
			return 1;
		value = calculatePowerWithOrderlogN(number, power / 2);
		if (power % 2 == 0) {
			value = value * value;
		} else {
			value = number * value * value;
		}
		return value;

	}

	/**
	 * Power with time complexity (log n) T[n] = T[n/2] + 1;
	 * 
	 * @param number
	 * @param power
	 * @return
	 */
	private static float calculatePowerWithOrderlogNWithNegative(int number,
			int power) {
		float value;
		if (power == 0)
			return 1;
		value = calculatePowerWithOrderlogNWithNegative(number, power / 2);
		if (power % 2 == 0) {
			value = value * value;
		} else {
			if (power > 0) {
				value = number * value * value;
			} else {
				value = (value * value) / number;
			}
		}
		return value;

	}

	public static void main(String[] args) {
		System.out.println("power val " + calculatePowerWithOrderN(9, 3));
	}
}
