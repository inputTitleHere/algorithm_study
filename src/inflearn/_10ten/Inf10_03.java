package inflearn._10ten;

import java.util.*;
public class Inf10_03 {
	
	static int[] input;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		input = new int[n];
		dp=new int[n];
		for(int i=0;i<n;i++) input[i]=sc.nextInt();
		dp[1]=1;
		for(int i=1;i<n;i++) {
			int max=1;
			for(int j=i-1;j>=0;j--) {
				if(input[j]<input[i]) {
					int step = dp[j]+1;
					max=Math.max(max, step);
				}
			}
			dp[i]=max;
		}
		int max=0;
		for(int i=0;i<n;i++) max=Math.max(max, dp[i]);
		System.out.println(max);
	}
}
