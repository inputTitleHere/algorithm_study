package inflearn._8eight;

import java.util.*;
public class Inf08_02 {
	static int sum=0;
	static int max=0;
	static int c=0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		int n = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++) in[i]=sc.nextInt();
		// ----- // 
		load(in,0,n);
		System.out.println(max);
	}
	static void load(int[] in, int curr, int n) {
		if(sum>=c) return;
		if(sum>max) max=sum; 
		if(curr==n) return; 
		// 넣은거
		sum+=in[curr]; 
		load(in,curr+1, n); 
		// 뺀거
		sum-=in[curr];
		load(in,curr+1,n); 
	}
}
