package baekjoon.bronze.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1547 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;

		int m = Integer.parseInt(br.readLine());

		boolean[] ball = new boolean[4];
		ball[1] = true;

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			swap(from,to,ball);
		}
		for(int i=1;i<4;i++) {
			if(ball[i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

	static void swap(int from, int to, boolean[] arr) {
		boolean val = arr[to];
		arr[to] = arr[from];
		arr[from] = val;
	}

}
