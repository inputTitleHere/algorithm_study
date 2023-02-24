package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


// Java 11 : 144ms
public class Main_10026_백승윤 {
	static int n;
	static int normalCount = 0;
	static int blindCount = 0;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		char[][] tv = new char[n][];
		char[][] cb = new char[n][];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			tv[i] = s.toCharArray();
			cb[i] = s.toCharArray();
		}

		// 정상인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tv[i][j] > 60) { // 대충 60
					// R
					if (tv[i][j] == 'R') {
						normal(tv, 'R', i, j);
					}
					// G
					else if (tv[i][j] == 'G') {
						normal(tv,'G',i,j);
					}
					// B
					else {
						normal(tv,'B',i,j);
					}
				}
			}
		}

		// 색맹
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cb[i][j] > 60) { // 대충 60
					// R & G
					if (cb[i][j] == 'R' || cb[i][j]=='G') { // 'M'으로 하겠음
						colorblind(cb, 'M', i, j);
					}
					// B
					else {
						colorblind(cb, 'B', i, j);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(normalCount).append(" ").append(blindCount);
		System.out.println(sb.toString());
	} // END MAIN

	private static void normal(char[][] tv, char c, int y, int x) {
		Queue<int[]> que = new ArrayDeque<int[]>();
		que.add(new int[] {y,x});
		tv[y][x] = '+';
		while(!que.isEmpty()) {
			int[] next = que.poll();
			for(int i=0;i<4;i++) {
				int ny = next[0]+dir[i][0];
				int nx = next[1]+dir[i][1];
				if(nx>-1 && nx<n && ny>-1 && ny<n && tv[ny][nx]==c) {
					que.add(new int[] {ny,nx});
					tv[ny][nx]='+';
				}
			}
		}
		normalCount++;
	}

	private static void colorblind(char[][] tv, char c,int y, int x) {
		if(c=='M') {
			Queue<int[]> que = new ArrayDeque<int[]>();
			que.add(new int[] {y,x});
			tv[y][x] = '+';
			while(!que.isEmpty()) {
				int[] next = que.poll();
				for(int i=0;i<4;i++) {
					int ny = next[0]+dir[i][0];
					int nx = next[1]+dir[i][1];
					if(nx>-1 && nx<n && ny>-1 && ny<n && (tv[ny][nx]=='R' || tv[ny][nx]=='G')) {
						tv[ny][nx]='+';
						que.add(new int[] {ny,nx});
					}
				}
			}
			blindCount++;
		}else {
			Queue<int[]> que = new ArrayDeque<int[]>();
			que.add(new int[] {y,x});
			tv[y][x] = '+';
			while(!que.isEmpty()) {
				int[] next = que.poll();
				for(int i=0;i<4;i++) {
					int ny = next[0]+dir[i][0];
					int nx = next[1]+dir[i][1];
					if(nx>-1 && nx<n && ny>-1 && ny<n && tv[ny][nx]==c) {
						tv[ny][nx]='+';
						que.add(new int[] {ny,nx});
					}
				}
			}
			blindCount++;
		}
	}
}
