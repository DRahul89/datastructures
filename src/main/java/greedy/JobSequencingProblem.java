package main.java.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains the logic for job sequencing.Maximize the profits so greedy decision
 * will be for maximum profit
 * 
 * @author rahul2065
 *
 */
public class JobSequencingProblem {

	public class Job implements Comparable<Job> {

		private char jobid;

		private int profit;

		private int deadline;

		public Job(char jobid, int profit, int deadline) {
			this.jobid = jobid;
			this.profit = profit;
			this.deadline = deadline;
		}

		@Override
		public int compareTo(Job o) {
			return o.profit - this.profit;
		}

		public char getJobid() {
			return jobid;
		}

		public void setJobid(char jobid) {
			this.jobid = jobid;
		}

		public int getProfit() {
			return profit;
		}

		public void setProfit(int profit) {
			this.profit = profit;
		}

		public int getDeadline() {
			return deadline;
		}

		public void setDeadline(int deadline) {
			this.deadline = deadline;
		}

	}

	/**
	 * find the jobs for maximizing the profit
	 * 
	 * @param jobs
	 */
	public static void findJobSequence(final List<Job> jobs) {
		Collections.sort(jobs);
		char[] allocated = new char[jobs.size()];
		for (int i = 0; i < allocated.length; i++)
			allocated[i] = ' ';
		for (int i = 0; i < jobs.size(); i++) {
			for (int j = jobs.get(i).getDeadline()-1; j >= 0; j--) {
				if (allocated[j] == ' ') {
					allocated[j] = jobs.get(i).getJobid();
					break;
				}
			}

		}

		for (int i = 0; i < allocated.length; i++) {
			System.out.println("JOB selected ids " + allocated[i]);
		}

	}

	public static void main(String[] args) {
		JobSequencingProblem jobSequencingProblem = new JobSequencingProblem();
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(jobSequencingProblem.new Job('a', 100, 2));
		jobs.add(jobSequencingProblem.new Job('b', 19, 1));
		jobs.add(jobSequencingProblem.new Job('c', 27, 1));
		jobs.add(jobSequencingProblem.new Job('d', 25, 4));
		jobs.add(jobSequencingProblem.new Job('e', 15, 3));
		findJobSequence(jobs);

	}

}
