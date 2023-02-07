package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_백승윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		// 1~n까지 m개
		StringBuilder sb = new StringBuilder();
		dfs(0, new boolean[n + 1], new int[m], n, m, sb);
		System.out.println(sb.toString());
	}

	static void dfs(int step, boolean[] used, int[] build, int n, int m, StringBuilder sb) {
		if (step == m) {
			for (int i = 0; i < m - 1; i++) {
				sb.append(build[i]).append(" ");
			}
			sb.append(build[m - 1]).append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (used[i])
				continue;
			build[step] = i;
			used[i] = true;
			dfs(step + 1, used, build, n, m, sb);
			used[i] = false;
		}
	}
}
