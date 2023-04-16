package baekjoon._contest.AGCU_1st;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		System.out.println(l^r);
	}
}
