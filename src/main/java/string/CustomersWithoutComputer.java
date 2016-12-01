package main.java.string;

import java.util.HashSet;
import java.util.Set;

public class CustomersWithoutComputer {
	/**
	 * 
	 * @param computerAssigned
	 * @param person
	 * @return
	 */
	private static int isPersonLeaving(final char[] computerAssigned,
			final char person) {
		int index = -1;
		for (int i = 0; i < computerAssigned.length; i++) {
			if (computerAssigned[i] == person) {
				index = i;
				for (int j = index; j < computerAssigned.length - 1; j++) {
					computerAssigned[j] = computerAssigned[j + 1];
				}
				break;
			}
		}
		return index;

	}

	/**
	 * 
	 * @param input
	 * @param noOfComp
	 * @return
	 */
	public static int numberOfCustomersWithoutComputer(final String input,
			int noOfComp) {
		int assign = 1;
		Set withoutAssignperson = new HashSet<Character>();
		char[] computerAssigned = new char[noOfComp];
		computerAssigned[0] = input.charAt(0);
		noOfComp--;
		char person = ' ';
		for (int i = 1; i < input.length(); i++) {
			person = input.charAt(i);
			int index = isPersonLeaving(computerAssigned, person);
			if (index != -1) {
				computerAssigned[index] = ' ';
				noOfComp++;
				assign--;
			} else {
				if (assign + 1 > computerAssigned.length) {
					if (withoutAssignperson.add(person)) {
						System.out.println("can not assign computer to "
								+ person);
					}
				} else {
					computerAssigned[assign++] = person;
					noOfComp--;
				}
			}
		}
		return withoutAssignperson.size();
	}

	public static void main(String[] args) {
		System.out.println("Number of customer without computer assigned "
				+ numberOfCustomersWithoutComputer("ABCBCADEED", 1));
	}
}
