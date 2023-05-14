package baekjoon.gold.three;

import java.io.*;
import java.util.*;

public class BJ_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = read();
		int m = read();

		int[] inDegree = new int[n + 1];
		List<List<Integer>> graph = new ArrayList<>(n + 1);
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int front = read();
			int back = read();
			inDegree[back]++;
			graph.get(front).add(back);
		}
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> que = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0) {
				que.add(i);
				sb.append(i).append(" ");
			}
		}
		while(!que.isEmpty()) {
			int next = que.poll();
			for(int i : graph.get(next)) {
				inDegree[i]--;
				if(inDegree[i]==0) {
					sb.append(i).append(" ");
					que.add(i);
				}
			}
		}
		System.out.println(sb.toString());
	}
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}
}
