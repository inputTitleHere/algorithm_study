package swea.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_백승윤 {
	static final int MAX = 99999;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int c = -1;
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken()); 
			int[][] relation = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int rel = Integer.parseInt(stk.nextToken());
					if (rel == 0) {
						relation[i][j] = MAX;
					} else {
						relation[i][j] = rel;
					}
					if (i == j) {
						relation[i][j] = 0;
					}
				}
			} // END input
			// floyd warshall
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						relation[i][j] = Math.min(relation[i][k] + relation[k][j], relation[i][j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				min = Math.min(min, Arrays.stream(relation[i]).reduce(0, (local, i1) -> {
					if (i1 < MAX)
						return local + i1;
					else
						return local;
				}));
			}
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

}
