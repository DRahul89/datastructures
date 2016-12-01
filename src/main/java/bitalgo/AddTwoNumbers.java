package main.java.bitalgo;

public class AddTwoNumbers {

	public static int addTwoNumbers(int first, int second) {
		int one = 1;
		for (int i = 1; i <= 32; i++) {
			int firstBit = first & one;
			int secondBit = second & one;
			if ((firstBit & secondBit) != 0) {
				first = first | (firstBit ^ secondBit);
			} else {
				first = first | (firstBit ^ secondBit);
			}
			one = one << i;
		}
		return first;
	}
	
	public static int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
	public static void main(String[] args) {
		System.out.println(Add(5,5));
	}

}
