package baekjoon.bronze.four;

import java.io.*;

public class BJ_5524 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(br.readLine().toLowerCase()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
