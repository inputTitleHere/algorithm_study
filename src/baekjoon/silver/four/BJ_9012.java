package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_9012 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		TC : for(int i=0;i<tc;i++) {
			Deque<Character> cdeq = new ArrayDeque<Character>();
			char[] carr = br.readLine().toCharArray();
			for(char c : carr) {
				if(c=='(') {
					cdeq.push(c);
					continue;
				}
				if(cdeq.isEmpty()) {
					sb.append("NO").append("\n");
					continue TC;
				}
				cdeq.pop();
			}
			
			if(cdeq.isEmpty()) {
				sb.append("YES").append("\n");				
			}else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
