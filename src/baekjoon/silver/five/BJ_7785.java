package baekjoon.silver.five;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int n = Integer.parseInt(br.readLine());

		Set<String> set = new TreeSet<String>((l,r)->r.compareTo(l));

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			String name = stk.nextToken();
			String mode = stk.nextToken();
			if("enter".equals(mode)) {
				set.add(name);
			}else {
				set.remove(name);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}
