package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// java 11 : 128ms
public class Main_1149_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];
		StringTokenizer stk = null;
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			house[i][0]=Integer.parseInt(stk.nextToken());
			house[i][1]=Integer.parseInt(stk.nextToken());
			house[i][2]=Integer.parseInt(stk.nextToken());
		}
		int[][] dp = new int[n][3];
		System.arraycopy(house[0], 0, dp[0], 0, 3);
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				int min = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])+house[i][j];
				dp[i][j]=min;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i : dp[n-1]) {
			min=Math.min(min, i);
		}
		System.out.println(min);
	}
}
