package baekjoon.bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16396 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		boolean[] mark = new boolean[10001];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken())-1;

			for (int k = from; k <= to; k++) {
				mark[k] = true;
			}
		}
		int sum = 0;

		for (int i = 1; i < 10001; i++) {
			if (mark[i]) {
				sum++;
			} 
		}
		System.out.println(sum);
	}
}
