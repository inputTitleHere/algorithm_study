package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1463_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] vis = new boolean[n+1];
		Queue<int[]> que = new ArrayDeque<>();
		int result =-1;
		que.add(new int[] {n,0});
		while(!que.isEmpty()) {
			int[] next = que.poll();
			if(next[0]==1) {
				result = next[1];
				break;
			}
			if(next[0]%3==0) {
				int leap = next[0]/3;
				if(!vis[leap]) {
					vis[leap]=true;
					que.add(new int[] {leap,next[1]+1});
				}
			}
			if(next[0]%2==0) {
				int leap = next[0]/2;
				if(!vis[leap]) {
					vis[leap]=true;
					que.add(new int[] {leap,next[1]+1});
				}
			}
			
			int leap = next[0]-1;
			if(!vis[leap]) {
				vis[leap]=true;
				que.add(new int[] {leap,next[1]+1});
			}
		}
		System.out.println(result);
	}
}
