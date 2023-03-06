package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485 {
	// 골드 4
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException{
		StringBuilder sb =new StringBuilder();
		StringTokenizer stk;
		int problemCounter=0;
		while(true) {
			problemCounter++;
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				break;
			}
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(stk.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[n][n];
			int[][] dist = new int[n][n];
			
			Arrays.fill(dist[0], Integer.MAX_VALUE);
			for(int i=1;i<n;i++) {
				System.arraycopy(dist[0], 0, dist[i], 0, n);
			}
			
			
			dist[0][0]=map[0][0];
			visited[0][0]=true;
			// to, distance
			PriorityQueue<Tile> pq = new PriorityQueue<>();
			for(int z=1;z<=2;z++) {
				int ny = dir[z][0];
				int nx = dir[z][1];
				int sumdist = dist[0][0]+map[ny][nx];
				if(dist[ny][nx]>sumdist) {
					pq.add(new Tile(ny,nx,dist[0][0]+map[ny][nx]));
					dist[ny][nx]=sumdist;
				}
			}
			
			while(!pq.isEmpty()) {
//				System.out.println("=====================");
//				for(int[] iar : dist) {
//					System.out.println(Arrays.toString(iar));
//				}
				
				
				Tile t = pq.poll();
				visited[t.y][t.x]=true;
				
				for(int i=0;i<4;i++) {
					int ny = t.y+dir[i][0];
					int nx = t.x+dir[i][1];
					if(ny>-1&&ny<n&&nx>-1&&nx<n&&!visited[ny][nx]) {
						int sumdist = map[ny][nx]+dist[t.y][t.x];
						if(sumdist<dist[ny][nx]) {
							dist[ny][nx]=sumdist;
							pq.add(new Tile(ny,nx,sumdist));
						}
					}
				}
			}
			sb.append("Problem ").append(problemCounter).append(": ").append(dist[n-1][n-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static class Tile implements Comparable<Tile>{ 
		int x;
		int y;
		int dist;
		
		public Tile(int toy, int tox, int dist) {
			this.x = tox;
			this.y = toy;
			this.dist = dist;
		}

		@Override
		public int compareTo(Tile o) {
			return this.dist-o.dist;
		}
	}
}
