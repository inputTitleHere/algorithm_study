package baekjoon.gold.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2293 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int[] coins = new int[n];
		int[] dp = new int[k+1];
		for(int i=0;i<n;i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}
		dp[0]=1;
		for(int i=0;i<n;i++) {
			for(int j = coins[i];j<=k;j++) {
				dp[j]=dp[j-coins[i]]+dp[j];
			}
		}
		System.out.println(dp[k]);
	}
}
