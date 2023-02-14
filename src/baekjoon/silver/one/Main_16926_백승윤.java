package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16926_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken()); // 행개수
		int m = Integer.parseInt(stk.nextToken()); // 열개수
		// min(n,m)mod 2 = 0 -> 홀수,홀수는 없음
		int r = Integer.parseInt(stk.nextToken());

		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int k = Math.min(n, m) / 2;
		List<Queue<Integer>> lines = new ArrayList<Queue<Integer>>(k);
		for (int i = 0; i < k; i++) {
			Queue<Integer> thisq = new LinkedList<>();
			for (int q = i; q < m - i; q++) { // 상단
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
			lines.add(thisq);
		}
//		System.out.println(lines);
		for (Queue<Integer> q : lines) {
			int move = r % q.size();
			for (int i = 0; i < move; i++) {
				q.offer(q.poll());
			}
		}
		// 다시 사각형 빌드하기
//		System.out.println(lines);
		for (int i = 0; i < k; i++) {
			Queue<Integer> thisq = lines.get(i);
			for (int q = i; q < m - i; q++) { // 상단
				board[i][q] = thisq.poll();
			}
			for (int q = i + 1; q < n - i; q++) { // 우측
				board[q][m - i - 1] = thisq.poll();
			}
			for (int q = m - i - 2; q >= i; q--) { // 하단
				board[n - i - 1][q] = thisq.poll();
			}
			for (int q = n - i - 2; q > i; q--) { // 상단
				board[q][i] = thisq.poll();
			}
		}
		// 출력하기
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
