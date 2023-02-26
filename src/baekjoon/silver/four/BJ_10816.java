package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_10816 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int next = Integer.parseInt(stk.nextToken());
			if(map.containsKey(next)) {
				map.put(next, map.get(next)+1);
			}else {
				map.put(next, 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(stk.hasMoreTokens()) {
			int next = Integer.parseInt(stk.nextToken());
			sb.append(map.getOrDefault(next, 0)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
