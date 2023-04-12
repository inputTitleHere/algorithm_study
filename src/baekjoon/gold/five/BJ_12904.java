package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String s = br.readLine();
		String t = br.readLine();

		Queue<String> que = new ArrayDeque<>();
		que.add(t);
		
		while(!que.isEmpty()) {
			String next = que.poll();
			if(s.equals(next)) {
				System.out.println(1);
				return;
			}
			if(next.length()<s.length()) {
				continue;
			}
			
			if(next.charAt(next.length()-1)=='A') {
				que.add(next.substring(0,next.length()-1));
			}
			if(next.charAt(next.length()-1)=='B') {
				que.add(new StringBuilder(next.substring(0,next.length()-1)).reverse().toString());
			}
		}
		System.out.println(0);
		return;
	}

}
