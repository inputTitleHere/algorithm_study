package baekjoon.gold.five;

import java.io.*;
import java.util.*;

public class BJ_2467 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] sol = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			sol[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(sol);
		int lt = 0;
		int rt = n - 1;
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		while (lt < rt) {
			int mix = sol[lt] + sol[rt];
			if (Math.abs(mix) < Math.abs(min)) {
				min = mix;
				left = sol[lt];
				right = sol[rt];
			}
			if(mix>0) {
				rt--;
			}else if(mix<0) {
				lt++;
			}else {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(left).append(" ").append(right);
		System.out.println(sb.toString());
	}
}
