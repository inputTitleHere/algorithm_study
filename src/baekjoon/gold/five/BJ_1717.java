package baekjoon.gold.five;

import java.io.*;
import java.util.*;

public class BJ_1717 {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		parent = new int[n+1];
		for(int i=0;i<n+1;i++) {
			parent[i]=i;
		}
		
		for(int ord=0;ord<m;ord++) {
			stk = new StringTokenizer(br.readLine());
			String action = stk.nextToken();
			int f = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			
			if("0".equals(action)) {
				union(f,t);
			}else {
				if(find(f)==find(t)) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	static int find(int x){
		if(parent[x]==x)return x;
		return parent[x]=find(parent[x]);
	}

	static void union(int a, int b){
		a=find(a);
		b=find(b);
		if(a<b) parent[b]=a;
		else parent[a]=b;
	}
}
