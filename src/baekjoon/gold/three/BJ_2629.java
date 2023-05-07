package baekjoon.gold.three;

import java.io.*;
import java.util.*;

public class BJ_2629 {

	static boolean[][] dp;
	static int[] weights;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		weights = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(stk.nextToken());
		}

		dp = new boolean[31][40001];
		StringBuilder sb = new StringBuilder();
		build(0, 0);
//		System.out.println(Arrays.toString(dp));

		m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int marble = Integer.parseInt(stk.nextToken());
			if (dp[n][marble]) {
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}
		System.out.println(sb.toString());
	}

	static void build(int step, int weight) {
		if (dp[step][weight]) {
			return;
		}
		
		dp[step][weight] = true;
		if(step == n) {
			return;
		}
		// 추를 왼편에
		build(step + 1, weight + weights[step]);
		// 추를 오른편에
		build(step + 1, Math.abs(weight - weights[step]));
		// 안씀
		build(step + 1, weight);
	}

}
