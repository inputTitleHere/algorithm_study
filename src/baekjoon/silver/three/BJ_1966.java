package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1966 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int q = Integer.parseInt(stk.nextToken());
			LinkedList<int[]> que = new LinkedList<>();
			stk = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				que.add(new int[] {Integer.parseInt(stk.nextToken()),i});
			}
			int cnt=0;
			MAIN : while(true) {
				int[] next = que.pop(); 
				
				for(int[] iarr : que) {
					if(iarr[0]>next[0]) {
						que.add(next);
						continue MAIN;
					}
				}
				cnt++;
				if(next[1]==q) {
					break;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
