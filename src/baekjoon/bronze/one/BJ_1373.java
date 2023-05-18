package baekjoon.bronze.one;

import java.io.*;

public class BJ_1373 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String binaryString = br.readLine();
		StringBuilder sb = new StringBuilder();

		int ptr = binaryString.length() - 1;
		int[] lookup = { 1, 2, 4 };
		int step = 0;
		int localSum = 0;
		while (ptr > -1) {
			if (step == 3) {
				sb.append(localSum);
				localSum = 0;
				step = 0;
			}
			if (binaryString.charAt(ptr) == '1') {
				localSum += lookup[step];
			}
			step++;
			ptr--;
		}
		if (localSum != 0) {
			sb.append(localSum);
		}
		if (sb.length() == 0) {
			sb.append(0);
		}
		sb.reverse();
		System.out.println(sb.toString());

	}
}
