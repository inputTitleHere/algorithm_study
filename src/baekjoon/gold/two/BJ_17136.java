package baekjoon.gold.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17136 { // TODO

	static int[] remain = { 0, 5, 5, 5, 5, 5 };
	static int global = Integer.MAX_VALUE;

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		board = new int[10][10];
		int local = 0;
		for (int i = 0; i < 10; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				int next = Integer.parseInt(stk.nextToken());
				board[i][j] = next;
				local += next;
			}
		}
		if (local == 0) { // 다 0이면
			System.out.println(0);
			return;
		}
		dfs(0, 0);

		if (global == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(global);
		}
	}

	static void dfs(int d, int cnt) {
//		System.out.println("d : "+d +" remain = "+Arrays.toString(remain));
		if (d == 100) {
			int count = 0;
			for (int i = 1; i <= 5; i++) {
				count += (5 - remain[i]);
			}
			global = Math.min(global, count);
			return;
		}

		if (cnt > global) {
			return;
		}

		int y = d / 10;
		int x = d % 10;
		if (board[y][x] == 1) {
			// 5부터
			PLACE: for (int k = 5; k > 0; k--) {
				// 남은 색종이 & 모서리 체크
				if (remain[k] <= 0 || y + k > 10 || x + k > 10) {
					continue PLACE;
				}
				int yk = y + k;
				int xk = x + k;
				// 배치 가능한지 체크
				for (int a = y; a < yk; a++) {
					for (int b = x; b < xk; b++) {
						if (board[a][b] != 1) {
							continue PLACE;
						}
					}
				}
				// 배치 가능하면 배치하기
				remain[k]--;
				for (int a = y; a < yk; a++) {
					for (int b = x; b < xk; b++) {
						board[a][b] = k;
					}
				}
				// dfs하기
				dfs(d + k, cnt + 1);
				// 원상복구
				remain[k]++;
				for (int a = y; a < yk; a++) {
					for (int b = x; b < xk; b++) {
						board[a][b] = 1;
					}
				}
			}
		} else {
			dfs(d + 1, cnt);
		}

	}

	static int[][] copy(int[][] ori) {
		int[][] cpy = new int[10][10];
		for (int i = 0; i < 10; i++) {
			System.arraycopy(ori[i], 0, cpy[i], 0, 10);
		}
		return cpy;
	}

	static void print(int[][] board) {
		for (int[] iarr : board) {
			System.out.println(Arrays.toString(iarr));
		}
	}
}
