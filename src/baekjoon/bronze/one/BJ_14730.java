package baekjoon.bronze.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14730 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		while(n-->0) {
			stk = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			sum+=l*r;
		}
		System.out.println(sum);
	}
}
