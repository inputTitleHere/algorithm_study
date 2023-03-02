package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 1418ms
public class Solution_5656_백승윤 {

	static int n;
	static int w;
	static int h;
	static int[][] map;
	// y, x
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int globalMin;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		for (int t = 1; t <= tc; t++) {
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			w = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());
			globalMin=Integer.MAX_VALUE;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			combi(new int[n],0,0);
			sb.append("#").append(t).append(" ").append(globalMin).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void simulation(int[] choice) {
//		System.out.println(Arrays.toString(choice));
		int[][] simul = new int[h][w];
		for(int i=0;i<h;i++) {
			System.arraycopy(map[i], 0, simul[i], 0, w);
		}
		
		for (int k = 0; k < n; k++) { // 구슬 던지기
			int pos = choice[k];
			int y = 0;
			while (y<h && simul[y][pos] == 0) {
				y++;
			}
			if(y==h) {
				continue;
			}
			Queue<int[]> que = new ArrayDeque<int[]>();
			que.add(new int[] { y, pos, simul[y][pos] });
			simul[y][pos]=0;
			while (!que.isEmpty()) {
				int[] next = que.poll();
				// 4방
				for(int i=1;i<next[2];i++) {
					for(int j=0;j<4;j++) {
						int ny = next[0]+dir[j][0]*i;
						int nx = next[1]+dir[j][1]*i;
						if(ny>-1 && ny < h && nx>-1 && nx<w && simul[ny][nx]!=0) {
							que.add(new int[] {ny,nx,simul[ny][nx]});
							simul[ny][nx]=0;
						}
					}
				}// 4방탐색 끝
			}
			
			// 내리기
			for(int i=h-1;i>0;i--) { // 여러칸 빈 경우를 고려해야함.
				for(int j=w-1;j>-1;j--) {
					if(simul[i][j]==0) {
						int cy = i;
						while(cy>-1 && simul[cy][j]==0) {
							cy--;
						}
						if(cy>-1) {
							simul[i][j]=simul[cy][j];
							simul[cy][j]=0;							
						}
					}
				}
			}
//			System.out.println("=========================");
//			for(int[] ui : simul) {
//				System.out.println(Arrays.toString(ui));
//			}
//			System.out.println("+++++++++++++++++++++++++");
			
			
		}// end simul
		int cnt=0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(simul[i][j]!=0) {
					cnt++;
				}
			}
		}
		globalMin = Math.min(globalMin, cnt);
	}

	static void combi(int[] choice, int step, int prev) {
		if (step == n) {
			simulation(choice);
			return;
		}

		for (int i = 0; i < w; i++) {
			choice[step] = i;
			combi(choice, step + 1, i);
		}
	}
}
