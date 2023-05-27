package baekjoon.bronze.five;

import java.io.*;

public class BJ_5597 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		for (int i = 0; i < 28; i++) {
			t |= (1 << Integer.parseInt(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 30; i++) {
			if ((t & (1 << i)) == 0) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
