package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 보드 크기
		char[][] board = new char[n][n];
		int k = Integer.parseInt(br.readLine()); // 사과 개수
		StringTokenizer stk;
		for (int i = 0; i < k; i++) {
			stk = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(stk.nextToken()) - 1; // 1행 1열부터 시작하는듯
			int x = Integer.parseInt(stk.nextToken()) - 1; // 1행 1ㅇ렬부터 시작하는 듯.
			board[y][x] = 'A';
		}
		int l = Integer.parseInt(br.readLine());
		Moves[] moves = new Moves[l];
		for (int i = 0; i < l; i++) {
			stk = new StringTokenizer(br.readLine());
			moves[i] = new Moves(Integer.parseInt(stk.nextToken()), stk.nextToken().charAt(0));
		}

		int second = 0;
		int posx = 0;
		int posy = 0;
		board[posy][posx] = 'S';
		int cdir = 1; // 0(북),1(동),2(남),3(서)
		int[] dirx = { 0, 1, 0, -1 };
		int[] diry = { -1, 0, 1, 0 };
		int movesPtr = 0;
		Queue<Pos> snake = new LinkedList<>();
		snake.add(new Pos(posx, posy));
		while (true) {
			// 1초 지남
			second++;
			// 이동하고 & 판 내부 확인
			posx += dirx[cdir];
			posy += diry[cdir];
			if (posx < 0 || posx >= n || posy < 0 || posy >= n) {
				break;
			}
			// 사과나 꼬리 이동 처리
			char c = board[posy][posx];
			if (c == 'A') { // 사과임
				board[posy][posx] = 'S';
				snake.offer(new Pos(posx, posy));
			} else if (c == 'S') { // 꼬리 만남
				break;
			} else { // 빈 공간
				board[posy][posx] = 'S';
				snake.offer(new Pos(posx, posy));
				Pos prev = snake.poll();
				board[prev.y][prev.x] = ' ';
			}
			// 방향바꾸기
			if (movesPtr < moves.length && moves[movesPtr].x == second) {
				Moves m = moves[movesPtr++];
				if (m.c == 'L') {
					if (cdir == 0) {
						cdir = 3;
					} else {
						cdir--;
					}
				} else { // m.c='D'
					if (cdir == 3) {
						cdir = 0;
					} else {
						cdir++;
					}
				}
			} // 방향 끝
		}
		System.out.println(second);
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

class Moves {
	int x;
	char c;

	public Moves(int x, char c) {
		this.x = x;
		this.c = c;
	}
}
