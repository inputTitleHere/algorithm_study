package swea.sw;

import java.io.*;
import java.util.*;

public class Solution_2383_백승윤 {

	static int[][] human;
	static int[] stair;
	static int[][] stairPos;

	static List<Integer> left;
	static List<Integer> right;

	static int min;
	static int p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			human = new int[10][2];
			stair = new int[2]; // left = 0; right = 1;
			stairPos = new int[2][2];
			left = new ArrayList<>();
			right = new ArrayList<>();
			min = Integer.MAX_VALUE >> 1;
			p = 0;
			int sptr = 0;
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int cell = Integer.parseInt(stk.nextToken());
					map[i][j] = cell;
					if (cell == 1) {
						human[p][0] = i;
						human[p++][1] = j;
					} else if (cell != 0) {
						stairPos[sptr][0] = i;
						stairPos[sptr][1] = j;
						stair[sptr++] = cell;
					}
				}
			}
			dfs(0);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void simul() {
		int time = 0;
//		System.out.println(left);
//		System.out.println(right);
		PriorityQueue<Integer> lq = new PriorityQueue<>(left);
		PriorityQueue<Integer> rq = new PriorityQueue<>(right);
		Queue<Integer> lstr = new ArrayDeque<>(3);
		Queue<Integer> rstr = new ArrayDeque<>(3);
		while (!lq.isEmpty() || !rq.isEmpty() || !lstr.isEmpty() || !rstr.isEmpty()) {
//			System.out.println("=====================");
//			System.out.println(lq);
//			System.out.println(rq);
//			System.out.println(lstr);
//			System.out.println(rstr);
//			System.out.println(time);
			int size = lstr.size();
			for (int k = 0; k < size; k++) {
				int m = lstr.poll() - 1;
				if (m != 0) {
					lstr.add(m);
				}
			}
			size = rstr.size();
			for (int k = 0; k < size; k++) {
				int m = rstr.poll() - 1;
				if (m != 0) {
					rstr.add(m);
				}
			}

			int limit = 3;
			while (!lq.isEmpty() && limit > 0) {
				if (lq.peek() <= time && lstr.size() < 3) {
					lq.poll();
					lstr.add(stair[0]);
				}
				limit--;
			}

			limit = 3;
			while (!rq.isEmpty() && limit > 0) {
				if (rq.peek() <= time && rstr.size() < 3) { // 수행 가능.
					rq.poll();
					rstr.add(stair[1]);
				}
				limit--;
			}
			time++;
		}
		min = Math.min(min, time);
	}

	static void dfs(int step) {
		if (step == p) {
			simul();
			return;
		}
		// left
		int dist = Math.abs(human[step][0] - stairPos[0][0]) + Math.abs(human[step][1] - stairPos[0][1]);
		left.add(dist);
		dfs(step + 1);
		left.remove(left.size() - 1);
		// right
		dist = Math.abs(human[step][0] - stairPos[1][0]) + Math.abs(human[step][1] - stairPos[1][1]);
		right.add(dist);
		dfs(step + 1);
		right.remove(right.size() - 1);
	}

}
