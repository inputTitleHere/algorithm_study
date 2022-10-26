package inflearn._10ten;

import java.util.*;

public class Inf10_06 {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		dp = new int[m + 1];
		ArrayList<Question> arr = new ArrayList<>();
		for (int i = 0; i < n; i++)
			arr.add(new Question(sc.nextInt(), sc.nextInt()));
		Collections.sort(arr);
		for (Question q : arr) {
			for (int i = m; i >= q.time; i--) {
				dp[i] = Math.max(dp[i - q.time] + q.point, dp[i]);
			}
		}
		int max = 0;
		for (int i = 0; i <= m; i++)
			max = Math.max(dp[i], max);
		System.out.println(max);
	}
}

class Question implements Comparable<Question> {
	int point;
	int time;

	public Question(int point, int time) {
		this.point = point;
		this.time = time;
	}

	@Override
	public int compareTo(Question q) {
		if (q.time == this.time)
			return q.point - this.point;
		return this.time - q.time;
	}
}