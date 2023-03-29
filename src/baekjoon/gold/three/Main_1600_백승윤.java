package baekjoon.gold.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_백승윤 {

	static int[][] map;
	static int w;
	static int h;
	static boolean[][][] visited;

	static int[][] monkey = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 4방이동
	static int[][] horse = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } // 말이동
	};

	// 핵심은 특정 점프 횟수를 기록해서 횟수가 같은 경우에만 visited 처리. 다른 점프 횟수면 다른 방문으로 처리.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int k = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		w = Integer.parseInt(stk.nextToken());
		h = Integer.parseInt(stk.nextToken());

		map = new int[h][w];
		visited = new boolean[h][w][k + 1];
		visited[0][0][k] = true;
		int finalDist = Integer.MAX_VALUE;
		for (int i = 0; i < h; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { 0, 0, 0, k });
		while (!que.isEmpty()) {
			int[] next = que.poll();
//			System.out.println(Arrays.toString(next));
			int y = next[0];
			int x = next[1];
			int dist = next[2];
			int jump = next[3];
			if (jump < 0) {
				continue;
			}
			if (y == h - 1 && x == w - 1) {
				finalDist = Math.min(dist, finalDist);
			}

			for (int[] iarr : monkey) {
				int ny = iarr[0] + y;
				int nx = iarr[1] + x;

				if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == 1) {
					continue;
				}

				if (!visited[ny][nx][jump]) {
					visited[ny][nx][jump] = true;
					que.add(new int[] { ny, nx, dist + 1, jump });
				}
			}

			if (jump > 0) {
				for (int[] iarr : horse) {
					int ny = iarr[0] + y;
					int nx = iarr[1] + x;
					if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == 1) {
						continue;
					}

					if (!visited[ny][nx][jump - 1]) {
						visited[ny][nx][jump - 1] = true;
						que.add(new int[] { ny, nx, dist + 1, jump - 1 });
					}
				}
			}
		}

		if (finalDist == Integer.MAX_VALUE) {
			finalDist = -1;
		}
		System.out.println(finalDist);
	}
}
