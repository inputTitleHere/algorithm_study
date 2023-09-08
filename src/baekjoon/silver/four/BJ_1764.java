package baekjoon.silver.four;

import java.io.*;
import java.util.*;

public class BJ_1764 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		Set<String> ln = new HashSet<>();
		Set<String> dup = new TreeSet<>();
		while(n-->0) {
			ln.add(br.readLine());
		}
		while(m-->0) {
			String next = br.readLine();
			if(ln.contains(next)) {
				dup.add(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dup.size()).append("\n");
		for(String s : dup) {
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());	
	}
}
