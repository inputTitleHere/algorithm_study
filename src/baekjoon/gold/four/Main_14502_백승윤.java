package baekjoon.gold.four;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main_14502_백승윤 {

	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] used = new int[3][2];
	static int n;
	static int m;
	static List<int[]> zeros;
	static List<int[]> virus;
	static int[][] map;
	static int maxRoom = 0;

	public static void main(String[] args) throws IOException {
		n = read();
		m = read();
		map = new int[n][m];
		zeros = new ArrayList<>();
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int next = read();
				map[i][j] = next;
				if (next == 0) {
					zeros.add(new int[] { i, j });
				} else if (next == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		dfs(0, 0);
		System.out.println(maxRoom);

	}

	static void dfs(int curr, int step) {
		if (step == 3) {
			simul();
			return;
		}
		if (curr == zeros.size()) {
			return;
		}

		// 사용함
		used[step] = zeros.get(curr);
		dfs(curr + 1, step + 1);
		// 사용 안함
		dfs(curr + 1, step);
	}

	private static void simul() {

		int[][] localmap = copy(map);

		for (int[] iarr : used) {
			localmap[iarr[0]][iarr[1]] = 1;
		}
//		simul
		int remain = zeros.size()-3; // 3개 벽 새움
		for (int[] vp : virus) {
			Queue<int[]> que = new ArrayDeque<int[]>();
			que.add(vp);
			while (!que.isEmpty()) {
				int[] next = que.poll();
				for (int[] d : dir) {
					int ny = next[0] + d[0];
					int nx = next[1] + d[1];

					if (ny >= 0 && ny < n && nx >= 0 && nx < m && localmap[ny][nx] == 0) {
						localmap[ny][nx] = 2;
						remain--;
						que.add(new int[] { ny, nx });
					}
				}
			}
		}
		maxRoom = Math.max(remain, maxRoom);
	}

	private static int[][] copy(int[][] map) {
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, m);
		}
		return copy;
	}

	// 어디서 줏어온 코드
	private static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}
}
