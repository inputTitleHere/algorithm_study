package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1249_백승윤 {

	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int t = 1;
		while (t <= tc) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] car = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = car[j] - '0';
				}
			}

			boolean[][] visited = new boolean[n][n];
			int[][] distance = new int[n][n];
			Arrays.fill(distance[0], Integer.MAX_VALUE);
			for(int i=1;i<n;i++) {
				System.arraycopy(distance[0], 0, distance[i], 0, n);
			}
			
			visited[0][0] = true;
			PriorityQueue<int[]> pq = new PriorityQueue<>((l1, l2) -> {
				return l1[2] - l2[2];
			});
			pq.add(new int[] {0,0,0});
			while(!pq.isEmpty()) {
				int[] next = pq.poll();
				int y = next[0];
				int x = next[1];
				
				if(y==n-1 && x==n-1) {
					break;
				}
				
				int dist = next[2];
				visited[y][x]=true;
				for(int i=0;i<4;i++) {
					int ny = y+dir[i][0];
					int nx = x+dir[i][1];
					if(ny>-1 && nx>-1 && ny<n && nx<n && !visited[ny][nx]) {
						int nd = dist + map[ny][nx];
						if(nd<distance[ny][nx]) {
							distance[ny][nx]=dist;
							pq.add(new int[] {ny,nx,nd});
						}
					}
				}
			}
			sb.append(distance[n-1][n-1]).append("\n");
			t++;
		}
		System.out.println(sb.toString());
	}
}
