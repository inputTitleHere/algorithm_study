package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1181 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];
		for(int i=0;i<n;i++) {
			input[i]=br.readLine();
		}
		Arrays.sort(input,(String s1,String s2)->{
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}else {
				return s1.length() - s2.length();
			}
		});
		StringBuilder sb = new StringBuilder();
		sb.append(input[0]).append("\n");
		for(int i=1;i<n;i++) {
			if(input[i-1].equals(input[i])) {
				continue;
			}
			sb.append(input[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
