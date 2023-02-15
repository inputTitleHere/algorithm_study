package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// java 8 : 80ms
// java 11: 120ms
public class Main_2563_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine()); // 색종이수
		// 색종이는 크기 무조건 10임
		int[][] board = new int[100][100];
		
		for(int k=0;k<n;k++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			for(int i=y;i<y+10;i++) {
				for(int j=x;j<x+10;j++) {
					board[i][j]=1;
				}
			}
		}
		
		int count=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				count+=board[i][j];
			}
		}
		System.out.println(count);
	}
}
