package baekjoon._contest.AGCU_1st;

import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		if(n*100>=m) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
	}
}
