package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// JAva 11 : 908ms
public class Main_1987_백승윤 {

	static int r; // 세로
	static int c; // 가로
	static int[][] ctrl = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 행렬순(y,x)(상좌하우)

	static int globalMaxMove=0;
	static char[][] board;
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(globalMaxMove);
	}

	private static void dfs(int y, int x, int step) {
		visited[board[y][x]-'A']=true;
		// 탈출조건은 갈 곳이 없을 때 탈출이다.
		for(int i=0;i<4;i++) {
			int[] move = ctrl[i];
			int ny = move[0]+y;
			int nx = move[1]+x;
			
			if(ny >=0 && nx >=0 && ny<r && nx<c && !visited[board[ny][nx]-'A']) {
				dfs(ny,nx,step+1);
			}
		}
		visited[board[y][x]-'A']=false; // 뒷정리
		globalMaxMove = Math.max(globalMaxMove, step);
	}
}
