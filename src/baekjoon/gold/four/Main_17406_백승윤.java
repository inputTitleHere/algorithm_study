package baekjoon.gold.four;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

//java 11 : 604ms
public class Main_17406_백승윤 {

	static int[][] orders;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());

		int[][] original = new int[n][m];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				original[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		orders = new int[k][];
		for (int i = 0; i < k; i++) {
			stk = new StringTokenizer(br.readLine());
			orders[i] = new int[] { Integer.parseInt(stk.nextToken()) - 1, Integer.parseInt(stk.nextToken()) - 1,
					Integer.parseInt(stk.nextToken()) };
		}
		int min = Integer.MAX_VALUE;
		int[] ord = new int[k];
		for (int i = 0; i < k; i++) {
			ord[i] = i;
		}
		do {
			int[][] board = new int[n][m];
			for (int i = 0; i < n; i++) {
				board[i] = Arrays.copyOf(original[i], m);
			}
			for (int kt = 0; kt < k; kt++) {
				int r = orders[ord[kt]][0];
				int c = orders[ord[kt]][1];
				int s = orders[ord[kt]][2];

				for (int l = 1; l <= s; l++) {
					// 양파까서 큐에 넣고 한번 밀고 다시 넣기
					Deque<Integer> que = new LinkedList<Integer>();
					for (int q = c - l; q <= c + l; q++) { // 상단
						que.add(board[r - l][q]);
					}
					for (int q = r - l + 1; q <= r + l; q++) { // 우측
						que.add(board[q][c + l]);
					}
					for (int q = c + l - 1; q >= c - l; q--) { // 하단
						que.add(board[r + l][q]);
					}
					for (int q = r + l - 1; q >= r - l + 1; q--) { // 좌측
						que.add(board[q][c - l]);
					}
					que.addFirst(que.pollLast());

					for (int q = c - l; q <= c + l; q++) { // 상단
						board[r - l][q] = que.pollFirst();
					}
					for (int q = r - l + 1; q <= r + l; q++) { // 우측
						board[q][c + l] = que.pollFirst();
					}
					for (int q = c + l - 1; q >= c - l; q--) { // 하단
						board[r + l][q] = que.pollFirst();
					}
					for (int q = r + l - 1; q >= r - l + 1; q--) { // 좌측
						board[q][c - l] = que.pollFirst();
					}
				}
			}
			for (int[] iarr : board) {
				min = Math.min(min, Arrays.stream(iarr).sum());
			}
		} while (np(ord));

		System.out.println(min);
	}

	static boolean np(int[] ord) {
		int i = k - 1;
		while (i > 0 && ord[i - 1] >= ord[i])
			i--;

		if (i == 0)
			return false;

		int j = k - 1;
		while (ord[i - 1] >= ord[j])
			j--;
		sp(ord, i - 1, j);
		int p = k - 1;
		while (i < p) {
			sp(ord, i++, p--);
		}
		return true;
	}

	static void sp(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
