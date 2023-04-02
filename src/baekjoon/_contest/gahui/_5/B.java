package baekjoon._contest.gahui._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		boolean[] timeTable = new boolean[60 * 60 * 24];
		int max = 60 * 60 * 24;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int up = Integer.parseInt(stk.nextToken());
		int down = Integer.parseInt(stk.nextToken());

		for (int t = 0; t < up + down; t++) {
			stk = new StringTokenizer(br.readLine(), ":");
			int h = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int s = Integer.parseInt(stk.nextToken());

			int second = h * 60 * 60 + m * 60 + s;
			for (int i = second; i < second + 40; i++) {
				if(!timeTable[i]) {
					timeTable[i]=true;
					max--;
				}
			}
		}
		System.out.println(max);
	}
}
