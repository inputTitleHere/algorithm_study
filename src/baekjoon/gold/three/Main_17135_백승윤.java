package baekjoon.gold.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_백승윤 {
	static int n;
	static int m;
	static int d;
	static int[][] board;
	static int[] archer = new int[3];

	static int killCount = 0;
	static int enemyCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken()); // 행
		m = Integer.parseInt(stk.nextToken()); // 열
		d = Integer.parseInt(stk.nextToken());

		int[][] tmp = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tmp[i][j] = Integer.parseInt(stk.nextToken());
				if (tmp[i][j] == 1)
					enemyCount++;
			}
		}
		board = tmp;
		dfs(0, 0);

		System.out.println(killCount);
	}

	private static void dfs(int pos, int placed) {
		if (placed == 3) {
			bfs();
			return;
		}
		if (pos == m) { // 그냥 끝
			return;
		}
		// 배치 선택
		archer[placed] = pos;
		dfs(pos + 1, placed + 1);
		dfs(pos + 1, placed);

	}
	private static void bfs() {
		int localKillCount = 0;
		int localEnemyCount = enemyCount;
		int[][] localBoard = new int[n + 1][m];
		for (int i = 0; i < n + 1; i++) {
			System.arraycopy(board[i], 0, localBoard[i], 0, m);
		}
		
		// 시뮬
		while (localEnemyCount > 0) {
			int[][] atk = new int[3][];
			int ptr = 0;
			// 공격
			for (int ar : archer) { // 궁수 위치 마다
				// 거리기반 BFS
				int[] curr = new int[] { n - 1, ar, 1 }; // 행, 열, 스텝(범위)
				Queue<int[]> que = new ArrayDeque<int[]>();
				que.add(curr);
				// 다음부터 2차원 visited를 마스킹하는 객기를 부리지 않겠습니다.
//				int visited = (1 << (n - 1)) | (1 << (ar + 16)); // 비트마스크 0~15(행), 16~31(열);
				
				boolean[][] vismap = new boolean[n][m];
				vismap[n-1][ar]=true;
				
				// 가까운것 부터, 왼쪽 부터
				while (!que.isEmpty()) {
					int[] check = que.poll();
					if (localBoard[check[0]][check[1]] == 1) { // 적 발견
						atk[ptr] = new int[] { check[0], check[1] }; // 행,열
						break;
					} else { // 적 아님 -> 아래로는 탐색할 필요 없음, 3방향만.
						if (check[2] == d) {
							continue; // 사정거리 끝이면 뻗어나가기 끝.
						}
						// 좌 
						int ly = check[0];
						int lx = check[1] - 1;
						if (lx >= 0 && !vismap[ly][lx]) { // 좌로가서 좌측만 확인
//							visited |= (1 << ly) | (1 << (lx + 16));
							vismap[ly][lx]=true;
							que.add(new int[] { ly, lx, check[2] + 1 });
						}
						// 상
						ly = check[0] - 1;
						lx = check[1];
						if (ly >= 0 && !vismap[ly][lx]) { // 위로가는거 상단만 확인
//							visited |= (1 << ly) | (1 << (lx + 16));
							vismap[ly][lx]=true;
							que.add(new int[] { ly, lx, check[2] + 1 });
						}
						// 우
						ly = check[0];
						lx = check[1] + 1;
						if (lx < m && !vismap[ly][lx]) { // 우측만 확인
//							visited |= (1 << ly) | (1 << (lx + 16));
							vismap[ly][lx]=true;
							que.add(new int[] { ly, lx, check[2] + 1 });
						}
					}
				} // END while
				ptr++; // 궁수 번호 추가.
			} // 궁수 목표 탐색 끝
			for (int[] target : atk) {
				if (target == null) {
					continue;
				}
				if (localBoard[target[0]][target[1]] == 1) { // 처음 제거할 때만
					localKillCount++;
					localEnemyCount--;
					localBoard[target[0]][target[1]] = 0; // 겹치는 것도 잡음
				}
			}
			// 이동 + 성 도착판단
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < m; j++) {
					if (localBoard[i][j] == 1) { // 아래로 옮겨주기
						localBoard[i + 1][j] = 1;
						localBoard[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				if (localBoard[n][i] == 1) {
					localEnemyCount--;
					localBoard[n][i] = 0; // 성 닿은건 없애기
				}
			}
		}
		killCount = Math.max(localKillCount, killCount);
		return;
	}
}
