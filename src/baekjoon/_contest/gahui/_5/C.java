package baekjoon._contest.gahui._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		StringBuilder sb = new StringBuilder();

		int max = 0;
		int order = 0;
		for (int i = 0; i < m; i++) {
			int dist = Integer.parseInt(br.readLine());
			sb.append("U ").append(dist+1).append(" ").append(++max).append("\n");
			sb.append("P\n");
			order += 2;
		}
		StringBuilder res = new StringBuilder();
		res.append(order).append("\n").append(sb.toString());
		System.out.println(res.toString());
	}
}
