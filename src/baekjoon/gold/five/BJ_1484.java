package baekjoon.gold.five;

import java.io.*;

public class BJ_1484 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long r = 2L;
		long l = 1L;
		while (l < r) {
			long rs = r * r;
			long ls = l * l;
			long diff = rs - ls;
			if (diff == w) {
				sb.append(r).append("\n");
				r++;
			} else if (diff > w) {
				l++;
			} else {
				r++;
			}
		}
		if(sb.length()==0) {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}
