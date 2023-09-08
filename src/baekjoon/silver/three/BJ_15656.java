package baekjoon.silver.three;

import java.io.*;
import java.util.*;

public class BJ_15656 {
	
	static int m;
	static int n;
	static int[] narr;
	static int[] build;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		sb = new StringBuilder();
		narr = new int[n];
		build = new int[n];
		stk = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			narr[i]=Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(narr);
		dfs(0);
		System.out.println(sb.toString());
	}
	
	static void dfs(int step) {
		if(step==m) {
			sb.append(print(build));
			return;
		}
		for(int i=0;i<n;i++) {
			build[step]=narr[i];
			dfs(step+1);
		}
	}
	
	static String print(int[] build) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m-1;i++) {
			sb.append(build[i]).append(" ");
		}
		sb.append(build[m-1]).append("\n");
		return sb.toString();
	}
	
}
