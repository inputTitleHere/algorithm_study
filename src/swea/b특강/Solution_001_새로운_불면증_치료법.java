package swea.b특강;

import java.io.*;

public class Solution_001_새로운_불면증_치료법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int full = Integer.parseInt("1111111111", 2);

		int tcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tcase; t++) {
			sb.append("#").append(t).append(" ");
			int track = 0;
			int n = Integer.parseInt(br.readLine());
			int curr = 0;
			while (track != full) {
				int tmp = curr += n;
				while (tmp > 0) {
					int single = tmp % 10;
					track |= (1 << single);
					tmp /= 10;
				}
			}
			sb.append(curr).append("\n");
		}
		System.out.println(sb.toString());
	}
}
