package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_4014_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		// 완탐으로 간다.
		int count = 0;
		// 가로
		ROW: for (int i = 0; i < n; i++) {
			boolean[] vis = new boolean[n];
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j + 1] < map[i][j]) {
					int low = map[i][j] - 1;
					for (int k = 1; k <= x; k++) {
						if (k + j >= n || vis[k + j] || map[i][k + j] != low) {
							continue ROW;
						}
						vis[k + j] = true;
					}
					j += x - 1;
				} else if (map[i][j + 1] > map[i][j]) {
					int low = map[i][j + 1] - 1;
					for (int k = 0; k < x; k++) {
						if (j - k < 0 || vis[j - k] || map[i][j - k] != low) {
							continue ROW;
						}
						vis[j - k] = true;
					}
				}
			}
//				System.out.printf("row : %d \n", i);
			count++;
		}
		COL: for (int j = 0; j < n; j++) {
			boolean[] vis = new boolean[n];
			for (int i = 0; i < n - 1; i++) {
				if (map[i + 1][j] < map[i][j]) {
					int low = map[i][j] - 1;
					for (int k = 1; k <= x; k++) {
						if (k + i >= n || vis[i + k] || map[i + k][j] != low) {
							continue COL;
						}
						vis[i + k] = true;
					}
					i += x - 1;
				} else if (map[i + 1][j] > map[i][j]) {
					int low = map[i + 1][j] - 1;
					for (int k = 0; k < x; k++) {
						if (i - k < 0 || vis[i - k] || map[i - k][j] != low) {
							continue COL;
						}
						vis[i - k] = true;
					}
				}
			}
//				System.out.printf("col : %d \n", j);
			count++;
		}
		System.out.println(count);
	}
}
