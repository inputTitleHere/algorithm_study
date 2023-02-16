package baekjoon.gold.four;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_17406_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int kt=0;kt<k;kt++) {
			stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken()); // y
			int c = Integer.parseInt(stk.nextToken()); // x
			int s = Integer.parseInt(stk.nextToken());
			
			for(int l=1;l<=s;l++) {
				// 양파까서 큐에 넣고 한번 밀고 다시 넣기
				Queue<Integer> que = new LinkedList<Integer>();
				for (int q = r-l; q < l*2+1; q++) { // 상단
					thisq.add(board[i][q]);
				}
				for (int q = i + 1; q < n - i; q++) { // 우측
					thisq.add(board[q][m - i - 1]);
				}
				for (int q = m - i - 2; q >= i; q--) { // 하단
					thisq.add(board[n - i - 1][q]);
				}
				for (int q = n - i - 2; q > i; q--) { // 상단
					thisq.add(board[q][i]);
				}
				
				
			}
			
			
		}
		
		
	}
}
