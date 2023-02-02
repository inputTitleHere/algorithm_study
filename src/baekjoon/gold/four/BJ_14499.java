package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int y = Integer.parseInt(stk.nextToken());// current x
		int x = Integer.parseInt(stk.nextToken());// current y
		int k = Integer.parseInt(stk.nextToken());

		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			String next = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = next.charAt(j * 2) - '0';
			}
		}

		int[][] dice = new int[4][3];
		int[] dirx = { 1, -1, 0, 0 };
		int[] diry = { 0, 0, -1, 1 };

		String orders = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			int move = orders.charAt(i * 2) - '0';

			int nx = x + dirx[move-1];
			int ny = y + diry[move-1];
			if (nx >= m || nx < 0 || ny >= n || ny < 0) {
				continue;
			}
			x = nx;
			y = ny;
			rotateDice(dice, move);
			if (board[y][x]==0) { // 이동칸 0이면, 
				board[y][x] = getBottom(dice);
			}else {
				setBottom(dice, board[y][x]);
				board[y][x]=0;
			}
			sb.append(getTop(dice)).append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	public static void rotateDice(int[][] dice, int dir) {
		int temp = 0;
		switch (dir) {
		case 1: // 동
			temp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = temp;
			break;
		case 2: // 서
			temp = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = temp;
			break;
		case 3: // 북
			temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
			break;
		case 4: // 남
			temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
			break;
		}
	}

	public static int getTop(int[][] dice) {
		return dice[1][1];
	}

	public static int getBottom(int[][] dice) {
		return dice[3][1];
	}

	public static void setBottom(int[][] dice, int number) {
		dice[3][1] = number;
	}
}
