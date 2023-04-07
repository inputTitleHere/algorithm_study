package swea.d3;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_5607_백승윤 {
	static long[] fact;
	static int ptr = 1;
	static final int MAGIC = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		fact = new long[1000001];
		fact[0] = 1;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			sb.append("#").append(t).append(" ");
			StringTokenizer stk = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());

			long res = ncr(n,r);
			

			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	static long ncr(int n, int r) {
		if (r == 0) {
			return 1L;
		}
		for (int i = ptr; i <= n; i++, ptr++) {
			fact[i] = fact[i - 1] * i % MAGIC;
		}

		return (fact[n] * power(fact[r], MAGIC - 2) % MAGIC * power(fact[n - r], MAGIC - 2) % MAGIC) % MAGIC;
	}

	static long power(long x, long y) {
		long res = 1L;

		x = x % MAGIC;
		while (y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % MAGIC;
			}
			y >>= 1;
			x = (x * x) % MAGIC;
		}
		return res;
	}

}
