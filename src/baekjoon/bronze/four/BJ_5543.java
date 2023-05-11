package baekjoon.bronze.four;

import java.io.*;

public class BJ_5543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[5];
		for (int i = 0; i < 5; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		int min = Integer.MAX_VALUE / 10;
		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 5; j++) {
				int set = input[i] + input[j];
				if (set < min) {
					min = set;
				}
			}
		}
		System.out.println(min-50);
	}
}
