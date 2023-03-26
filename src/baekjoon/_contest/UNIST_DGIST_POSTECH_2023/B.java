package baekjoon._contest.UNIST_DGIST_POSTECH_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c =br.readLine().toCharArray();
		List<Character> cl = new ArrayList<Character>();
		
		// case 모든 C는 U & dp는 반반
		int u =0;
		int dp = 0;
		for(char ch : c) { 
			if(ch=='C' || ch=='U') {
				u++;
			}
			if(ch=='D' || ch=='P') {
				dp++;
			}
		}
		
		dp = (int)Math.ceil((double)dp/2);
		if(u>dp) {
			cl.add('U');
		}
		
		//case 모든 DP는 D이고 모든 U는 C(기권)이다.
		int d = 0;
		for(char ch : c) {
			if(ch=='D' || ch=='P') {
				d++;
			}
		}
		if(d>0) {
			cl.add('D');
		}
		
		// case 모든 DP는 P이고 모든 U는 C(기권)이다.
		int p = 0;
		for(char ch : c) {
			if(ch=='D' || ch=='P') {
				p++;
			}
		}
		if(p>0) {
			cl.add('P');
		}
		
		if(cl.isEmpty()) {
			cl.add('C');
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : cl) {
			sb.append(ch);
		}
		System.out.println(sb.toString());
	}
}
