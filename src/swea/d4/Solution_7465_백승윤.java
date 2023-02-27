package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_백승윤 {

	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			arr = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				arr[i] = i;
			}
			int m = Integer.parseInt(stk.nextToken());
			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());

				union(a, b);
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i < n + 1; i++) {
				int f = find(i);
				if (!set.contains(f)) {
					set.add(f);
				}
			}
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int find(int x) {
		if (x == arr[x]) {
			return x;
		} else {
			return arr[x] = find(arr[x]);
		}
	}

	static void union(int x, int y) {
		if (find(x) == find(y)) {
			return;
		}
		arr[find(y)] = find(x);
	}
}
