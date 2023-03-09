package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		
		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		Queue<int[]> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][m];
		que.add(new int[] { 0, 0, 1 });
		visited[0][0]=true;
		while (!que.isEmpty()) {
			int[] next = que.poll();
			map[next[0]][next[1]]=2;
			
			if(next[0]==n-1 && next[1]==m-1) {
				System.out.println(next[2]);
				break;
			}
			
			for(int d=0;d<4;d++) {
				int ny = next[0]+dir[d][0];
				int nx = next[1]+dir[d][1];
				
				if(ny>-1 && ny<n && nx>-1 && nx<m && map[ny][nx]==1 && !visited[ny][nx]) {
					visited[ny][nx]=true;
					que.add(new int[] {ny,nx,next[2]+1});
				}
			}
		}
	}
}
