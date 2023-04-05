package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_5427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			char[][] map = new char[r][c];
			Queue<Pos> fire = new ArrayDeque<>();
			Queue<Pos> sanggun = new ArrayDeque<>();
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < c; j++) {
					char ch = s.charAt(j);
					if (ch == '*') {
						fire.add(new Pos(i, j));
					} else if (ch == '@') {
						sanggun.add(new Pos(i, j));
					}
					map[i][j] = ch;
				}
			}
			int step = 0;
			int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
			ESCAPE: while (true) {
				if (sanggun.size() == 0) {
					sb.append("IMPOSSIBLE\n");
					break ESCAPE;
				}
				// move fire first
				int qs = fire.size();
				while (qs-- > 0) {
					Pos p = fire.poll();
					for (int[] iarr : dir) {
						int ny = p.y + iarr[0];
						int nx = p.x + iarr[1];
						if (ny > -1 && ny < r && nx > -1 && nx < c && (map[ny][nx] == '.' || map[ny][nx] == '@')) {
							map[ny][nx] = '*';
							fire.add(new Pos(ny, nx));
						}
					}
				}
				// then move sanggun
				qs = sanggun.size();
				while (qs-- > 0) {
					Pos p = sanggun.poll();
					for (int[] iarr : dir) {
						int ny = p.y + iarr[0];
						int nx = p.x + iarr[1];
						if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
							step++;
							sb.append(step).append("\n");
							break ESCAPE;
						}

						if (map[ny][nx] == '.') {
							map[ny][nx] = '@';
							sanggun.add(new Pos(ny, nx));
						}
					}
				}
//				print(map);
				step++;
			}
		}
		System.out.println(sb.toString());
	}

	static void print(char[][] map) {
		for (char[] carr : map) {
			System.out.println(Arrays.toString(carr));
		}
	}

	private static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
