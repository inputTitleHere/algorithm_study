package baekjoon.bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_23003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("Case #").append(tc).append(": ");
			int n = Integer.parseInt(br.readLine());
			char[] s = br.readLine().toCharArray();
			int[] len = new int[n];
			len[0] = 1;

			int length = 1;
			sb.append(1).append(" ");
			
			for (int i = 1; i < n; i++) {
				if (s[i - 1] < s[i]) {
					len[i] = ++length;
				} else {
					len[i] = length = 1;
				}
				sb.append(len[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
