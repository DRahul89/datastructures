package main.java.string;

public class Test {
	
	public static int numberOfOperationForPalindrome(String input){
        int total =0;
        int start =0;
        int end = input.length()-1;
        while(start < end){
            char first = input.charAt(start);
            char last = input.charAt(end);
            total = total + Math.abs(first - last);
            start++;
            end--;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOperationForPalindrome("abc"));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }

}
