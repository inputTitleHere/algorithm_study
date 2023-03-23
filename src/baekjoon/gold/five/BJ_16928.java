package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int l = Integer.parseInt(stk.nextToken());
		int s = Integer.parseInt(stk.nextToken());
		int[] map = new int[101];
		boolean[] visited = new boolean[101];
		for(int i=0;i<101;i++) {
			map[i]=i;
		}
		
		for(int i=0;i<l+s;i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			map[from]=to;
		}
		
		int pos = 1;
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.add(new int[] {1,0});
		visited[1]=true;
		while(!que.isEmpty()) {
			int[] next = que.poll();
			if(next[0]==100) {
				System.out.println(next[1]);
				return;
			}
			for(int i=1;i<=6;i++) {
				int move = next[0]+i;
				if(move>100) {
					continue;
				}
				if(visited[move]) {
					continue;
				}
				int nextPos = map[move];
				visited[move]=true;
				que.add(new int[] {nextPos,next[1]+1});
			}
		}
	}
}
