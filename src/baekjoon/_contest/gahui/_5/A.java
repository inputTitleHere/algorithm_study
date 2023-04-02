package baekjoon._contest.gahui._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dist = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			String type = stk.nextToken();
			int n = Integer.parseInt(stk.nextToken());
			if("Es".equals(type)) {
				dist+=n*21;
			}else {
				dist+=n*17;
			}
		}
		System.out.println(dist);
	}
}
