package swea.d4;

import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Solution_5643_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			// 500명까지이므로 인접리스트로 하자.
			ArrayList<Integer>[] downstream = new ArrayList[n+1];
			ArrayList<Integer>[] upstream = new ArrayList[n+1];
			for(int i=0;i<=n;i++) {
				upstream[i]=new ArrayList<>();
				downstream[i]=new ArrayList<>();
			}
			StringTokenizer stk;
			
			// 정확히 알기 -> 모든 상위&하위 노드와 역행없이 연결됨
			for(int i=0;i<m;i++) {
				stk = new StringTokenizer(br.readLine());
				int smol = Integer.parseInt(stk.nextToken());
				int big = Integer.parseInt(stk.nextToken());
				
				downstream[smol].add(big);
				upstream[big].add(smol);
			}
			// 각기 점에서 2방향으로 단방향 bfs를 해서 총 방문 노드 개수가 전체-1과 같으면 전부 연결될듯
			
			int count =0;
			for(int i=1;i<=n;i++) {
				int nodes=0;
				boolean[] vis = new boolean[n+1];
				vis[i]=true;
				// upstream
				Queue<Integer> que = new ArrayDeque<>();
				que.add(i);
				while(!que.isEmpty()) {
					int next = que.poll();
					for(int k : upstream[next]) {
						if(!vis[k]) {
							vis[k]=true;
							que.add(k);
							nodes++;
						}
					}
				}
				que.clear();
				// downstream
				que.add(i);
				while(!que.isEmpty()) {
					int next = que.poll();
					for(int k :downstream[next]) {
						if(!vis[k]) {
							vis[k]=true;
							que.add(k);
							nodes++;
						}
					}
				}
				if(nodes==n-1) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
