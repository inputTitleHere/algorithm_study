package baekjoon.gold.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_백승윤2 {
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
			// 공격 대상 찾기 -> 궁수 거리 내 성에서 가까운거에 왼쪽
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < m; j++) {
					if (localBoard[i][j] == 1) { // 적임
						for(int ii=0;ii<3;ii++) {
							if(atk[ii]==null) {
								int dist = Math.abs(n-i) + Math.abs(archer[ii]-j);
								if(dist <= d) {
									atk[ii]=new int[] {i,j};
								}
							}
						}
					}
				}
			}
			
			
			for (int[] target : atk) {
				if (target == null)
					continue;
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
