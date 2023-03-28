package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2579 {
	
	static int[] stair;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stair = new int[301];
		dp=new int[306];
		for(int i=1;i<=n;i++) {
			stair[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=stair[1];
		dp[2]=stair[2]+dp[1];
		for(int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]);
		}	
		System.out.println(dp[n]);
	}
}
