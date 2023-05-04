package baekjoon.platinum.five;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * plan -> 같은 길이 = 큰수가 앞에
 * 
 * 
 */
public class BJ_16496 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] inputs = new String[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inputs[i] = stk.nextToken();
		}

		Arrays.sort(inputs, (l, r) -> {
			
			String lf = l+r;
			String rf = r+l;
			return rf.compareTo(lf);
		});

		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (String s : inputs) {
			if("0".equals(s)) {
				if(flag) {
					sb.append(s);
				}
			}else {
				flag=true;
				sb.append(s);				
			}
		}
		if(sb.length()==0) {
			sb.append(0);
		}
		System.out.println(sb.toString());
	}
}
