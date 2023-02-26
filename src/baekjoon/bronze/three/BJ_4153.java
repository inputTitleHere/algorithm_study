package baekjoon.bronze.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_4153 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;
		
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		while(!s.equals("0 0 0")) {
			stk = new StringTokenizer(s);
			int[] input = new int[] {Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())};
			Arrays.sort(input);
			if(Math.pow(input[0], 2) + Math.pow(input[1], 2) == Math.pow(input[2], 2)) {
				sb.append("right\n");
			}else {
				sb.append("wrong\n");
			}
			s=br.readLine();
		}
		System.out.println(sb.toString());
	}
}
