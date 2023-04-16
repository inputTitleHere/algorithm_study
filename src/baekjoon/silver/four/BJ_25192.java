package baekjoon.silver.four;

import java.io.*;
import java.util.*;

public class BJ_25192 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new TreeSet<String>();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			String next = br.readLine();
			if("ENTER".equals(next)) {
				set.clear();
				continue;
			}
			
			if(!set.contains(next)) {
				cnt++;
				set.add(next);
			}
		}
		System.out.println(cnt);
	}
}
