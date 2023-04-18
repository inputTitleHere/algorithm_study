package baekjoon.silver.two;

import java.io.*;
import java.util.*;

public class BJ_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());

		Queue<Move> que = new ArrayDeque<>();
		que.add(new Move(a, 1));
		while (!que.isEmpty()) {
			Move next = que.poll();
			if (next.num == b) {
				System.out.println(next.move);
				return;
			}
			if(next.num>b) {
				continue;
			}

			long tmp = next.num << 1;
			que.add(new Move(tmp, next.move + 1));
			tmp = next.num * 10 + 1;
			que.add(new Move(tmp, next.move + 1));

		}
		System.out.println(-1);
		return;

	}

	private static class Move {
		long num;
		int move;

		public Move(long num, int move) {
			this.num = num;
			this.move = move;
		}

	}
}
