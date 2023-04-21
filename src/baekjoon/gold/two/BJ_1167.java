package baekjoon.gold.two;

import java.io.*;
import java.util.*;

public class BJ_1167 {

	static ArrayList<E>[] map;
	static List<Integer> leafs;
	static boolean[] visited;
	static int global = 0;
	static int farthest = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());

		map = new ArrayList[v + 1];
		visited = new boolean[v + 1];
		leafs = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			map[from] = new ArrayList<E>();
			while (true) {
				int to = Integer.parseInt(stk.nextToken());
				if (to == -1) {
					break;
				}
				int weight = Integer.parseInt(stk.nextToken());
				map[from].add(new E(to, weight)); // 데이터는 단방향인듯
			}
			if (map[from].size() == 1) {
				leafs.add(from);
			}
		}
		// 젤 먼거
		visited[1]=true;
		dfs(1,0);
		visited[1]=false;
		global=0;
		visited[farthest]=true;
		dfs(farthest,0);
		System.out.println(global);
	}

	static void dfs(int current, int weight) {

		if (map[current].size() == 1) {
			if(global<weight) {
				global = weight;
				farthest=current;
			}
		}
		for (E e : map[current]) {
			if (!visited[e.to]) {
				visited[e.to] = true;
				dfs(e.to, e.weight + weight);
				visited[e.to] = false;
			}
		}
	}

	static private class E {
		int to;
		int weight;

		public E(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
