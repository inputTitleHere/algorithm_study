package inflearn._10ten;

import java.util.*;
public class Inf10_05 {
	static int[] coin;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		coin=new int[n];
		for(int i=0;i<n;i++) coin[i]=sc.nextInt();
		int m = sc.nextInt();
		dp = new int[m+1];
		Arrays.sort(coin);
		
		dp[coin[0]]=1;
		
		int mc = coin[n-1]; // maxCoin
		
		for(int i=coin[0];i<=m;i++) {
			// rfind min in range(max coin) add subtract of pos;
			int min = Integer.MAX_VALUE;
			for(int c=n-1;c>=0;c--) {
				if(i<coin[c]) continue;
				min=Math.min(min,dp[i-coin[c]]);
			}
			dp[i]=min+1;
		}
		System.out.println(dp[m]);
	}
}


