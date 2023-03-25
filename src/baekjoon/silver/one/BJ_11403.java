package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11403 {
	
	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer>[] list = new ArrayList[n];
		StringTokenizer stk = null;
		for(int i=0;i<n;i++) {
			list[i]=new ArrayList<Integer>();
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				String s = stk.nextToken();
				if("1".equals(s)) {
					list[i].add(j);
				}
			}
		}
		graph=list;
		
		//bfs
		for(int i=0;i<n;i++) {
			visited=new boolean[n];
			Queue<Integer> que = new ArrayDeque<Integer>();
			que.add(i);
			while(!que.isEmpty()) {
				int next = que.poll();
				for(int nxt : graph[next]) {
					if(!visited[nxt]) {
						que.add(nxt);
						visited[nxt]=true;
					}
				}
			}
			
			for(int k=0;k<n;k++) {
				int mode;
				if(visited[k]) {
					mode=1;
				}else {
					mode=0;
				}
				sb.append(mode).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
