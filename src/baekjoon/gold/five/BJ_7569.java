package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		int h = Integer.parseInt(stk.nextToken());

		int[][][] box = new int[n][m][h];
		boolean[][][] visited = new boolean[n][m][h];
		int unripe = 0;

		Queue<int[]> que = new ArrayDeque<int[]>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				stk = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int next = Integer.parseInt(stk.nextToken());
					box[j][k][i] = next;
					if (next == 0) {
						unripe++;
					}
					if (next == 1) {
						que.add(new int[] { j, k, i, 0 }); // 세로,가로,높이,날짜
						visited[j][k][i] = true;
					}
				}
			}
		}
		int max = 0;
		int[][] dir = { { 0, 0, 1 }, { 0, 0, -1 }, { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 } };
		while (!que.isEmpty()) {
			int[] next = que.poll();
			max = Math.max(next[3], max);
			for(int i=0;i<6;i++) {
				int ny=next[0]+dir[i][0];
				int nx=next[1]+dir[i][1];
				int nz=next[2]+dir[i][2];
				
				try {
					if(box[ny][nx][nz]==0) {
						box[ny][nx][nz]=1;
						unripe--;
						que.add(new int[] {ny,nx,nz,next[3]+1});
					}
					
				}catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		if(unripe!=0) {
			System.out.println(-1);
		}else {
			System.out.println(max);
		}
	}
}
