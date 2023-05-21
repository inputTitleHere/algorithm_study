package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(stk.nextToken());
		boolean[] visited = new boolean[v + 1];
		int e = Integer.parseInt(stk.nextToken());

		ArrayList<Edge>[] edges = new ArrayList[v + 1];
		for (int i = 1; i < v + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			stk = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(stk.nextToken());
			int right = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());
			edges[left].add(new Edge(right, weight));
			edges[right].add(new Edge(left, weight));
		}
		
		for (Edge edge : edges[1]) {
			pq.add(edge);
		}
		visited[1]=true;
		int count = 0;
		int mst = 0;
		while (count < v && !pq.isEmpty()) {
			Edge next = pq.poll();
			if (visited[next.to]) {
				continue;
			}
			mst += next.weight;
			visited[next.to] = true;
			for (Edge eg : edges[next.to]) {
				if (!visited[eg.to]) {
					pq.add(eg);
				}
			}
			count++;
		}
		System.out.println(mst);
	}

	private static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
