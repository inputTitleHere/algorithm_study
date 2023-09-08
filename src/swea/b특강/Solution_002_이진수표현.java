package swea.b특강;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_002_이진수표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine())+1;
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		MAIN: for (int tcase = 1; tcase < t; tcase++) {
			sb.append("#").append(tcase).append(" ");
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());

			for (int i = 0; i < n; i++) {
				if ((m & (1 << i)) == 0) {
					sb.append("OFF").append("\n");
					continue MAIN;
				}
			}
			sb.append("ON").append("\n");
		}
		System.out.println(sb.toString());
	}
}
