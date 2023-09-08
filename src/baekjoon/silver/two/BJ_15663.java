package baekjoon.silver.two;

import java.io.*;
import java.util.*;

public class BJ_15663 {

	static int n;
	static int m;
	static int[] narr;
	static int[] build;
	static boolean[] used;
	static int prev = -1;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		sb = new StringBuilder();
		stk = new StringTokenizer(br.readLine());
		int[] tmparr = new int[n];
		used = new boolean[n];
		build = new int[m];
		for (int i = 0; i < n; i++) {
			tmparr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(tmparr);
		narr = tmparr;
		tmparr = null;
		dfs(0);
		System.out.println(sb.toString());
	}

	static void dfs(int step) {
		if (step == m) {
			sb.append(print());
			return;
		}
		for(int i=0;i<n;i++) {
			if(used[i]) {
				continue;
			}
			if(narr[i]!=prev) {
				build[step]=narr[i];
				prev=-1;
				used[i]=true;
				dfs(step+1);
				used[i]=false;
			}
			prev=narr[i];
		}
	}

	static String print() {
		StringBuilder sblocal = new StringBuilder();
		for (int i = 0; i < m - 1; i++) {
			sblocal.append(build[i]).append(" ");
		}
		sblocal.append(build[m-1]).append("\n");
		return sblocal.toString();
	}

}
