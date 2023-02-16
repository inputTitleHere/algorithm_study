package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 166ms
public class Solution_5215_백승윤 {
	
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int limit;
	static int maxTaste;
	static int[][] ingred;
	
	static int counter=0;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			limit = Integer.parseInt(stk.nextToken());
			maxTaste=0;
			ingred = new int[n][];
			for(int i=0;i<n;i++) {
				stk = new StringTokenizer(br.readLine());
				// 맛 0, 칼로리 1
				ingred[i]=new int[] {Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())};
			}
			dfs(0,0,0);
			sb.append("#").append(t).append(" ").append(maxTaste).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int step,int calorie,int taste) {
		if(calorie>=limit) {
			return;
		}
		if(step==n) {
			maxTaste = Math.max(taste, maxTaste);
			return;
		}
		dfs(step+1,calorie+ingred[step][1], taste+ingred[step][0]);
		dfs(step+1,calorie,taste);
	}
}
