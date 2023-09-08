package swea.b특강;

import java.util.*;
import java.io.*;

class Solution {
	static int[][] map;
	static int ans, N;
	static final int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }, dc = { 0, 0, -1, 1, 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					if (str.charAt(j) == '.')
						map[i][j] = -1; // 일반땅 -1
					else
						map[i][j] = -2; // 지뢰 2
				}
			}
			solve();
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void solve() {
		// 판 전체를 전부순회
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != -1) // 일반땅이 아니면
					continue; // 넘어가기
				if (isZero(i, j)) { // 일반땅이면 주변지뢰 확인
					click(i, j); // 주변지뢰 없으면 클릭
					ans++; // 클릭수 증가.
				}
			}
		}
		// 여기까지 왔으면 주변지뢰없는 일반 땅은 다 밟음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) // 일반땅이면 밟기*(이젠 조건없이)
					ans++;
			}
		}
	}

	private static void click(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		map[r][c] = 0;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			map[curr[0]][curr[1]] = 0;
			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != -1)
					continue;
				if (isZero(nr, nc))
					queue.add(new int[] { nr, nc });
				map[nr][nc] = 0;
			}
		}
	}

	private static boolean isZero(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == -2)
				return false;
		}
		return true;
	}

}