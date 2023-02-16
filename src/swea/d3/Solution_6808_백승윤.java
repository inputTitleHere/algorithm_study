package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2,328ms..
public class Solution_6808_백승윤 {
	static StringBuilder sb = new StringBuilder();
	static boolean[] used;
	static int[] gy;
	static int[] iy;
	static int win;
	static int lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			gy = new int[9];
			iy = new int[9];
			used = new boolean[9];
			win = 0;
			lose = 0;
			int trk = 0;
			for (int i = 0; i < 9; i++) {
				gy[i] = Integer.parseInt(stk.nextToken());
				trk |= 1 << gy[i];
			}
			int ptr = 0;
			for (int i = 1; i < 19; i++) {
				if ((trk & 1 << i) == 0) {
					iy[ptr++] = i;
				}
			}
			dfs(0, 0, 0);
			sb.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int step, int gp, int ip) {
		if (step == 9) {
			if (gp > ip)
				win++;
			else if (gp < ip)
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (used[i])
				continue;
			used[i] = true;
			if (gy[step] > iy[i]) {
				dfs(step + 1, gp + gy[step] + iy[i], ip);
			} else {
				dfs(step + 1, gp, ip + gy[step] + iy[i]);
			}
			used[i] = false;
		}
	}
}
