package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070 {
	static int[][] map;
	static int cnt;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		// 모든 가짓수를 다 따진다. -> DFS
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		cnt = 0;
		dfs(1,2,0); // 우측은 (1,2)에서 시작
		System.out.println(cnt);
	}

	static void dfs(int ry, int rx, int dir) {
		if (rx == n && ry == n) {
			cnt++;
			return;
		}
		// 현제 dir에 따라 회전 가능한 방향이 다름
		if (dir == 0) { // 가로방향 -> 대각선이동하거나 가로이동
			// case : 가로이동
			moveHori(ry, rx);
			// case 대각선이동
			moveDiag(ry, rx);
		} else if (dir == 1) { // 가로상태일 때
			// 3방향 다 이동 가능
			// case : 가로이동
			moveHori(ry, rx);
			// case : 대각선이동
			moveDiag(ry, rx);
			// case : 세로 이동
			moveVert(ry, rx);
		} else { // 세로상태일때 -> 대각선이나 세로만 가능
			// case : 대각선이동
			moveDiag(ry, rx);
			// case : 세로 이동
			moveVert(ry, rx);
		}
	}

	static void moveHori(int ry, int rx) {
		int nrx = rx + 1;
		if (nrx <= n && map[ry][nrx] == 0) { // 마지막에 n을 밟아야 한다.
			dfs(ry, nrx, 0);
		}
	}

	static void moveDiag(int ry, int rx) {
		int nry = ry + 1;
		int nrx = rx + 1;
		if (nrx <= n && nry <= n && map[ry][nrx] == 0 && map[nry][rx] == 0 && map[nry][nrx] == 0) {
			dfs(nry, nrx, 1);
		}
	}

	static void moveVert(int ry, int rx) {
		int nry = ry + 1;
		if (nry <= n && map[nry][rx] == 0) {
			dfs(nry, rx, 2);
		}
	}
}
