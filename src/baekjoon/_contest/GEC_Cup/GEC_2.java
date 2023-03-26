package baekjoon._contest.GEC_Cup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GEC_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		int t = 0;
		
		while(t!=n) {
			if(x%2==0) {
				x=(x/2)^6;
			}else {
				x=(x*2)^6;
			}
			t++;
		}
		System.out.println(x);
	}
}
