package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1068 {
	static int cnt = 0;
	static Node[] tree = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int n = Integer.parseInt(br.readLine());

		tree = new Node[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new Node(i);
		}

		stk = new StringTokenizer(br.readLine());
		Node start = new Node(-1);
		for (int i = 0; i < n; i++) {
			int par = Integer.parseInt(stk.nextToken());
			if (par == -1) {
				start.children.add(tree[i]);
				tree[i].parent = start;
			} else {
				tree[i].parent = tree[par];
				tree[par].children.add(tree[i]);
			}
		}
		int remove = Integer.parseInt(br.readLine());
		tree[remove].parent.children.remove(tree[remove]);

		dfs(start);
		System.out.println(cnt);
	}

	static void dfs(Node current) {
		if (current.children.size() == 0) {
			if (current.number != -1) {
				cnt++;
			}
			return;
		}
		for (Node n : current.children) {
			dfs(n);
		}
	}

	private static class Node {
		public int number;
		public Node parent;
		public List<Node> children = new ArrayList<>();

		public Node(int number) {
			super();
			this.number = number;
		}

		@Override
		public boolean equals(Object obj) {
			Node n = (Node) obj;
			if (this.number == n.number) {
				return true;
			} else {
				return false;
			}
		}
	}

}
