package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_백승윤 {
	
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int limit;
	static int maxTaste;
	static int[][] ingred;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		for(int t=1;t<=20;t++) {
			int tc = Integer.parseInt(br.readLine());
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			limit = Integer.parseInt(stk.nextToken());
			maxTaste=0;
			ingred = new int[n][];
			for(int i=0;i<n;i++) {
				stk = new StringTokenizer(br.readLine());
				ingred[i]=new int[] {Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())};
			}
			dfs(0,0,0);
			sb.append("#").append(t).append(" ").append(maxTaste).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int step,int weight,int taste) {
		if(weight>limit) {
			return;
		}
		if(step==n) {
			maxTaste = Math.max(taste, maxTaste);
			return;
		}
		for(int i=step;i<n;i++) {
			dfs(step+1,weight+ingred[i][1], taste+ingred[i][0]);
			dfs(step+1,weight,taste);
		}
	}
	
	
}
