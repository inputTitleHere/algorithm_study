package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_4803 {

	static int[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = null;
		int tc = 1;
		while (!"0 0".equals(s = br.readLine())) {
			StringTokenizer stk = new StringTokenizer(s);
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());

			boolean[][] tree = new boolean[n + 1][n + 1];
			boolean[] visited = new boolean[n + 1];
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				tree[from][to] = true;
				tree[to][from] = true;
			}

			int count = 0;
			Queue<Integer> que = new ArrayDeque<>();
			for (int i = 1; i < n + 1; i++) {
				if (!visited[i]) {
					boolean isTree = true;
					que.add(i);
					boolean[] bfs = new boolean[n + 1];
					bfs[i] = true;
					visited[i] = true;

					while (!que.isEmpty()) {
						int nxt = que.poll();
						for (int j = 1; j <= n; j++) {
							if (tree[nxt][j]) { // 갈수 있으면
								tree[nxt][j] = tree[j][nxt] = false;
								if (visited[j]) { // 이미 방문한 적 있는 노드면
									isTree = false;
								} else { // 방문한적 없으면
									visited[j] = true;
									que.add(j);
								}
							}
						}
					}
					if (isTree) {
						count++;
					}
				}
			}
			sb.append("Case ").append(tc++).append(": ");
			if (count == 0) {
				sb.append("No trees.\n");
			} else if (count == 1) {
				sb.append("There is one tree.\n");
			} else {
				sb.append("A forest of ").append(count).append(" trees.\n");
			}
		}
		System.out.println(sb.toString());
	}
}
