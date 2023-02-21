package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1992_백승윤 {
	static int n;
	static int[][] image;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		image = new int[n][n];
		for(int i=0;i<n;i++) {
			char[] carr = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				image[i][j] = carr[j]-'0';
			}
		}
		zip(0,0,n);
		System.out.println(sb.toString());
	}
	
	private static void zip(int r,int c, int len) {
		int sum=0;
		for(int i=r;i<r+len;i++) {
			for(int j=c;j<c+len;j++) {
				sum+=image[i][j];
			}
		}
		if(sum==0) {
			sb.append(0);
		}else if(sum==len*len) {
			sb.append(1);
		}else {
			sb.append("(");
			int half = len/2;
			zip(r,c,half);
			zip(r,c+half,half);
			zip(r+half,c,half);
			zip(r+half,c+half,half);
			sb.append(")");
		}
	}
}
