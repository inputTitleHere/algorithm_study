package baekjoon.bronze.five;

import java.io.*;

public class BJ_27433 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long l = 1L;
		while(n>0) {
			l*=n--;
		}
		System.out.println(l);
	}
}
