package baekjoon.silver.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_15652 {

	static int[] select;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		select = new int[m];
		dfs(1, 0);
		System.out.println(sb.toString());

	}

	static void dfs(int curr, int step) {
		if (step == m) {
			for (int i : select) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=curr;i<=n;i++) {
			select[step]=i;
			dfs(i,step+1);
		}
	}
}
