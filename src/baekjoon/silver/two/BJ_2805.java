package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805 {
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		int[] trees = new int[n];
		stk = new StringTokenizer(br.readLine());
		int max=0;
		for(int i=0;i<n;i++) {
			trees[i]=Integer.parseInt(stk.nextToken());
			if(trees[i]>max) {
				max=trees[i];
			}
		}
		int l=0;
		int r=max+1;
		int height;
		
		while(l<r) {
			height=(l+r)/2;
			long sum=0;
			for(int i=0;i<n;i++) {
				if(height<trees[i]) {
					sum+=trees[i]-height;
				}
			}
			if(sum<m) {
				r=height;
			}else {
				l=height+1;
			}
		}
		System.out.println(l-1);
	}
}
