package baekjoon.gold.two;

import java.io.*;
import java.util.*;

public class BJ_1103 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int global = 0;
	static boolean[][] visited;
	static int[][] map;
	static int[][] track;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		map = new int[n][m];
		track = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if(ch[j]=='H') {
					map[i][j]=-1;
				}else {
					map[i][j] = ch[j] - '0';					
				}
			}
		}

		visited = new boolean[n][m];
		visited[0][0] = true;
		if (dfs(0, 0, 1)) {
			System.out.println(-1);
		} else {
			System.out.println(global);
		}

	}

	public static boolean dfs(int y, int x, int step) {
		global = Math.max(global, step);
//		System.out.println("curr pos = ("+y+", "+x+") => "+map[y][x]+" step = "+step);
		int jump = map[y][x];
		for (int i = 0; i < 4; i++) {
			int ny = y + jump * dir[i][0];
			int nx = x + jump * dir[i][1];

			if (ny > -1 && ny < n && nx > -1 && nx < m && map[ny][nx]!=-1 && step > track[ny][nx]) {
				if(visited[ny][nx]) {
					return true;
				}
				track[ny][nx]=step;
				visited[ny][nx]=true;
				if(dfs(ny,nx,step+1)) {
					return true;
				}
				visited[ny][nx]=false;
			}
		}
		return false;
	}

}
