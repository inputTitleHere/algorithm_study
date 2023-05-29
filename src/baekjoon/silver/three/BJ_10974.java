package baekjoon.silver.three;

import java.io.*;
import java.util.Arrays;

public class BJ_10974 {
	
	static StringBuilder sb = new StringBuilder();
	static boolean[] used;
	static int[] selected;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		used = new boolean[n+1];
		selected = new int[n];
		dfs(0);
		System.out.println(sb.toString());
	}
	
	static void dfs(int step) {
		if(step==n) {
			Arrays.stream(selected).forEach((i)->sb.append(i).append(" "));
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			if(used[i]) {
				continue;
			}
			selected[step]=i;
			used[i]=true;
			dfs(step+1);
			used[i]=false;
		}
	}
}
