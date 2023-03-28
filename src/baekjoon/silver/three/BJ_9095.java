package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095 {

	static int[] track;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		track = new int[12];
		track[0] = 1;
		track[1] = 1;
		track[2] = 2;
		track[3] = 4;

		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int r = dp(n);
			sb.append(r).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int dp(int n) {
		if (n < 4) {
			return track[n];
		}
		if (track[n] == 0) {
			return track[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
		} else {
			return track[n];
		}
	}
}
