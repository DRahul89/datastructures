package main.java.array;

public class RemoveDuplicate {

	public static void getUniqueElementArray(int[] input) {
		int length = input.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (input[i] == input[j]){
					if(j != i){
						deleteAndShift(input, j,length);
						length--;
					}
				}
			}
		}
	}

	private static void deleteAndShift(final int[] input, int index,int length) {
		while (index < length - 1) {
			input[index] = input[index + 1];
			index++;
		}
		input[length-1] = -1; 
	}
	
	public static void main(String[] args) {
		int[] input={1,2,4,3,1,2,};
		getUniqueElementArray(input);
		for (int j = 0; j < input.length; j++) {
			System.out.println(input[j]);
		}
		
	}

}
