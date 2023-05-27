package baekjoon.bronze.three;

import java.io.*;

public class BJ_1284 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s=null;
		StringBuilder sb = new StringBuilder();
		while(!"0".equals((s=br.readLine()))){
			char[] chars = s.toCharArray();
			int len = 1; // start
			for(char c : chars) {
				if(c=='1') {
					len+=2;
				}else if(c=='0') {
					len+=4;
				}else {
					len+=3;
				}
				len++;
			}
			sb.append(len).append("\n");
		}
		System.out.println(sb.toString());
	}
}
