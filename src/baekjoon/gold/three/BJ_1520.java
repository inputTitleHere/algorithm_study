package baekjoon.gold.three;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1520 {

	static int[][] map;
	static int[][] dp;
	static int count;
	static int m;
	static int n;

	static int m1;
	static int n1;

	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		m = Integer.parseInt(stk.nextToken()); // 가로
		n = Integer.parseInt(stk.nextToken()); // 세로
		map = new int[m][n];
		dp = new int[m][n];
		m1 = m - 1;
		n1 = n - 1;
		count = 0;

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				dp[i][j] = -1;
			}
		}
		dp[m1][n1]=1;
		dfs(0, 0);
		System.out.println(dp[0][0]);
		
	}

	static int dfs(int y, int x) {
		if (dp[y][x] != -1) {
			return dp[y][x];
		}
		dp[y][x]=0;
		for (int i = 0; i < 4; i++) {
			int ny = dir[i][0] + y;
			int nx = dir[i][1] + x;

			if (ny > -1 && ny < m && nx > -1 && nx < n && map[y][x] > map[ny][nx]) {
				dp[y][x] += dfs(ny, nx);
			}
		}
		return dp[y][x];
	}
}
