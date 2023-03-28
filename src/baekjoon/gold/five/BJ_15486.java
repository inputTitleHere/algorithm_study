package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486 {

	static int[] dp;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		dp = new int[n+2];
		for(int i=1;i<=n;i++) {
			stk = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(stk.nextToken());
			int price = Integer.parseInt(stk.nextToken());
			// i = 현재일
			int endTime = i+time;
			if(endTime<=n+1) {
				dp[endTime] = Math.max(dp[i]+price, dp[endTime]);
			}
			dp[i+1]=Math.max(dp[i], dp[i+1]);
		}
		System.out.println(dp[n+1]);
	}
}
