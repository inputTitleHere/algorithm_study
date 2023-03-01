package baekjoon.bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050 {
	
	static int[] fact=new int[11];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		fact[0]=1;
		fact[1]=1;
		fact[2]=2;
		
		System.out.println(f(n)/(f(k)*f(n-k)));
		
	}
	
	static int f(int step) {
		if(fact[step]!=0) {
			return fact[step];
		}
		return fact[step] = f(step-1)*step;
	}
}
