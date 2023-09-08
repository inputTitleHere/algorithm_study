package baekjoon.silver.one;

import java.io.*;
import java.util.*;

public class BJ_1325 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		List<List<Integer>> map = new ArrayList<>(n+1);
		for(int i=0;i<=n;i++) {
			map.add(new ArrayList<>(i));
		}
		
		for(int i=0;i<m;i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			// a trusts b
			map.get(b).add(a);
		}
		
		Queue<Integer> printQue = new ArrayDeque<>();
		Queue<Integer> que = new ArrayDeque<>();
		int max = 0;
		
		// search
		for(int i=1;i<=n;i++) {
			que = new ArrayDeque<>();
			que.add(i);
			int counter=0;
			boolean[] vis = new boolean[n+1];
			vis[i]=true;
			while(!que.isEmpty()) {
				int next = que.poll();
				for(int nx : map.get(next)) {
					if(!vis[nx]) {
						que.add(nx);
						vis[nx]=true;
						counter++;
					}
				}
			}
			if(counter>max) {
				printQue=new ArrayDeque<>();
				printQue.add(i);
				max=counter;
			}else if(counter == max) {
				printQue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : printQue) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	
}
