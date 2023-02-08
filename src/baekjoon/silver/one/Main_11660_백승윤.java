package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		int[][] board = new int[n + 1][n + 1];
		int[][] sumboard = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
				sumboard[i][j] = board[i][j] + sumboard[i - 1][j] + sumboard[i][j - 1] - sumboard[i - 1][j - 1];
			}
		}
		for (int t = 0; t < m; t++) {
			stk = new StringTokenizer(br.readLine());
			// 문제에서 가로축이 x임.
			int y1 = Integer.parseInt(stk.nextToken());
			int x1 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken());
			int x2 = Integer.parseInt(stk.nextToken());

			int area = sumboard[y2][x2] - sumboard[y2][x1 - 1] - sumboard[y1 - 1][x2] + sumboard[y1 - 1][x1 - 1];
			sb.append(area).append("\n");
		}
		System.out.print(sb.toString());
	}
}
