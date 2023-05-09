package baekjoon.gold.two;


import java.io.*;
import java.util.*;

public class BJ_1938 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 방문체크 세로, 가로, 방향
		boolean[][][] visited = new boolean[n][n][2];

		// 초기위치 찾기
		int[][] bpos = new int[3][2];
		int bp = 0;
		int[][] epos = new int[3][2];
		int ep = 0;
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] nextline = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				char next = nextline[j];
				if (next == '0') {
					map[i][j] = 0;
				} else if (next == '1') {
					map[i][j] = 1;
				} else if (next == 'B') {
					bpos[bp][0] = i; // y위치
					bpos[bp][1] = j; // x위치
					bp++;
					map[i][j] = 0;
				} else if (next == 'E') {
					epos[ep][0] = i;
					epos[ep][1] = j;
					ep++;
					map[i][j] = 0;
				}

			}
		}
		Pos target;
		if (epos[0][0] == epos[1][0]) { // x축상이면
			target = new Pos(1, epos[1][0], epos[1][1], 0);
		} else {
			target = new Pos(0, epos[1][0], epos[1][1], 0);
		}

		Pos center;
		if (bpos[0][0] == bpos[1][0]) { // x축상이면
			center = new Pos(1, bpos[1][0], bpos[1][1], 0);
		} else {
			center = new Pos(0, bpos[1][0], bpos[1][1], 0);
		}

		// BFS 탐색
		Queue<Pos> que = new ArrayDeque<>();
		que.add(center);
		visited[center.y][center.x][center.dir] = true;
		MAIN: while (!que.isEmpty()) {
			Pos next = que.poll();
//			System.out.println(next);
			// 타겟을 찾았으면 step 출력하고 끝내기
			if (next.x == target.x && next.y == target.y && next.dir == target.dir) {
//				System.out.println(">> " + target);
				System.out.println(next.step);
				return;
			}
			// 위로 이동
			int nexty = next.y - 1;
			if (next.dir == 1) { // 가로로 배치되었을 때
				if (next.y > 0 && !visited[nexty][next.x][next.dir] && map[nexty][next.x - 1] != 1
						&& map[nexty][next.x] != 1 && map[nexty][next.x + 1] != 1) {
					visited[nexty][next.x][next.dir] = true;
					que.add(new Pos(next.dir, nexty, next.x, next.step + 1));
				}
			} else { // 세로로 배치된 상태
				if (next.y > 1 && !visited[nexty][next.x][next.dir] && map[next.y - 2][next.x] != 1) {
					visited[nexty][next.x][next.dir] = true;
					que.add(new Pos(next.dir, nexty, next.x, next.step + 1));
				}
			}
			// 아래로 이동
			nexty = next.y + 1;
			if (next.dir == 1) { // 가로로 배치되었을 때
				if (next.y < n - 1 && !visited[nexty][next.x][next.dir] && map[nexty][next.x - 1] != 1
						&& map[nexty][next.x] != 1 && map[nexty][next.x + 1] != 1) {
					visited[nexty][next.x][next.dir] = true;
					que.add(new Pos(next.dir, nexty, next.x, next.step + 1));
				}
			} else { // 세로로 배치된 상태
				if (next.y < n - 2 && !visited[nexty][next.x][next.dir] && map[next.y + 2][next.x] != 1) {
					visited[nexty][next.x][next.dir] = true;
					que.add(new Pos(next.dir, nexty, next.x, next.step + 1));
				}
			}
			// 왼쪽으로 이동
			int nextx = next.x + 1;
			if (next.dir == 1) { // 가로로 배치되었을 때
				if (next.x < n - 2 && !visited[next.y][nextx][next.dir] && map[next.y][next.x + 2] != 1) {
					visited[next.y][nextx][next.dir] = true;
					que.add(new Pos(next.dir, next.y, nextx, next.step + 1));
				}
			} else { // 세로로 배치됨
				if (next.x < n - 1 && !visited[next.y][nextx][next.dir] && map[next.y - 1][nextx] != 1
						&& map[next.y][nextx] != 1 && map[next.y + 1][nextx] != 1) {
					visited[next.y][nextx][next.dir] = true;
					que.add(new Pos(next.dir, next.y, nextx, next.step + 1));
				}
			}

			// 오른쪽으로 이동
			nextx = next.x - 1;
			if (next.dir == 1) { // 가로로 배치되었을 때
				if (next.x > 1 && !visited[next.y][nextx][next.dir] && map[next.y][next.x - 2] != 1) {
					visited[next.y][nextx][next.dir] = true;
					que.add(new Pos(next.dir, next.y, nextx, next.step + 1));
				}
			} else { // 세로로 배치됨
				if (next.x > 0 && !visited[next.y][nextx][next.dir] && map[next.y - 1][nextx] != 1
						&& map[next.y][nextx] != 1 && map[next.y + 1][nextx] != 1) {
					visited[next.y][nextx][next.dir] = true;
					que.add(new Pos(next.dir, next.y, nextx, next.step + 1));
				}
			}
			// 회전
			if (next.y > 0 && next.y < n - 1 && next.x > 0 && next.x < n - 1 && !visited[next.y][next.x][(next.dir+1)%2]) {
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						if (map[next.y + i][next.x + j] == 1) {
							continue MAIN;
						}
					}
				}
				visited[next.y][next.x][(next.dir+1)%2]=true;
				que.add(new Pos((next.dir + 1) % 2, next.y, next.x, next.step + 1));
			}
		}
		System.out.println(0);
		return;
	}

	private static class Pos {
		int dir; // 0 == 세로, 1== 가로
		int y;
		int x;
		int step;

		public Pos(int dir, int y, int x, int step) {
			this.dir = dir;
			this.x = x;
			this.y = y;
			this.step = step;
		}

		@Override
		public String toString() {
			return "Pos [dir=" + dir + ", y=" + y + ", x=" + x + ", step=" + step + "]";
		}
	}

}
