package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_백승윤 {
	static int[][] map;
	static int[][] dp;
	static boolean[] visited;
	static int n;
	static int mindist=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		visited[1]=true;
		dfs(1,1,0,1);
//		for(int i=0;i<n;i++) {
//			visited[i]=true;
//			visited[i]=false;
//		}
		System.out.println(mindist);
		
	}
	
	static void dfs(int start,int c,int dist,int step) {
		if(step==n) {
			if(map[c][start]==0) {
				return;
			}
			mindist=Math.min(mindist,dist+map[c][start]);
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i] && map[c][i]!=0) {
				visited[i]=true;
				dfs(start,i,dist+map[c][i],step+1);
				visited[i]=false;
			}
		}
	}
}
