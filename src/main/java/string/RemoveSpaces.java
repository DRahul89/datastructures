package main.java.string;

/**
 * 
 * 
 *
 */
public class RemoveSpaces {

	public static String remaoveSpaces(char[] input) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != ' ') {
				input[count++] = input[i];
			}

		}
		return new String(input,0,count);
	}

	public static void main(String[] args) {
		String input = "my name is";
		System.out.println(remaoveSpaces(input.toCharArray()));
	}
}
