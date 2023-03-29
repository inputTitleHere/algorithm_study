package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_백승윤 {

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		int t = Integer.parseInt(br.readLine());

		board = new int[31][31];
		board[0][0]=1;
		for (int i = 1; i <= 30; i++) {
			for (int j = 0; j <= 30; j++) {
				if(j==0 || j==30) {
					board[i][j]=1;
					continue;
				}
				board[i][j]=board[i-1][j-1]+board[i-1][j];
			}
		}
		
		for (int tt = 0; tt < t; tt++) {
			stk = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());

			sb.append(board[n][k]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
