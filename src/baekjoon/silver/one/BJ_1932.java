package baekjoon.silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());

		int[][] tri = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int p = 0;
			while (stk.hasMoreTokens()) {
				tri[i][p++] = Integer.parseInt(stk.nextToken());
			}
		}
		dp[0][0] = tri[0][0];

		for (int i = 1; i < n; i++) {
			int p = 0;
			dp[i][p] = dp[i - 1][p] + tri[i][p];
			p++;
			while (p < i) {
				dp[i][p] = Math.max(dp[i - 1][p - 1], dp[i - 1][p]) + tri[i][p];
				p++;
			}
			dp[i][p] = dp[i - 1][p - 1] + tri[i][p];
		}

		int max = -1;
		int last = n - 1;
		for (int i = 0; i < n; i++) {
			max = Math.max(dp[last][i], max);
		}
		System.out.println(max);
	}
}
