package baekjoon.gold.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Java 11 : 132ms
// Java  8 : 232ms ㅋㅋㅋ 버전업하면서 pq가 효율이 달라진듯
public class Main_16236_백승윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		// up,left,right,down
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		int[][] ocean = new int[n][n];

		// {y,x,weight}
		int[] shark = { 0, 0 };
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ocean[i][j] = Integer.parseInt(stk.nextToken());
				if (ocean[i][j] == 9) {
					ocean[i][j] = 0;
					shark = new int[] { i, j, 2, 0 }; // y,x,weight,eatCount
				}
			}
		}

		int sec = 0;
		// BFS
		// 초기탐색
		while (true) {
			// 먹거리 찾기
			// 위, 왼, 오른, 아래 순서로 탐색
			boolean[][] vis = new boolean[n][n];
//			Queue<int[]> que = new ArrayDeque<int[]>();// y,x,dist
			PriorityQueue<int[]> que = new PriorityQueue<>((int[] a1, int[] a2) -> {
				if (a1[2] == a2[2]) { // 거리가 같으면
					// 위먼저(a[0])
					if (a1[0] == a2[0]) { // 같은 높이이면
						return a1[1] - a2[1];
					} else {
						return a1[0] - a2[0];
					}
				} else {
					return a1[2] - a2[2];
				}
			});
			que.add(new int[] { shark[0], shark[1], 0 }); // y,x,dist
//			System.out.println("start shark "+Arrays.toString(shark));
			boolean ateFish = false;
			while (!que.isEmpty()) {
				int[] pos = que.poll();
//				System.out.println(Arrays.toString(pos));
				if (ocean[pos[0]][pos[1]] != 0 && ocean[pos[0]][pos[1]] < shark[2]) {
//					System.out.println("++++++++++++++++++++++++++++++");
//					System.out.printf(
//							"Ate fish at (%d, %d) dist %2d || fish weight = %d prev shark weight = %d prev eatcount = %d\n",
//							pos[0], pos[1], pos[2], ocean[pos[0]][pos[1]], shark[2], shark[3]);
					ocean[pos[0]][pos[1]] = 0;
					sec += pos[2];
					shark[0] = pos[0];
					shark[1] = pos[1];
					shark[3]++;
					if (shark[3] == shark[2]) {
						shark[2]++;
						shark[3] = 0;
					}
//					print(ocean);
//					System.out.printf(
//							"Ate fish at (%d, %d) dist %2d || fish weight = %d post shark weight = %d post eatcount = %d\n",
//							pos[0], pos[1], pos[2], ocean[pos[0]][pos[1]], shark[2], shark[3]);
					ateFish = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int ny = pos[0] + dir[i][0];
					int nx = pos[1] + dir[i][1];

					if (ny > -1 && ny < n && nx > -1 && nx < n && !vis[ny][nx] && ocean[ny][nx] <= shark[2]) {
						vis[ny][nx] = true;
						que.add(new int[] { ny, nx, pos[2] + 1 });
					}
				}
			}
			if (!ateFish) {
				break;
			}
		} // END while
		System.out.println(sec);
	}

	static void print(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
