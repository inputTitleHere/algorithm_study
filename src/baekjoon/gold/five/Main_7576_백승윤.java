package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// java 11 : 604ms
public class Main_7576_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// m 가로, n 세로
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());

		int[][] tomato = new int[n][m];

		Queue<int[]> que = new ArrayDeque<int[]>();
		int green = 0;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int next = Integer.parseInt(stk.nextToken());
				if (next == 0) {
					green++;
				}
				if (next == 1) {
					que.add(new int[] { i, j, 0 }); // y,x,day
				}
				tomato[i][j] = next;
			}
		}
		if (green==0) {
			System.out.println(0);
			return;
		}

		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int maxday = 0;

		while (!que.isEmpty()) {
			int[] next = que.poll();
			maxday = Math.max(next[2], maxday);

			for (int i = 0; i < 4; i++) {
				int ny = next[0] + dir[i][0];
				int nx = next[1] + dir[i][1];

				// [판 안에 있고] [안익은 토마토이고]
				if (nx > -1 && nx < m && ny > -1 && ny < n && tomato[ny][nx] == 0) {
					que.add(new int[] { ny, nx, next[2] + 1 });
					tomato[ny][nx] = 1;
					green--;
				}
			}
		}
		if (green > 0) {
			System.out.println(-1);
		} else {
			System.out.println(maxday);
		}
	}
}
