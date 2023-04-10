package baekjoon.gold.one;

import java.io.*;
import java.util.*;

public class Main_2042_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());

		// tree init
		int depth = 0;
		while (1 << depth < n) {
			depth++;
		}
		long[] tree = new long[1 << (depth + 1)]; // make depth+1
		int start = 1 << depth;

		for (int i = 0; i < n; i++) { // fill leaf nodes
			tree[start + i] = Long.parseLong(br.readLine());
		}

		// tree init - get local sums
		for (int i = start - 1; i > 0; i--) { // 0은 비어있다.
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
//		System.out.println(Arrays.toString(tree));
		// do simul

		int action = m + k;
		while (action > 0) {
			stk = new StringTokenizer(br.readLine());
			int option = Integer.parseInt(stk.nextToken());
			if (option == 1) { // replace bth->c
				int pos = Integer.parseInt(stk.nextToken()) + start - 1;
				long to = Long.parseLong(stk.nextToken());
				tree[pos] = to;
				while (pos > 1) {
					pos >>= 1;
					tree[pos] = tree[pos << 1] + tree[(pos << 1) + 1];
				}
			} else { // print b~c sum
				long sum = 0L;
				int from = Integer.parseInt(stk.nextToken()) + start - 1;
				int to = Integer.parseInt(stk.nextToken()) + start - 1;

				while (from < to) {
					if (from % 2 == 1) { // 시작이 우측노드이면
						sum += tree[from];
					}
					if (to % 2 == 0) { // 끝 노드가 좌측 노드이면
						sum += tree[to];
					}
					from = (from + 1) >> 1;
					to = (to - 1) >> 1;
				}
				if (from == to) {
					sum += tree[from]; // 하나만 추가.
				}
				sb.append(sum).append("\n");
			}
			action--;
		}
		System.out.println(sb.toString());
	}
}
