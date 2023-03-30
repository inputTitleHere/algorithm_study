package baekjoon.gold.four;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

// java 11 : 180ms
// java  8 : 140ms
public class Main_4485_백승윤 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// 그냥 다익스트라입니다.
		StringBuilder sb = new StringBuilder();
		int problemCounter = 0;
		while (true) {
			problemCounter++;
			int n = read();
			if (n == 0) {
				break;
			}
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = read();
				}
			}

			boolean[][] visited = new boolean[n][n];
			int[][] dist = new int[n][n];

			Arrays.fill(dist[0], Integer.MAX_VALUE);
			for (int i = 1; i < n; i++) {
				System.arraycopy(dist[0], 0, dist[i], 0, n);
			}

			dist[0][0] = map[0][0];
			visited[0][0] = true;
			// to, distance
			PriorityQueue<Tile> pq = new PriorityQueue<>();
			for (int z = 1; z <= 2; z++) {
				int ny = dir[z][0];
				int nx = dir[z][1];
				int sumdist = dist[0][0] + map[ny][nx];
				if (dist[ny][nx] > sumdist) {
					pq.add(new Tile(ny, nx, dist[0][0] + map[ny][nx]));
					dist[ny][nx] = sumdist;
				}
			}

			while (!pq.isEmpty()) {
				Tile t = pq.poll();
				visited[t.y][t.x] = true;

				for (int i = 0; i < 4; i++) {
					int ny = t.y + dir[i][0];
					int nx = t.x + dir[i][1];
					if (ny > -1 && ny < n && nx > -1 && nx < n && !visited[ny][nx]) {
						int sumdist = map[ny][nx] + dist[t.y][t.x];
						if (sumdist < dist[ny][nx]) {
							dist[ny][nx] = sumdist;
							pq.add(new Tile(ny, nx, sumdist));
						}
					}
				}
			}
			sb.append("Problem ").append(problemCounter).append(": ").append(dist[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static class Tile implements Comparable<Tile> {
		int x;
		int y;
		int dist;

		public Tile(int toy, int tox, int dist) {
			this.x = tox;
			this.y = toy;
			this.dist = dist;
		}

		@Override
		public int compareTo(Tile o) {
			return this.dist - o.dist;
		}
	}

	private static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}
}
