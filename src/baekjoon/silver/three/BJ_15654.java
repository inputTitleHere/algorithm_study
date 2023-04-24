package baekjoon.silver.three;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654 {

	static int[] select;
	static int[] option;
	static boolean[] used;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		select = new int[m];
		option = new int[n];
		used = new boolean[n];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			option[i]=Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(option);

		for (int i = 0; i < n; i++) {
			used[i]=true;
			select[0] = option[i];
			dfs(1);
			used[i]=false;
		}
		System.out.println(sb.toString());

	}

	static void dfs(int step) {
		if (step == m) {
			for (int i : select) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!used[i]) {
				used[i]=true;
				select[step] = option[i];
				dfs(step + 1);
				used[i]=false;
			}
		}
	}
}
