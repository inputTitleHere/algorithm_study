package baekjoon._contest.제1흐즈로컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HZRCup_A1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken()); // x
		int m = Integer.parseInt(stk.nextToken()); // y

		int result =0;
		if(n%2==0 || m%2==0) {
			result=n*m;
		}else {
			result = n*m-1;
		}
		System.out.println(result);
	}
}
