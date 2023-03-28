package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579 {
	
	static int[] stair;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stair = new int[300];
		dp=new int[306];
		for(int i=0;i<n;i++) {
			stair[i]=Integer.parseInt(br.readLine());
		}
		if(n==2) {
			System.out.println(stair[0]+stair[1]);
			return;
		}else if (n==1) {
			System.out.println(stair[0]);
			return;
		}
		for(int i=0;i<n-2;i++) {
			dp[n+]
		}
		
		
	}
	
	static int max(int... items) {
		
		
		return 0;
	}
	
}
