package baekjoon.silver.two;

import java.io.*;
import java.util.*;

public class BJ_2644 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int n = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		
		int rel= Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<rel;i++) {
			stk = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(stk.nextToken());
			int children = Integer.parseInt(stk.nextToken());
			
			arr.get(parent).add(children);
			arr.get(children).add(parent);
		}
		
		boolean[] vis=new boolean[n+1];
		Queue<Info> que = new ArrayDeque<>();
		que.add(new Info(l,0));
		vis[l]=true;
		while(!que.isEmpty()) {
			Info info = que.poll();
			vis[info.pos]=true;
			for(int next : arr.get(info.pos)) {
				if(!vis[next]) {
					if(next==r) {
						System.out.println(info.step+1);
						return;
					}
					que.add(new Info(next, info.step+1));
				}
			}
		}
		System.out.println("-1");
	}
	static class Info{
		int pos;
		int step;
		Info(int pos, int step) {
			this.pos=pos;
			this.step=step;
		}
	}
}
