package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_백승윤 {
	
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			sb.append("#").append(tc).append(" ");
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			arr = new int[n+1];
			for(int i=0;i<n+1;i++) {
				arr[i]=i;
			}
			
			for(int i=0;i<m;i++) {
				stk = new StringTokenizer(br.readLine());
				char order = stk.nextToken().charAt(0);
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				if(order=='0') {
					union(a,b);
				}else {
					if(find(a)==find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int find(int x) {
		if(x==arr[x]) {
			return x;
		}else {
			return arr[x]=find(arr[x]);			
		}
	}
	static void union(int x, int y) {
		if(find(x)==find(y)) { 
			return;
		}
		arr[find(y)] = find(x);
	}
	
}
