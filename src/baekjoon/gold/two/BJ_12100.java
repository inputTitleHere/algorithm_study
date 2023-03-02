package baekjoon.gold.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_12100 {
	static int n;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int gmax = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		// 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록.
		move(board, 0);
		System.out.println(gmax);
	}

	// step은 0부터 시작
	// 이거 사용
	static void move(int[][] board, int step) {
		if (step == 5) {
			gmax = Math.max(gmax, getMax(board));
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			if (moveable(board, dir)) {
				int[][] copy = copyBoard(board);
				simulate(copy, dir); // 이동 시뮬
				move(copy, step + 1); // 다음 이동 탐색
			}
		}
	}

	static void simulate(int[][] board, int direction) {

		Stack<Grid> stack = new Stack<>();

		switch (direction) {
		case 0: // 위로 합치기
			for (int j = 0; j < n; j++) { // 열고정
				for (int i = 0; i < n; i++) { // 행 옮기기
					if (stack.isEmpty()) {
						Grid g = new Grid(board[i][j], false);
						stack.push(g);
					} else {
						Grid p = stack.peek();
						if (!p.merged && p.number == board[i][j]) { // 같으며 합친적이 없는 경우
							p = stack.pop();
							p.number += board[i][j];
							p.merged = true;
							stack.add(p);
						} else {
							Grid g = new Grid(board[i][j], false);
							stack.push(g);
						}
					}
				} // 방향 합치기 END
				for (int i = 0; i < n; i++) { // 갱신하기
					if (!stack.isEmpty()) {
						board[i][j] = stack.pop().number;
					} else {
						board[i][j] = 0;
					}
				}
			}
			break;
		case 1: // 우로 합치기
			for (int i = 0; i < n; i++) { // 열고정
				for (int j = 0; j < n; j++) { // 행 옮기기
					if (stack.isEmpty()) {
						Grid g = new Grid(board[i][j], false);
						stack.push(g);
					} else {
						Grid p = stack.peek();
						if (!p.merged && p.number == board[i][j]) { // 같으며 합친적이 없는 경우
							p = stack.pop();
							p.number += board[i][j];
							p.merged = true;
							stack.add(p);
						} else {
							Grid g = new Grid(board[i][j], false);
							stack.push(g);
						}
					}
				} // 방향 합치기 END
				for (int j = 0; j < n; j++) { // 갱신하기
					if (!stack.isEmpty()) {
						board[i][j] = stack.pop().number;
					} else {
						board[i][j] = 0;
					}
				}
			}
			break;
		case 2: // 아래로 합치기 // TODO
			for (int j = 0; j < n; j++) { // 열고정
				for (int i = n - 1; i > -1; i--) { // 행 옮기기
					if (stack.isEmpty()) {
						Grid g = new Grid(board[i][j], false);
						stack.push(g);
					} else {
						Grid p = stack.peek();
						if (!p.merged && p.number == board[i][j]) { // 같으며 합친적이 없는 경우
							p = stack.pop();
							p.number += board[i][j];
							p.merged = true;
							stack.add(p);
						} else {
							Grid g = new Grid(board[i][j], false);
							stack.push(g);
						}
					}
				} // 방향 합치기 END
				for (int i = n - 1; i > -1; i--) { // 갱신하기
					if (!stack.isEmpty()) {
						board[i][j] = stack.pop().number;
					} else {
						board[i][j] = 0;
					}
				}
			}
			break;
		case 3: // 좌로 합치기 // TODO
			for (int i = 0; i < n; i++) { // 열고정
				for (int j = n - 1; j > -1; j--) { // 행 옮기기
					if (stack.isEmpty()) {
						Grid g = new Grid(board[i][j], false);
						stack.push(g);
					} else {
						Grid p = stack.peek();
						if (!p.merged && p.number == board[i][j]) { // 같으며 합친적이 없는 경우
							p = stack.pop();
							p.number += board[i][j];
							p.merged = true;
							stack.add(p);
						} else {
							Grid g = new Grid(board[i][j], false);
							stack.push(g);
						}
					}
				} // 방향 합치기 END
				for (int j = n - 1; j > -1; j--) { // 갱신하기
					if (!stack.isEmpty()) {
						board[i][j] = stack.pop().number;
					} else {
						board[i][j] = 0;
					}
				}
			}
			break;
		}
	}

	private static class Grid {
		int number;
		boolean merged;

		public Grid(int number, boolean merged) {
			this.number = number;
			this.merged = merged;
		}
	}

	static int[][] copyBoard(int[][] board) {
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(board[i], 0, tmp[i], 0, n);
		}
		return tmp;
	}

	static int getMax(int[][] board) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] > max) {
					max = board[i][j];
				}
			}
		}
		return max;
	}

	static boolean moveable(int[][] board, int dir) {
		switch (dir) {
		case 0: // 위
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == board[i - 1][j] || board[i - 1][j] == 0) {
						return true;
					}
				}
			}
			break;
		case 1: // 우
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (board[i][j] == board[i][j + 1] || board[i][j + 1] == 0) {
						return true;
					}
				}
			}
			break;
		case 2: // 아래
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == board[i + 1][j] || board[i + 1][j] == 0) {
						return true;
					}
				}
			}
			break;
		case 3: // 좌
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (board[i][j] == board[i][j - 1] || board[i][j - 1] == 0) {
						return true;
					}
				}
			}
			break;
		}
		return false;
	}
}
