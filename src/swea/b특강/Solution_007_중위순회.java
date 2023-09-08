package swea.b특강;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_007_중위순회 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		StringTokenizer stk = null;
		
		for(int tcase=1;tcase<=10;tcase++) {
			sb.append("#").append(tcase).append(" ");
			int n = Integer.parseInt(br.readLine());
			char[] tree = new char[n+1];
			for(int i=1;i<=n;i++) {
				stk=new StringTokenizer(br.readLine());
				stk.nextToken();
				tree[i]=stk.nextToken().charAt(0);
			}
			dfs(1,n,tree,sb);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int current, int limit, char[] arr, StringBuilder sb) {
		if(current>limit) {
			return;
		}
		
		dfs(current*2,limit,arr,sb);
		sb.append(arr[current]);
		dfs(current*2+1,limit,arr,sb);
	}
}
