package baekjoon.bronze.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_10810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int[] arr = new int[n + 1];
		for (int z = 0; z < m; z++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int no = Integer.parseInt(stk.nextToken());
			for (int i = from; i <= to; i++) {
				arr[i] = no;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
