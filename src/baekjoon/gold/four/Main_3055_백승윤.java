package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class Main_3055_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		char[][] map = new char[r][c];
		Queue<Pos> water = new ArrayDeque<>();
		Queue<Pos> hedge = new ArrayDeque<>();
		Pos beaver = null;
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				char ch = s.charAt(j);
				if (ch == '*') {
					water.add(new Pos(i, j));
				} else if (ch == 'S') {
					hedge.add(new Pos(i, j));
				} else if (ch == 'D') {
					beaver = new Pos(i, j);
				}
				map[i][j] = ch;
			}
		}
		int step = 0;
		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		while (true) {
			if (hedge.size() == 0) {
				System.out.println("KAKTUS");
				return;
			}
			if (map[beaver.y][beaver.x] == 'S') {
				System.out.println(step);
				return;
			}
			// move water first
			int qs = water.size();
			while (qs-- > 0) {
				Pos p = water.poll();
				for (int[] iarr : dir) {
					int ny = p.y + iarr[0];
					int nx = p.x + iarr[1];
					if (ny > -1 && ny < r && nx > -1 && nx < c && (map[ny][nx] == '.' || map[ny][nx] == 'S')) {
						map[ny][nx] = '*';
						water.add(new Pos(ny, nx));
					}
				}
			}
			// then move hedgehog
			qs = hedge.size();
			while (qs-- > 0) {
				Pos p = hedge.poll();
				for (int[] iarr : dir) {
					int ny = p.y + iarr[0];
					int nx = p.x + iarr[1];
					if (ny > -1 && ny < r && nx > -1 && nx < c && (map[ny][nx] == '.' || map[ny][nx] == 'D')) {
						map[ny][nx] = 'S';
						hedge.add(new Pos(ny, nx));
					}
				}
			}
			step++;
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
