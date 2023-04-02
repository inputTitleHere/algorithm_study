package baekjoon.platinum.four;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BJ_12094 {
	static int max;
	static int n;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] merged;
	static final int STEP = 10;
	// 백트래킹 조건 -> 이동 전후로 변화가 없을 때

	public static void main(String[] args) throws IOException {
		n = read();
		int[][][] board = new int[STEP+1][n][n];
		merged = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int next = read();
				board[0][i][j] = next;
				max = Math.max(max, next);
			}
		}
		// 한방향으로 이동했을 때 결합된게 아무것도 없으면 반대방향으로는 가지 않는다.
		dfs(board, 1, -1);
		System.out.println(max);

	}

//	static void print(int[][][] board, int step) {
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			System.out.print("[");
//			for(int j=0;j<n;j++) {
//				System.out.printf(" %4d,",board[step][i][j]);
//			}
//			System.out.println("]");
//		}
//	}
	static void getMax(int[][][] board, int step) {
		int local = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (local < board[step][i][j]) {
					local = board[step][i][j];
				}
			}
		}
		max = Math.max(local, max);
	}

	static void dfs(int[][][] board, int step, int axisLimit) {
		if (step > STEP) {
//			print(board,step-1);
			int local = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					local = Math.max(local, board[step-1][i][j]);
				}
			}
			max = Math.max(local, max);
			return;
		}
		boolean didMove = false;
		for (int d = 0; d < 4; d++) {
			if (d % 2 == axisLimit % 2) { // 연산 안할 축이면
				// 0,2는 세로축, 1,3은 가로축
				continue;
			}
			copy(board, step);
			boolean[] stats = move(board, d, step);
			didMove |= stats[0];

			if (!stats[0]) { // 이동조차 안했으면
				continue;
			}
			if (!stats[1]) { // 특정 축으로 이동은 했는데 합쳐진건 없는 경우 -> 같은 축은 재연산 안하기
				dfs(board, step + 1, d);
			} else {
				// 그외 모든 방향 가능함.
				dfs(board, step + 1, -1);
			}
		}
		if (!didMove) {
			getMax(board, step);
		}
	}

	private static boolean[] move(int[][][] board, int direction, int step) {
		boolean[] stats = new boolean[2]; // 0은 이동여부, 1은 합체여부.
		if (direction == 0) {
			for (int j = 0; j < n; j++) {
				int k = 0;
				for (int i = 1; i < n; i++) {
					if (board[step][i][j] != 0) {
						if (board[step][k][j] == 0) {
							board[step][k][j] = board[step][i][j];
							board[step][i][j] = 0;
							stats[0] = true;
						} else if (board[step][i][j] == board[step][k][j]) {
							board[step][i][j] = 0;
							board[step][k][j] <<= 1;
							k++;
							stats[0] = stats[1] = true;
						} else {
							int n = board[step][i][j];
							board[step][i][j] = 0;
							board[step][++k][j] = n;
						}
					} // END if
				}
			}
		} else if (direction == 1) {
			for (int i = 0; i < n; i++) {
				int k = n - 1;
				for (int j = n - 2; j >= 0; j--) {
					if (board[step][i][j] != 0) {
						if (board[step][i][k] == 0) { // 대상지점이 0인 경우
							board[step][i][k] = board[step][i][j];
							board[step][i][j] = 0;
							stats[0] = true;
						} else if (board[step][i][j] == board[step][i][k]) { // 대상지점이 merge가능하면
							board[step][i][j] = 0;
							board[step][i][k] <<= 1;
							k--;
							stats[0] = stats[1] = true;
						} else { // merge불가하면
							int n = board[step][i][j];
							board[step][i][j] = 0;
							board[step][i][--k] = n;
						}
					} // END if
				}
			}
		} else if (direction == 2) { // 아래로
			for (int j = 0; j < n; j++) {
				int k = n - 1;
				for (int i = n - 2; i >= 0; i--) {
					if (board[step][i][j] != 0) {
						if (board[step][k][j] == 0) {
							board[step][k][j] = board[step][i][j];
							board[step][i][j] = 0;
							stats[0] = true;
						} else if (board[step][i][j] == board[step][k][j]) {
							board[step][i][j] = 0;
							board[step][k][j] <<= 1;
							k--;
							stats[0] = stats[1] = true;
						} else {
							int n = board[step][i][j];
							board[step][i][j] = 0;
							board[step][--k][j] = n;
						}
					} // END if
				}
			}
		} else { // if direction==3;
			for (int i = 0; i < n; i++) {
				int k = 0;
				for (int j = 1; j < n; j++) {
					if (board[step][i][j] != 0) {
						if (board[step][i][k] == 0) { // 대상지점이 0인 경우
							board[step][i][k] = board[step][i][j];
							board[step][i][j] = 0;
							stats[0] = true;
						} else if (board[step][i][j] == board[step][i][k]) { // 대상지점이 merge가능하면
							board[step][i][j] = 0;
							board[step][i][k] <<= 1;
							k++;
							stats[0] = stats[1] = true;
						} else { // merge불가하면
							int n = board[step][i][j];
							board[step][i][j] = 0;
							board[step][i][++k] = n;
						}
					} // END if
				}
			}
		}
		return stats;
	}

	private static void copy(int[][][] ori, int step) {
		int prev = step-1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ori[step][i][j]=ori[prev][i][j];
			}
		}
	}

	private static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}

}
