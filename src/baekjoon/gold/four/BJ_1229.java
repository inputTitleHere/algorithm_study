package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1, 6, 15, 28, 45, 66
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		// 1 5  9 13 (+4)
		// 1 6 15 28
		List<Integer> hex = new ArrayList<>();
		
		int k=1; // +4
		int sum=1;
		while(sum<=n) {
			dp[sum]=1;
			hex.add(sum);
			k+=4;
			sum=sum+k;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j : hex) {
				int num = i+j;
				if(num>n) {
					break;
				}
				dp[num]=Math.min(dp[i]+1, dp[num]);
			}
		}
		
		
		
		int res = dp[n];
		System.out.println(res);
		
	}
}
