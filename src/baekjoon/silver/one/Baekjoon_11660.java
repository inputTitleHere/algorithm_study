package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int cases = Integer.parseInt(st.nextToken());
		int ori[][] = new int[size + 1][size + 1];
		int s[][] = new int[size + 1][size + 1];

		for (int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= size; j++) {
				ori[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + ori[i][j];
			}
		}
		for (int i = 0; i < cases; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
			sb.append(sum);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
