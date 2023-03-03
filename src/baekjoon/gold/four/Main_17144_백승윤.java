package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Java 11 : 460ms

public class Main_17144_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(stk.nextToken());
		int[][] room = new int[r][c];
		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int ac = 0; // 아랫쪽 공기청정기 y좌표
		for (int i = 0; i < r; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				room[i][j] = Integer.parseInt(stk.nextToken());
				if (room[i][j] == -1) {
					ac = i;
				}
			}
		}
		int[][] prev = room;
		int[][] after;

		// MAIN
		for (int time = 0; time < t; time++) { // t초 반복

			after = new int[r][c];
			after[ac - 1][0] = after[ac][0] = -1;
			// 먼지확산
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (prev[i][j] >= 5) { // 사실상 5 이상인 먼지더미만 확산함.
						int remoteDust = prev[i][j] / 5;
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int ny = i + dir[k][0];
							int nx = j + dir[k][1];
							if (nx > -1 && nx < c && ny > -1 && ny < r && prev[ny][nx] != -1) {
								after[ny][nx] += remoteDust;
								cnt++;
							}
						}
						after[i][j] += prev[i][j] - remoteDust * cnt;
					} else {
						after[i][j]+=prev[i][j];
					}
				}
			} // 전체 확산 끝

			// 회전시키기
			int upy = ac - 1;
			int upx = 0;
			int downy = ac;
			int downx = 0;
			// 위에 반시계
			after[upy - 1][upx] = 0; // 정화
			while (upy > 0) { // 위로
				after[upy][upx] = after[--upy][upx];
			}
			while (upx < c - 1) { // 우로
				after[upy][upx] = after[upy][++upx];
			}
			// 아래로
			while (upy < ac - 1) {
				after[upy][upx] = after[++upy][upx];
			}
			// 좌로
			while (upx > 1) {
				after[upy][upx] = after[upy][--upx];
			}
			after[upy][upx]=0;
			// 아래시계
			// 정화
			after[downy + 1][downx] = 0;
			// 아래로
			while (downy < r - 1) {
				after[downy][downx] = after[++downy][downx];
			}
			// 우로
			while (downx < c - 1) {
				after[downy][downx] = after[downy][++downx];
			}
			// 위로
			while (downy > ac) {
				after[downy][downx] = after[--downy][downx];
			}
			// 좌로
			while (downx > 1) {
				after[downy][downx]=after[downy][--downx];
			}
			after[downy][downx]=0;
//			System.out.println("==========================");
//			print(after);
			prev = after;
		}// 시뮬 끝

		// TODO -> 먼지 합계 출력
		int sum=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				int k = prev[i][j];
				if(k>0) {
					sum+=k;
				}
			}
		}
		System.out.println(sum);
		
	}
	static void print(int[][] board) {
		for(int i=0;i<board.length;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
