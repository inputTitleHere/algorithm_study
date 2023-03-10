package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= v; i++) {// v+1까지
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
// start at 1(0)
		boolean[] visited = new boolean[v+1];
		visited[1]=true;
		Queue<Integer> que = new ArrayDeque<>();
		que.add(1);
		while(!que.isEmpty()) {
			int next = que.poll();
			for(int x : list.get(next)) {
				if(!visited[x]) {
					visited[x]=true;
					que.add(x);
				}
			}
		}
		int cnt=0;
		for(boolean b : visited) {
			if(b) {
				cnt++;
			}
		}
		cnt-=1;
		System.out.println(cnt);
	}
}
