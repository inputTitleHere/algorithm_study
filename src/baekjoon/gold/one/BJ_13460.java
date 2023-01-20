package baekjoon.gold.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13460 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { -1, 0, 1, 0 };

	static Pos r,b,o;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken()); // 행
		int m = Integer.parseInt(stk.nextToken()); // 열
		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String next = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = next.charAt(j);
				board[i][j] = c;
				if (c == 'R' || c == 'O' || c == 'B') {
					if (c == 'R')
						r = new Pos(j, i);
					if (c == 'B')
						b = new Pos(j, i);
					if (c == 'O')
						o = new Pos(j, i);
				}
			}
		}
		// 최대 탐색 횟수는 10회. 넘어가면 -1

	}

	public static void move(char[][] board) {
		for (int i = 0; i < 4; i++) {
			int dirx = dx[i];
			int diry = dy[i];
			// 4방 확인 
			if(board[r.y+diry][r.x+dirx]=='.') {
				
			}
			
			
		}
	}
}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}