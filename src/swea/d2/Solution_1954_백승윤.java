package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_백승윤 {

	static int[][] shell;
	static int slug;
	static int max;
	static int x;
	static int y;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			sb.append("#").append(i).append("\n");
			slug = Integer.parseInt(br.readLine());
			x = y = 0;
			max = slug * slug;
			shell = new int[slug][slug];
			draw(1, 0);
			print(sb);
		}
		System.out.println(sb.toString());
	}

	static void draw(int number, int dir) {
		if (number > max) {
			return;
		}
		int dirMod = dir % 4;
		int drx = dx[dirMod];
		int dry = dy[dirMod];
		while (x < slug && x > -1 && y < slug && y > -1 && shell[y][x] == 0) {
			shell[y][x] = number++;
			x += drx;
			y += dry;
		}
		// 아래로 이동
		x += dx[(dir+1)%4]-drx;
		y += dy[(dir+1)%4]-dry;
		draw(number, dir + 1);
	}

	static void print(StringBuilder sb) {
		for (int[] arr : shell) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
	}
}
