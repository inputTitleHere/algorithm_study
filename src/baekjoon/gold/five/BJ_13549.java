package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());

		Queue<Node> que = new ArrayDeque<>();
		boolean[] visited = new boolean[100_001];
		que.add(new Node(n, 0));
		while (!que.isEmpty()) {
			Node node = que.poll();
			if (node.pos == k) {
				System.out.println(node.time);
				return;
			}

			if (node.pos <= 50_000) {
				int next = node.pos * 2;
				if (!visited[next]) {
					visited[next] = true;
					que.offer(new Node(next, node.time));
				}
			}
			if (node.pos > 0) {
				int next = node.pos - 1;
				if (!visited[next]) {
					visited[next] = true;
					que.offer(new Node(next, node.time + 1));
				}
			}
			if (node.pos < 100_000) {
				int next = node.pos + 1;
				if (!visited[next]) {
					visited[next] = true;
					que.offer(new Node(next, node.time + 1));
				}
			}

		}
	}

	private static class Node {
		int pos;
		int time;

		public Node(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
}
