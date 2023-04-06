package baekjoon.silver.four;

import java.io.*;
import java.util.*;

public class BJ_9188 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = null;
		while (!"-1".equals(s = br.readLine())) {
			StringTokenizer stk = new StringTokenizer(s);
			String l = stk.nextToken();
			String r = stk.nextToken();
			int tl = l.length() + r.length();
			char[] carr = new char[tl + r.length()];
			System.arraycopy(l.toCharArray(), 0, carr, r.length(), l.length());

			char[] rc = r.toCharArray();

			int max = 0;
			for (int i = 0; i < tl; i++) {
				int cnt=0;
				for (int j = 0; j < rc.length; j++) {
					if (carr[i+j] == rc[j]) {
						cnt++;
					}
				}
				max=Math.max(max, cnt);
			}
			max*=2;
			// GCD
			int a = tl, b = max;
			while (b != 0) {
				int c = a % b;
				a = b;
				b = c;
			}
			max/= a;
			tl /= a;

			if (max == 0 || max == tl) {
				sb.append("appx(").append(l).append(",").append(r).append(") = ").append(max / tl).append("\n");
			} else {
				sb.append("appx(").append(l).append(",").append(r).append(") = ").append(max).append("/").append(tl)
						.append("\n");
			}

		}
		System.out.println(sb.toString());
	}
}
