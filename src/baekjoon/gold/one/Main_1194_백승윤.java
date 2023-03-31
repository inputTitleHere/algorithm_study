package baekjoon.gold.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		char[][] map = new char[n][m];
		boolean[][][] visited = new boolean[n][m][1 << 6];
		int[] zero = null;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = s.charAt(j);
				map[i][j] = c;
				if (c == '0') {
					zero = new int[] { i, j };
					map[i][j] = '.';
				}
			}
		}

		Queue<Tile> que = new ArrayDeque<>();
		que.add(new Tile(0, zero[0], zero[1], 0));
		while (!que.isEmpty()) {
			Tile t = que.poll();

			if (map[t.y][t.x] == '1') {
				System.out.println(t.dist);
				return;
			}

			for (int[] d : dir) {
				int ny = t.y + d[0];
				int nx = t.x + d[1];

				if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != '#' && !visited[ny][nx][t.key]) {
					char c = map[ny][nx];
					if ('a' <= c && c <= 'f') {
						int newkey = t.key | (1 << (c - 'a'));
						visited[ny][nx][t.key] = true;
						visited[ny][nx][newkey] = true;
						que.add(new Tile(newkey, ny, nx, t.dist + 1));
					} else if ('A' <= c && c <= 'F') {
						int offset = c - 'A';
						visited[ny][nx][t.key] = true;
						if ((t.key & (1 << offset)) != 0) {
							que.add(new Tile(t.key, ny, nx, t.dist + 1));
						}
					} else {
						visited[ny][nx][t.key] = true;
						que.add(new Tile(t.key, ny, nx, t.dist + 1));
					}
				}
			}
		}
		System.out.println(-1);
		return;
	}

	private static class Tile {
		// FEDCBA
		// 543210
		int key;
		int y;
		int x;
		int dist;

		public Tile(int key, int y, int x, int dist) {
			this.key = key;
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}
