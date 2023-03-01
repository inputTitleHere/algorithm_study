package baekjoon.bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int aori = Integer.parseInt(stk.nextToken());
		int bori = Integer.parseInt(stk.nextToken());

		int a = aori;
		int b = bori;

		while (b > 0) {
			int t = a % b;
			a = b;
			b = t;
		}

		int gcd = a;
		int lcm = aori / a * bori;
		sb.append(gcd).append("\n").append(lcm);

		System.out.println(sb.toString());
	}
}
