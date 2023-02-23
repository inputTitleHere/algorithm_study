package baekjoon.silver.one;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;


// Java 11 : 148ms
// Java  8 : 108ms
public class Main_1697_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int su = Integer.parseInt(stk.nextToken());
		int sis = Integer.parseInt(stk.nextToken());

		boolean[] visited = new boolean[100_001]; // 방문여부 체크. 이미 방문된 것이면 아마 더 짧은 거리서 방문할 것임
		Queue<Pos> que = new ArrayDeque<>();
		que.add(new Pos(su, 0));
		while (!que.isEmpty()) {
			Pos p = que.poll();
			if (p.num == sis) {
				System.out.println(p.move);
				break;
			}
			if (p.num > 0 && !visited[p.num - 1]) {
				visited[p.num - 1] = true;
				que.add(new Pos(p.num - 1, p.move + 1));
			}
			if (p.num < 100_000 && !visited[p.num + 1]) {
				visited[p.num + 1] = true;
				que.add(new Pos(p.num + 1, p.move + 1));
			}
			int pd = p.num * 2;
			if (pd <= 100_000 && !visited[pd]) {
				visited[pd] = true;
				que.add(new Pos(pd, p.move + 1));
			}
		}
	}

	private static class Pos {
		int num;
		int move;

		public Pos(int num, int move) {
			super();
			this.num = num;
			this.move = move;
		}
	}
}
