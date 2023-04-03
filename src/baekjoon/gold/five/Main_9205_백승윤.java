package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int t = Integer.parseInt(br.readLine());
		MAIN: for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] pos = new int[n + 2][2];
			for (int i = 0; i < n + 2; i++) {
				stk = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(stk.nextToken());
				pos[i][1] = Integer.parseInt(stk.nextToken());
			}
			boolean[] vis = new boolean[n + 2];
			Queue<Integer> que = new ArrayDeque<>();
			que.add(0);
			vis[0] = true;
			while (!que.isEmpty()) {
				int next = que.poll();
				if (next == n + 1) {
					sb.append("happy").append("\n");
					continue MAIN;
				}
				for (int i = 0; i < n + 2; i++) {
					if (!vis[i]) {
						if (Math.abs(pos[next][0] - pos[i][0]) + Math.abs(pos[next][1] - pos[i][1]) <= 1000) {
							vis[i] = true;
							que.add(i);
						}
					}
				}
			}
			sb.append("sad").append("\n");
		}
		System.out.println(sb.toString());
	}
}
