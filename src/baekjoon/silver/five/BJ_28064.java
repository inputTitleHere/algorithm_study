package baekjoon.silver.five;

import java.io.*;

public class BJ_28064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] names = new String[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			names[i] = br.readLine();
			for (int j = 0; j < i; j++) {
				if (matches(names[i], names[j])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	static boolean matches(String l, String r) {
		int ll = l.length();
		int rl = r.length();

		int len = Math.min(ll, rl);
		int i = 0;
		while (++i <= len) {
			if (l.substring(0, i).equals(r.substring(rl - i, rl))
					|| l.substring(ll - i, ll).equals(r.substring(0, i))) {
				return true;
			}
		}
		return false;
	}
}
