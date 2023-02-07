package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ").append(solve(br)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * 내 방식
	 */
	static int solve(BufferedReader br) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] farm = new int[n][n];
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			for(int j=0;j<n;j++) {
				farm[i][j]=input.charAt(j)-'0';
			}
		}
		int sum=0;
		for(int i=0;i<n/2;i++) {
			for(int j=n/2-i;j<n/2+i+1;j++) {
				sum+=farm[i][j]+farm[n-i-1][j];
			}
		}
		for(int i=0;i<n;i++) {
			sum+=farm[n/2][i];
		}
		return sum;
	}
}
