package baekjoon.gold.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17136 { // TODO

	static int[] remain = { 0, 5, 5, 5, 5, 5 };
	static StringBuilder sb = new StringBuilder();
	static int gcount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int[][] board = new int[10][10];
		for (int i = 0; i < 10; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		dfs(board,0);
		for (int i = 1; i <= 5; i++) {
			gcount += (5 - remain[i]);
		}
		System.out.println(sb.toString());
		System.out.println("내 출력 어디감 ???");
	}

	static void dfs(int[][] board, int d) {
		
	}
	

	static int[][] copy(int[][] ori) {
		int[][] cpy = new int[10][10];
		for (int i = 0; i < 10; i++) {
			System.arraycopy(ori[i], 0, cpy[i], 0, 10);
		}
		return cpy;
	}
	
	static void print(int[][] board) {
		for(int[] iarr : board) {
			System.out.println(Arrays.toString(iarr));
		}
	}

}
