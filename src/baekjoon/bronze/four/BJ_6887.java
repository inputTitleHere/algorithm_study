package baekjoon.bronze.four;

import java.io.*;

public class BJ_6887 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tiles = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("The largest square has side length ").append((int)Math.sqrt(tiles)).append(".");
		System.out.println(sb.toString());
	}
}
