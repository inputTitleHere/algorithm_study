package swea.b특강;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_004_수열편집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tcase = 1; tcase <= t; tcase++) {
			sb.append("#").append(tcase).append(" ");
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int l = Integer.parseInt(stk.nextToken());
			int count = n;

			int[] arr = new int[2001];
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}

			for (int i = 0; i < m; i++) {
				stk = new StringTokenizer(br.readLine());
				char order = stk.nextToken().charAt(0);
				int pos;
				int target;
				switch (order) {
				case 'I':
					pos = Integer.parseInt(stk.nextToken());
					target = Integer.parseInt(stk.nextToken());
					System.arraycopy(arr, pos, arr, pos+1, count-pos);
					arr[pos]=target;
					count++;
					break;
				case 'D':
					pos = Integer.parseInt(stk.nextToken());
					System.arraycopy(arr, pos+1, arr, pos, count-pos-1);
					count--;
					break;
				case 'C':
					pos = Integer.parseInt(stk.nextToken());
					target = Integer.parseInt(stk.nextToken());
					arr[pos]=target;
					break;
				}
			}
			if(count<=l) {
				sb.append(-1).append("\n");
			}else {
				sb.append(arr[l]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
