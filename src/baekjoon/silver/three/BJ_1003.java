package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003 {
	static int zero = 0;
	static int one = 0;

	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new int[41][2];
		dp[0][0]=1;
		dp[1][1]=1;
		for(int i=0;i<tc;i++) {
			int next =Integer.parseInt(br.readLine()); 
			fibonacci(next);
			sb.append(dp[next][0]).append(" ").append(dp[next][1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] fibonacci(int n) {
		if (n == 0) {
			return dp[0];
		} else if (n == 1) {
			return dp[1];
		} else {
			if(dp[n][0]==0 && dp[n][1]==0) {
				dp[n][0]=fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
				dp[n][1]=fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
				return dp[n];
			}else {
				return dp[n];				
			}
		}
	}
}
