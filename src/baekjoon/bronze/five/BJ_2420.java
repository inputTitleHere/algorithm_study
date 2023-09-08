package baekjoon.bronze.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2420 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer stk = new StringTokenizer(br.readLine());
		long l = Integer.parseInt(stk.nextToken());
		long r = Integer.parseInt(stk.nextToken());
		
		System.out.println((long)Math.abs(l-r));
	}
}
