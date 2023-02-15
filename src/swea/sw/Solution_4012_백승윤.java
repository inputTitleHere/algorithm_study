package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] syn = new int[n][n];
			for(int i=0;i<n;i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					syn[i][j]=Integer.parseInt(stk.nextToken());
				}
			}
			
			
		}
		System.out.println(sb.toString());
	}
}
