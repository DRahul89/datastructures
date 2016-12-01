package main.java.greedy;

/**
 * A solution for activity selection problem
 *
 */
public class ActivitySelectionProblem {
	/**
	 * This will always pick an activity with minimum finish time which has
	 * start time greater or equal than current
	 * 
	 * @param start
	 * @param finish
	 *            sorted
	 */
	public static void selectActivities(final int[] start, final int[] finish) {
		int i = 0;
		int count = 0;
		int[] selected = new int[start.length];
		selected[count++] = i;
		for (int j = 1; j < finish.length; j++) {
			if (start[j] >= finish[i]) {
				i = j;
				selected[count++] = j;
			}
		}

		for (i = 0; i < count; i++)
			System.out.println("selected " + selected[i]);

	}

	public static void main(String[] args) {
		int s[] = { 1, 3, 0, 5, 8, 5 };
		int f[] = { 2, 4, 6, 7, 9, 9 };
		selectActivities(s, f);
	}
}
