package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		int minTime=Integer.MAX_VALUE;
		int maxHeight=0;
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		// 0부터 256까지 가능한 조합 뽑기
		for(int h=0;h<=256;h++) {
			int place=0;
			int dig=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					int height = map[i][j];
					if(height>h) {
						dig+=height-h;
					}else if(height<h) {
						place+=h-height;
					}
				}
			}
			if(place<=dig+b) { // 가능한 조합이면
				int time = place + dig*2;
				if(time<=minTime) {
					minTime=time;
					maxHeight=h;
				}
			}
		}
		sb.append(minTime).append(" ").append(maxHeight);
		System.out.println(sb.toString());
	}
}
