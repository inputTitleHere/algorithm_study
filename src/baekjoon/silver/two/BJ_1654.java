package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		int[] lan = new int[k];
		int maxlen = 0;
		for (int i = 0; i < k; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			maxlen = Integer.max(maxlen, lan[i]);
		}

		long l = 0;
		long r = maxlen+1L;
		long mid = 0;
		while (l < r) {
			mid = (l + r) / 2;
			int cnt = 0;
			for (int i : lan) {
				cnt += i / mid;
			}
			if (cnt < n) {
				r = mid;
			} else {
				l = mid+1;
			} 
		}
		System.out.println(l-1);
	}
}
