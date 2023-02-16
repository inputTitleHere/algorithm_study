package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 251ms
public class Solution_4012_백승윤 {
	static int mindif;
	static int n;
	static StringBuilder sb = new StringBuilder();
	static int[][] syn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			syn = new int[n][n];
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					syn[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			mindif = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			// 반으로 나누기 -> 종류의 절반개를 조합으로 꺼내기
			sb.append("#").append(t).append(" ").append(mindif).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int step, int count, int tracker) {
		if (count == n / 2) { // tracker 는 0~n까지.
			// 출력하기
			int asum = 0;
			int bsum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (((tracker & (1 << i)) != 0) == ((tracker & (1 << j)) != 0)) {
						if ((tracker & 1 << i) != 0) {
							asum += syn[i][j] + syn[j][i];
						} else {
							bsum += syn[i][j] + syn[j][i];
						}
					}
				}
			}
			mindif = Math.min(Math.abs(bsum - asum), mindif);
			return;
		}
		if (step == n) {
			return;
		}
		dfs(step + 1, count + 1, tracker | 1 << step);
		dfs(step + 1, count, tracker);
	}
}
