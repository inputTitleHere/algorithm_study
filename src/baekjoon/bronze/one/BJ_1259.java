package baekjoon.bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1259 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		int lt,rt;
		MAIN : while(true) {			
			s=br.readLine();
			if(s.equals("0")) {
				break;
			}
			lt = 0;
			rt = s.length()-1;
			while(lt<rt) {
				if(s.charAt(lt++) != s.charAt(rt--)) {
					sb.append("no\n");
					continue MAIN;
				}
			}
			sb.append("yes\n");
		}
		System.out.println(sb.toString());
	}
}
