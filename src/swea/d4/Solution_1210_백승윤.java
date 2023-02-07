package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			br.readLine(); // TC는 이미 앞에서 관리함.
			char[][] board = new char[100][100];
			StringTokenizer stk;
			for (int i = 0; i < 100; i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					board[i][j]=stk.nextToken().charAt(0);
				}
				
			}
			// 2에서 시작 -> 역탐색?
			int x = 0;
			for (char c : board[99]) {
				if (c == '2')
					break;
				else
					x++;
			}
			// 역탐색
			int y = 99;
			while (y > -1) {
				if (1 < x && x < 99) {
					if (board[y][x - 1] == '1') {
						x = move(board, true, x, y);
					} else if (board[y][x + 1] == '1') {
						x = move(board, false, x, y);
					}
					y--;
				} else if (x == 0) {
					if (board[y][x + 1] == '1') {
						x = move(board, false, x, y);
					}
					y--;
				} else { // x==99
					if (board[y][x - 1] == '1') {
						x = move(board, true, x, y);
					}
					y--;
				}
			}
			sb.append("#").append(t).append(" ").append(x).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int move(char[][] board, boolean isLeft, int x, int y) {
		if (isLeft) {
			while (x > 0 && board[y][x - 1] == '1') {
				x--;
			}
		} else {
			while (x < 99 && board[y][x + 1] == '1') {
				x++;
			}
		}
		return x;
	}
}
