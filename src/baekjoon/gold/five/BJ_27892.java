package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_27892 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		long x = Long.parseLong(stk.nextToken());
		long n = Long.parseLong(stk.nextToken());
		Set<Long> set = new TreeSet<>();
		
		List<Long> loop = new ArrayList<>(1024);
		set.add(x);
		loop.add(x);
		int current = 1;
		while(n>0) {
			if((x&1L)==0) { // 짝수
				x>>=1;
				x^=6L;
			}else { // 홀수
				x<<=1;
				x^=6L;
			}
			n--;
			if(set.contains(x)) {
				int pos = loop.lastIndexOf(x);
				int loopLen = current-pos;
				int remain = (int)(n%loopLen);
				System.out.println(loop.get(pos+remain));
				return;
			}else {
				loop.add(x);
				set.add(x);
			}
			current++;
		}
	System.out.println(x);
}}
