package baekjoon._contest.AGCU_1st;

import java.io.*;
import java.util.StringTokenizer;

public class E {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int d1 = Integer.parseInt(stk.nextToken());
		int d2 = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		if(d1<d2) {
			int tmp = d1;
			d1=d2;
			d2=tmp;
		}

		double hv = (x/100.0)/d1;
		double lv = ((100.0-x)/100.0)/d2;
		double tv = hv+lv; // 1g
		double res = 1.0/tv;
		System.out.println(res);
	}
}
