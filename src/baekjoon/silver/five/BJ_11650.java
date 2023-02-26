package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		
		PriorityQueue<Integer>[] pql = new PriorityQueue[200001];
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken())+100000;
			int y = Integer.parseInt(stk.nextToken());
			
			PriorityQueue<Integer> pq = pql[x];
			if(pq==null) {
				pql[x]=new PriorityQueue<Integer>();
				pql[x].add(y);
			}else {
				pq.add(y);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<200001;i++) {
			PriorityQueue<Integer> pq = pql[i];
			if(pq!=null) {
				int tmp=i-100000;
				while(!pq.isEmpty()) {
					sb.append(tmp).append(" ").append(pq.poll()).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
