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
		List<int[]> list = new ArrayList<>();

		int[][] point = new int[n][];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			point[i] = new int[] { x, y };
		}

		
		
		
//		for(int[] iar : list) {
//			System.out.println(Arrays.toString(iar));
//		}

		int outer = 0;
		int inner = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1)[1] == list.get(i)[1]) {
				inner++;
			}
		}

		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			if (stack.isEmpty()) {
				outer++;
				stack.add(list.get(i));
			} else {
				if (stack.peek()[1] == list.get(i)[1]) {
					stack.pop();
				} else {
					stack.add(list.get(i));
				}
			}
		}
		System.out.printf("%d %d\n", outer, inner);
	}
	private static class MT{
		int from;
		int to;
		public MT(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}
