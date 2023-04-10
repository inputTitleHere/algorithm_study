package baekjoon.gold.three;

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class BJ_11779 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		boolean[] vis = new boolean[n + 1];
		int viscount = 0;
		int[] distance = new int[n + 1];
		int[] track = new int[n+1];
		ArrayList<Pos>[] conn = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			conn[i] = new ArrayList<>();
		}
		fastFill(distance, Integer.MAX_VALUE >> 2);

		StringTokenizer stk = null;
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());

			conn[from].add(new Pos(from,to, weight));
		}
		stk = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(stk.nextToken());
		int dest = Integer.parseInt(stk.nextToken());

		PriorityQueue<Pos> pq = new PriorityQueue<>((l, r) -> {
			return l.weight - r.weight;
		});

		vis[start] = true;
		distance[start] = 0;
		for (Pos p : conn[start]) {
			pq.add(p);
		}
		StringBuilder sb = new StringBuilder();
		if(pq.isEmpty()) {
			sb.append(distance[dest]).append("\n");
			sb.append(start).append("\n");
			sb.append(start);
			System.out.println(sb.toString());
			return;
		}
		while (!pq.isEmpty()) { // DIJK
			Pos next = pq.poll();
//			System.out.println("start -> to " + next.start+" -> "+next.to);
			if(distance[next.to]<next.weight) {
				continue;
			}
			distance[next.to] = next.weight;
			track[next.to]=next.start;
			for (Pos p : conn[next.to]) {
				if (!vis[p.to]) {
					int addweight = distance[next.to]+p.weight;
					if(distance[p.to]>addweight) {
						Pos jump = new Pos(next.to,p.to,addweight);
						pq.add(jump);
					}
				}
			}
		}
//		System.out.println(Arrays.toString(distance));
		int count =0;
		Stack<Integer> stack = new Stack<>();
		sb.append(distance[dest]).append("\n");
		int loc = dest;
		while(track[loc]!=0) {
			count++;
			stack.add(loc);
			loc=track[loc];
		}
		sb.append(count+1).append("\n");
		sb.append(start).append(" ");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}

	static class Pos {
		int start;
		int to;
		int weight;

		public Pos(int s,int t, int w) {
			this.start=s;
			this.to = t;
			this.weight = w;
		}

		@Override
		public String toString() {
			return "Pos [start=" + start + ", to=" + to + ", weight=" + weight + "]";
		}
	}

	static int[] fastFill(int[] arr, int with) {
		int len = arr.length;
		arr[0] = with;

		int ptr = 1;
		while (ptr < len) {
			System.arraycopy(arr, 0, arr, ptr, ptr << 1 < len ? ptr : len - ptr);
			ptr <<= 1;
		}
		return arr;
	}
}
