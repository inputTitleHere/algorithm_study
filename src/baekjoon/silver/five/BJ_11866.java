package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> que = new ArrayDeque<Integer>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		for(int i=1;i<n+1;i++) {
			que.offer(i);
		}
		while(que.size()>1) {
			for(int i=0;i<k-1;i++) {
				que.offer(que.poll());
			}
			
			sb.append(que.poll()).append(", ");
		}
		sb.append(que.poll()).append(">");
		System.out.println(sb.toString());
	}
}
