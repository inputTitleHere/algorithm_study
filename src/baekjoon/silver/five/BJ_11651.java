package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11651 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((l,r)-> {
			if(l[1]==r[1]) {
				return l[0]-r[0];
			}
			return l[1]-r[1];
		});
		StringTokenizer stk;

		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			pq.add(new int[] {x,y});
		}
		StringBuilder sb= new StringBuilder();
		while(!pq.isEmpty()) {
			int[] next = pq.poll();
			sb.append(next[0]).append(" ").append(next[1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
