package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 121ms ->
public class Solution_3307_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tcase; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int[] dp = new int[n];
			int ptr = 0;
			for (int i = 0; i < n; i++) {
				int next = read(stk);
				int pos = binsearch(next, ptr, dp);
				if (pos == ptr) {
					dp[ptr++] = next;
				} else {
					dp[pos] = next;
				}
			}
			// 길이만 구하기
			sb.append("#").append(t).append(" ").append(ptr).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int read(StringTokenizer stk) {
		return Integer.parseInt(stk.nextToken());
	}

	static int binsearch(int target, int r, int[] dp) {
		int l = 0;
		while (l < r) {
			int mid = (l + r) / 2;
			if (target <= dp[mid]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}
