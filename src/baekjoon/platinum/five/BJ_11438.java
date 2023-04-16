package baekjoon.platinum.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11438 { // 틀림 ㅋ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] tree = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			tree[i] = i;
		}

		StringTokenizer stk = null;
		for (int i = 0; i < n - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			if (tree[r] == r) {
				tree[r] = l;
			} else {
				tree[l] = r;
			}
		}

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

//		boolean t = true;

		for (int i = 0; i < m; i++) {
//			if (t) {
//				return;
//			}
			stk = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());

			int lp = l;
			int rp = r;
			while (lp != rp) {
				if (lp < rp) {
					rp = tree[rp];
				} else { // lp > rp
					lp = tree[lp];
				}
			}
			sb.append(lp).append("\n");
		}
		System.out.println(sb.toString());
	}
}
