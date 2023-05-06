package baekjoon.gold.four;

import java.io.*;

public class BJ_2133 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		dp[0]=1;
		dp[1]=0;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-2]*3;
			int k = i-4;
			while(k>=0) {
				dp[i]+=dp[k]*2;
				k-=2;
			}
		}
		System.out.println(dp[n]);
	}
}
