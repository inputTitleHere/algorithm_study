package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int[][] cheese = new int[n][m];
		int remain = 0;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int cell = Integer.parseInt(stk.nextToken());
				cheese[i][j] = cell;
				if(cell==1) {
					remain++;
				}
			}
		}
		int snapshot = remain;

		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int step=0;
		while(remain>0) {
			snapshot=remain;
			step++;
			Queue<Grid> que = new ArrayDeque<>();
			boolean[][] visited = new boolean[n][m];
			que.add(new Grid(0, 0));
			while(!que.isEmpty()) {
				Grid g = que.poll();
				
				for(int[] d : dir) {
					int y = g.y+d[0];
					int x = g.x+d[1];
					
					if(y>=0 && y<n && x>=0 && x<m && !visited[y][x] &&cheese[y][x]<2) {
						visited[y][x]=true;
						if(cheese[y][x]==1) {
							cheese[y][x]=0;
							remain--;
						}else {
							que.add(new Grid(y,x));
						}
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(step).append("\n").append(snapshot);
		System.out.println(sb.toString());
		

	}
	private static class Grid{
		int y;
		int x;
		public Grid(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
