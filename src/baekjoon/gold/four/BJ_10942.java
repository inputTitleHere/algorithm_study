package baekjoon.gold.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_10942 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			seq[i]=Integer.parseInt(stk.nextToken());
		}
		
	}
}
