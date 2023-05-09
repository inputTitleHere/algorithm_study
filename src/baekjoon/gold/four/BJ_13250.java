package baekjoon.gold.four;

import java.io.*;

public class BJ_13250 {
	static double[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new double[n+1];
		dp[1]=1;
		System.out.println(search(n));
	}
	static double search(int step) {
		if(step<1) {
			return 0;
		}
		
		if(step==1) {
			return 1;
		}
		
		if(dp[step]!=0) {
			return dp[step];
		}
		// 이전 확률 + 1회 던지기.
		return dp[step]=1+(search(step-1)+search(step-2)+search(step-3)+search(step-4)+search(step-5)+search(step-6))/6;
	}
}
