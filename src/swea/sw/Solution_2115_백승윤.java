package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2115_백승윤 {

	static int n;
	static int m;
	static int c;

	static int lmax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());

			int[][] hive = new int[n][n];
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					hive[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			// solve

			int[][] dp = new int[n][n - m + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					lmax = 0;
					int[] local = new int[m];
					boolean[] used = new boolean[m];
					System.arraycopy(hive[i], j, local, 0, m);
					dfs(local, 0, 0, used);
					dp[i][j] = lmax;
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.println(Arrays.toString(dp[i]));
			}
			
			
			
			// print
			sb.append("#").append(tc).append(" ");

		}
		System.out.println(sb.toString());
	}

	static void dfs(int[] local, int sum, int step, boolean[] used) {
		if (sum > c) {
			return;
		}
		if (step == m) {
			int lsum = 0;
			for (int i = 0; i < m; i++) {
				if (used[i]) {
					lsum += local[i] * local[i];
				}
			}
			lmax = Math.max(lmax, lsum);
			return;
		}

		used[step] = true;
		dfs(local, sum + local[step], step + 1, used);

		used[step] = false;
		dfs(local, sum, step + 1, used);

	}
}
