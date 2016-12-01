package main.java.mathematical;

public class TowerOfHanoi {

	public static void towerOfHanoi(int plates, char source, char temp,
			char destination) {

		if (plates == 1) {
			System.out
					.println("Move disk 1 from " + source + " to " + destination);
			return;
		}
		towerOfHanoi(plates - 1, source, destination, temp);
		System.out.println("Move disk" + plates + " from " + source + " to "
				+ destination);
		towerOfHanoi(plates - 1, temp, source, destination);
	}

	public static void main(String[] args) {
		towerOfHanoi(3, 'a', 'b', 'c');
	}

}
