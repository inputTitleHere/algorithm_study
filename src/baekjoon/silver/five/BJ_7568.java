package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int n = Integer.parseInt(br.readLine());

		int[][] input = new int[n][2];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(stk.nextToken());
			input[i][1] = Integer.parseInt(stk.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int pos=1;
			int[] curr = input[i];
			for(int j=0;j<n;j++) {
				int[] compare = input[j];
				if(compare[0]>curr[0] && compare[1]>curr[1]) {
					pos++;
				}
			}
			sb.append(pos).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
