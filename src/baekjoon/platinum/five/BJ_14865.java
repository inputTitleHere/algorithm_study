package baekjoon.platinum.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_14865 { // TODO
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		// 방향 구하기
		int[][] dots = new int[n][2];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			dots[i][0] = x;
			dots[i][1] = y;
		}
		List<int[]> mtlist = new ArrayList<>();
		int mtno = 0;

		for (int i = 0; i < n; i++) {
			if (dots[i][1] < 0 && dots[(i + 1) % n][1] > 0) { // 적절한 간선 나올 때 까지 찾기
				for (int j = 0; j < n; j++) { // i를 시작점으로 두고 n개 탐색. -> 좌측 아래 to 위가 시작이라고 한다.
					if (dots[i][1] < 0 && dots[(i + 1) % n][1] > 0) { // 좌측
						mtlist.add(new int[] { dots[i][0], mtno / 2 });
						mtno++;
					}
					if (dots[i][1] > 0 && dots[(i + 1) % n][1] < 0) { // 우측변
						mtlist.add(new int[] { dots[i][0], mtno / 2 });
						mtno++;
					}
					i = (i + 1) % n;
				}
				break;
			}
		}
		mtlist.sort((int[] l1, int[] l2)->{
			return l1[0]-l2[0];
		});
		
		
		// 정렬했으니 앞에서부터 탐색
		int outer = 0;
		int inner = 0;
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < mtlist.size(); i++) {
			int[] next = mtlist.get(i);
			if (stack.isEmpty()) {
				outer++;
				stack.push(next);
			} else {
				if (stack.peek()[1] == next[1]) {
					stack.pop();
					if (mtlist.get(i - 1)[1] == next[1]) {
						inner++;
					}
				} else {
					stack.push(next);
				}
			}
		}
		System.out.printf("%d %d\n", outer, inner);
	}
}
