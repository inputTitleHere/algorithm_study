package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int[] narr = new int[n+1];
		int[] sumarr = new int[n+1];
		
		stk = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			narr[i]=Integer.parseInt(stk.nextToken());
			sumarr[i]=sumarr[i-1]+narr[i];
		}
		
		for(int t=0;t<m;t++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken())-1;
			int to = Integer.parseInt(stk.nextToken());
			sb.append(sumarr[to]-sumarr[from]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
