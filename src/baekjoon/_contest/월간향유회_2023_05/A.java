package baekjoon._contest.월간향유회_2023_05;

import java.io.*;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		long n = Long.parseLong(stk.nextToken());
		long r = Long.parseLong(stk.nextToken());
		long m = 0L;
		// 약수에 대해서 +R한 값들?
		long sub = n - r;
		int sqrt = (int) Math.ceil(Math.sqrt(n)) + 1;
		for (long i = r; i < sqrt; i++) {
			if (sub % i == 0 && n % i == r) {
				m+=i;
				long oppo = sub/i;
				if(n%oppo==r) {
					m+=oppo;
				}
			}
		}
		System.out.println(m);
	}
}
