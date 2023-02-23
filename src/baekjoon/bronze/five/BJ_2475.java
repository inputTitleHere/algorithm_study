package baekjoon.bronze.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2475 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int sum = 0;
		while(stk.hasMoreTokens()) {
			int n = Integer.parseInt(stk.nextToken());
			sum += n*n;
		}
		System.out.println(sum%10);
	}
}
