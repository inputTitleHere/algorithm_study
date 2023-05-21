package baekjoon._contest.SCON;

import java.io.*;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		if(a==b) {
			System.out.println("Anything");
		}else if(a>b) {
			System.out.println("Subway");
		}else {
			System.out.println("Bus");
		}
	}
}
