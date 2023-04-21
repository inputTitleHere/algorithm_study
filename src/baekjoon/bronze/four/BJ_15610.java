package baekjoon.bronze.four;

import java.io.*;

public class BJ_15610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(br.readLine());
		double d = Math.sqrt((double)a)*4;
		System.out.println(d);
	}
}
