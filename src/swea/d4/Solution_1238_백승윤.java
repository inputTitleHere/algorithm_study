package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_백승윤 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		// BFS -> 유향 그래프 -> 같은 순위이면 가장 큰 번호.
		// test case = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(stk.nextToken())/2;
			int start = Integer.parseInt(stk.nextToken());

			boolean[][] map = new boolean[101][101];
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				map[from][to]=true;
			} // 연락망 생성 끝
			
			int[] last= {start,0};
			Queue<int[]> que = new ArrayDeque<>();
			boolean[] visited = new boolean[101];
			que.add(new int[] {start,0});
			visited[start]=true;
			
			while(!que.isEmpty()) {
				int[] next = que.poll();
				if(next[1]>last[1] || next[0]>last[0]) {
					last=next;
				}
				for(int i=1;i<101;i++) {
					if(map[next[0]][i] && !visited[i]) {
						visited[i]=true;
						que.add(new int[] {i,next[1]+1});
					}
				}
			}
			sb.append(last[0]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
