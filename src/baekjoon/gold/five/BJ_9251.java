package baekjoon.gold.five;

import java.io.*;

public class BJ_9251 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] left = br.readLine().toCharArray();
		int n = left.length;
		
		char[] right = br.readLine().toCharArray();
		int m = right.length;
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(left[i]==right[j]) {
					dp[i+1][j+1] = dp[i][j]+1;
				}else {
					dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
