package baekjoon.bronze.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_17356 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int uk = Integer.parseInt(stk.nextToken());
		int je = Integer.parseInt(stk.nextToken());
		
		double m = ((double)je-uk)/400;
		double win = 1/(1+Math.pow(10, m));
		System.out.printf("%.10f",win);
	}
}
