package baekjoon.gold.four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16919_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());

		char[][] ori = new char[r][];
		for (int i = 0; i < r; i++) {
			ori[i] = br.readLine().toCharArray();
		}

		char[][][] history = new char[8][][];
		history[0] = ori;
		history[1] = fill(copy(ori, r, c), 'O', r, c);

		char[][] second = copy(history[1], r, c);
		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (ori[i][j] == 'O') {
					second[i][j] = '.';
					for (int[] d : dir) {
						int ny = i + d[0];
						int nx = j + d[1];
						if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
							second[ny][nx] = '.';
						}
					}
				}
			}
		}
		history[2] = second;
		history[3] = history[1];

		char[][] fourth = copy(history[1], r, c);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (second[i][j] == 'O') { // 여기있던게 4th에서 터진다.
					fourth[i][j] = '.';
					for (int[] d : dir) {
						int ny = i + d[0];
						int nx = j + d[1];
						if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
							fourth[ny][nx] = '.';
						}
					}
				}
			}
		}
		history[4] = fourth;
		history[5] = history[1];

		char[][] sixth = copy(history[1], r, c);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (fourth[i][j] == 'O') { // 여기있던게 6th에서 터진다.
					sixth[i][j]='.';
					for (int[] d : dir) {
						int ny = i + d[0];
						int nx = j + d[1];
						if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
							sixth[ny][nx] = '.';
						}
					}
				}
			}
		}
		history[6] = sixth;
		history[7] = history[1];

		char[][] zero = copy(history[1], r, c);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sixth[i][j] == 'O') { // 여기있던게 6th에서 터진다.
					zero[i][j]='.';
					for (int[] d : dir) {
						int ny = i + d[0];
						int nx = j + d[1];
						if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
							zero[ny][nx] = '.';
						}
					}
				}
			}
		}
		history[0] = zero;
//		printHistory(history);
		if (n == 1) {
			System.out.println(toString(ori));
			return;
		}
		int mod = (n - 1) % 8;
		System.out.println(toString(history[mod]));
	}

	static String toString(char[][] shape) {
		StringBuilder sb = new StringBuilder();
		for (char[] carr : shape) {
			for (char ch : carr) {
				sb.append(ch);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	static void printHistory(char[][][] history) {
		int stage = 1;
		for (char[][] page : history) {
			System.out.println("=====================================");
			System.out.println(stage++);
			for (char[] line : page) {
				System.out.println(Arrays.toString(line));
			}
		}
	}

	static char[][] copy(char[][] ori, int r, int c) {
		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			System.arraycopy(ori[i], 0, map[i], 0, c);
		}
		return map;
	}

	static char[][] fill(char[][] map, char with, int r, int c) {
		for (int i = 0; i < c; i++) {
			map[0][i] = with;
		}
		for (int i = 1; i < r; i++) {
			System.arraycopy(map[0], 0, map[i], 0, c);
		}
		return map;
	}
}
