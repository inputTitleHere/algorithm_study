package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_13458 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] students = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			students[i]=Integer.parseInt(stk.nextToken());
		}
		stk=new StringTokenizer(br.readLine());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		
		long sum=n;
		for(int i=0;i<n;i++) {
			int p = students[i]-b;
			if(p<=0) continue;
			sum+=p/c;
			if(p%c!=0) {
				sum++;
			}
		}
		System.out.println(sum);
	}
}
