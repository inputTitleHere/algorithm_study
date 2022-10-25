package inflearn._10ten;

import java.util.*;
public class Inf10_02 {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+2];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n+1;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n+1]);
	}
}
