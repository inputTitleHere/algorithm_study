package baekjoon.silver.one;

import java.io.IOException;

public class BJ_1711 {

	static int n;
	static int count = 0;
	static int[][] dots;
	static int[] selection = new int[3];

	public static void main(String[] args) throws IOException {
		n = read();
		dots = new int[n][2];
		for (int i = 0; i < n; i++) {
			dots[i][0] = read(); // x
			dots[i][1] = read(); // y
		}
		dfs(0, 0);
		System.out.println(count);
	}

	static void dfs(int step, int selected) {
		if (selected == 3) {
			check();
			return;
		}
		if (step == n) {
			return;
		}

		selection[selected] = step;
		dfs(step + 1, selected + 1);

		dfs(step + 1, selected);
	}

	static void check() {
		int i = selection[0], j = selection[1], k = selection[2];

		long ax = (long) dots[i][0] - dots[j][0];
		long ay = (long) dots[i][1] - dots[j][1];

		long bx = dots[j][0] - dots[k][0];
		long by = dots[j][1] - dots[k][1];

		long cx = (long) dots[k][0] - dots[i][0];
		long cy = (long) dots[k][1] - dots[i][1];

		long a = ax * ax + ay * ay;
		long b = bx * bx + by * by;
		long c = cx * cx + cy * cy;

		if (a + b == c || a + c == b || b + c == a) {
			count++;
		}
	}

	private static int read() throws IOException {
		boolean isNeg = false;
		int c, n = 0;
		while ((c = System.in.read()) > 32) {
			if (c == 45) {
				isNeg = true;
			} else {
				n = (n << 3) + (n << 1) + (c & 15);
			}
		}
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return isNeg ? -n : n;
	}
}
