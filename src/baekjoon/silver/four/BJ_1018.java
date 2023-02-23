package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken()); // 행
		int m = Integer.parseInt(stk.nextToken()); // 열

		char[] chkr = { 'W', 'B' };

		char[][] raw = new char[n][];
		for (int i = 0; i < n; i++) { // 입력 보드
			raw[i] = br.readLine().toCharArray();
		}
		//
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {

				CYCLE : for(int s=0;s<2;s++) {
					int localChange = 0;
					int st = s;
					for (int k = i; k < i + 8; k++) {
						for (int l = j; l < j + 8; l++) {
							if (raw[k][l] != chkr[(st++ % 2)]) {
								localChange++;
							}
							if (localChange > min) {
								continue CYCLE;
							}
						}
						st++;
					}
					min = Math.min(localChange, min);
				}
			}
		}
		System.out.println(min);
	}
}
