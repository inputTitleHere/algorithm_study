package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17070_백승윤 {
	static int n;
	static int[][][] dp;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n][3]; // 0 가로자세, 1, 대각선자세, 2 세로자세
		visited = new boolean[n][n][3];
		dp[0][1][0]=1;
		visited[0][1][0]=true;

		StringTokenizer stk = null;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		System.out.println(cnt(n-1,n-1,0)+cnt(n-1,n-1,1)+cnt(n-1,n-1,2));
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(dp[i][j][0]+dp[i][j][1]+dp[i][j][2]);
//				System.out.print(Arrays.toString(dp[i][j]));
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
	}

	static int cnt(int r, int c, int d) {
		if (r >= n || r < 0 || c < 0 || c >= n) {
			// todo -> 1 찾는거 추가.
			return 0;
		}
		if (!visited[r][c][d]) {
			int result = 0;
			if (d == 0) { // 가로 -> 가로 & 대각
				if (c - 1 >= 1 && map[r][c - 1] == 0 && map[r][c]==0) {
					result = cnt(r, c - 1, 0) + cnt(r, c - 1, 1);
				}
			} else if (d == 1) { // 대각 -> 가로 & 대각 & 세로 다 들어옴
				if (c - 1 >= 1 && r - 1 >= 0 && map[r - 1][c - 1] == 0 && map[r - 1][c] == 0 && map[r][c - 1] == 0 && map[r][c]==0
						) {
					result = cnt(r - 1, c - 1, 0) + cnt(r - 1, c - 1, 1) + cnt(r - 1, c - 1, 2);
				}
			} else { // d==2 세로 -> 대각 & 세로
				if (r - 1 >= 0 && map[r - 1][c] == 0 && map[r][c]==0) {
					result = cnt(r - 1, c, 1) + cnt(r - 1, c, 2);
				}
			}
			visited[r][c][d] = true;
			return dp[r][c][d] = result;
		} else {
			return dp[r][c][d];
		}
	}
}
