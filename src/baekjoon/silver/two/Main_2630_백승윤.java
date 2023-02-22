package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_백승윤 {
	static int blue=0;
	static int white=0;
	static int[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		StringTokenizer stk = null;
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		cut(0,0,n);
		StringBuilder sb = new StringBuilder();
		sb.append(white).append("\n").append(blue);
		System.out.println(sb.toString());
	}
	
	static void cut(int r, int c, int size) {
		int sum = 0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum+=board[i][j];
			}
		}
		if(sum== size*size) {
			blue++;
		}else if(sum==0) {
			white++;
		}else {
			// 4분할
			int half = size/2;
			cut(r,c,half); // 1
			cut(r,c+half,half); // 2
			cut(r+half,c,half); // 3
			cut(r+half,c+half,half); // 4
		}
	}
}
