package baekjoon.bronze.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_15923 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int[][] points = new int[n + 1][2];

		points[n] = points[0] = new int[] { Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()) };
		int dist = 0;
		for (int i = 1; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			points[i] = new int[] { Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()) };
			dist += Math.abs(points[i][0]-points[i-1][0]) + Math.abs(points[i][1]-points[i-1][1]);
		}
		dist+=Math.abs(points[n][0]-points[n-1][0]) + Math.abs(points[n][1]-points[n-1][1]); 
		System.out.println(dist);
	}
}
