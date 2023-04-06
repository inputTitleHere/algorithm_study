package baekjoon.gold.one;

import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class Main_2098_백승윤 {
	static final int INF = Integer.MAX_VALUE / 10;
	static int[][] map;
	static int[][] dp;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		map = new int[n][n];
		dp = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		dp[0] = fastFill(dp[0], -1);
		for (int i = 1; i < n; i++) {
			System.arraycopy(dp[0], 0, dp[i], 0, 1 << n);
		}

		int min = tsp(1, 0);
		System.out.println(min);
	}

	static int tsp(int vis, int currCity) {
		if (vis == ((1 << n) - 1)) { // 모든 정점을 방문했으면 집가야죠. 돌아갑시다.
			if (map[currCity][0] == 0) { // 여기선 집 못가요
				return INF;
			}
			return map[currCity][0]; // 집가요 집가
		}

		if (dp[currCity][vis] != -1) { // 방문정보와 일치한 채로 어떤 도시에 간 적이 있다면 -> DP
			return dp[currCity][vis];
		}

		// 방문하기
		dp[currCity][vis] = INF; // 방문패턴과 현재 도시를 최대치로 일단 초기화
		for (int i = 0; i < n; i++) {
			if ((vis & (1 << i)) != 0 || map[currCity][i] == 0) { // 이미 전에 방문한 도시면 OR 갈수 없으면 -> 컨티뉴
				continue;
			}
			int res = tsp(vis | (1 << i), i) + map[currCity][i]; // 지금 도시까지의 거리 + 다음 도시까지의 거리
			dp[currCity][vis] = Math.min(res, dp[currCity][vis]);
		}
		return dp[currCity][vis];
	}

	static int[] fastFill(int[] arr, int with) {
		int len = arr.length;
		arr[0] = with;

		int ptr = 1;
		while (ptr < len) {
			System.arraycopy(arr, 0, arr, ptr, ptr << 1 < len ? ptr : len - ptr);
			ptr <<= 1;
		}
		return arr;
	}

}
