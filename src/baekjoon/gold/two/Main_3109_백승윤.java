package baekjoon.gold.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_백승윤 {
	
	static char[][] map;
	static int r;
	static int c;
	static int counter=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());

		map = new char[r][c];
		for(int i=0;i<r;i++) {
			map[i]=br.readLine().trim().toCharArray();
		}
		c--; // 1 기준
		r--;
		for(int i=0;i<=r;i++) {
			dfs(i,0);						
		}
		
		System.out.println(counter);
	}
	public static boolean dfs(int row, int col) {
		if(col==c) { // -1 이미됨. // 끝에 도달하는데 성공함.
			counter++;
			return true;
		}
		// 위로
		if(row>0 && map[row-1][col+1]=='.') {
			map[row-1][col+1]='-';
			if(dfs(row-1,col+1)) {
				return true;
			}
		}
		// 중간으로
		if(map[row][col+1]=='.') {
			map[row][col+1]='-';
			if(dfs(row,col+1)) {
				return true;
			}
		}
		// 아래로
		if(row<r && map[row+1][col+1]=='.') { // r -> -1됨
			map[row+1][col+1]='-';
			if(dfs(row+1,col+1)) {
				return true;
			}
		}
		return false; // 아무데도 못감.
	}
}


