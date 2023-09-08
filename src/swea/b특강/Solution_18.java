package swea.b특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_18 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		int tcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tcase; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			Set<String> left = new HashSet<>();
			int counter = 0;

			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < l; i++) {
				left.add(stk.nextToken());
			}
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < r; i++) {
				if (left.contains(stk.nextToken())) {
					counter++;
				}
			}
			sb.append(counter).append("\n");
		}
		System.out.println(sb.toString());
	}
}
