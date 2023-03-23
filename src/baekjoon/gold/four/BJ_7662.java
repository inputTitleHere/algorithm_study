package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_7662 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		PriorityQueue<int[]> ascpq = new PriorityQueue<>((l1,l2)->{
			return Integer.compare(l1[0], l2[0]);
		});
		PriorityQueue<int[]> descpq = new PriorityQueue<>((l1,l2)->{
			return  Integer.compare(l2[0], l1[0]);
		});
		
		for(int tc=0;tc<t;tc++) {
			ascpq.clear();
			descpq.clear();
			int k = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[k];
			
			for(int i=0;i<k;i++) {
				stk = new StringTokenizer(br.readLine());
				char order = stk.nextToken().charAt(0);
				int input = Integer.parseInt(stk.nextToken());
				
				if(order=='I') {
					ascpq.add(new int[] {input,i});
					descpq.add(new int[] {input,i});
				}else { // order == 'D'
					if(input==-1) { // 작은거 뽑기
						while(true) {
							int[] next = ascpq.poll();
							if(next==null) {
								break;
							}
							if(!visited[next[1]]) {
								visited[next[1]]=true;
								break;
							}
						}
					}else { // input == 1 // 큰거 뽑기
						while(true) {
							int[] next = descpq.poll();
							if(next==null) {
								break;
							}
							if(!visited[next[1]]) {
								visited[next[1]]=true;
								break;
							}
						}
					}
				}
			}
			while(!ascpq.isEmpty()) {
				int[] next = ascpq.peek();
				if(visited[next[1]]) {
					ascpq.poll();
				}else {
					break;
				}
			}
			while(!descpq.isEmpty()) {
				int[] next = descpq.peek();
				if(visited[next[1]]) {
					descpq.poll();
				}else {
					break;
				}
			}
			
			if(ascpq.isEmpty() || descpq.isEmpty()) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(descpq.poll()[0]).append(" ").append(ascpq.poll()[0]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
