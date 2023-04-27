package baekjoon.platinum.five;

import java.io.*;
import java.util.*;

public class BJ_2593 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		El[] elevators = new El[m + 1];

		boolean[] visited = new boolean[m + 1];
		for (int i = 1; i <= m; i++) {
			stk = new StringTokenizer(br.readLine());
			int strt = Integer.parseInt(stk.nextToken());
			int stp = Integer.parseInt(stk.nextToken());
			elevators[i] = new El(strt, stp);
		}
		stk = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(stk.nextToken());
		int to = Integer.parseInt(stk.nextToken());

		Queue<Elev> que = new ArrayDeque<>();
		for (int i = 1; i <= m; i++) {
			El el = elevators[i];
			if ((from - el.start) % el.step == 0) {
//				System.out.println("Start  " + i);
				que.add(new Elev(i, 1));
				visited[i] = true;
			}
		}

		while (!que.isEmpty()) {
			Elev next = que.poll();
//			System.out.println(next);
			El el = elevators[next.no];
			if ((to >= el.start) && (to - el.start) % el.step == 0) {
				// 탈출
				StringBuilder sb = new StringBuilder();
				sb.append(next.dist).append("\n");
				for (int i : next.history) {
					sb.append(i).append("\n");
				}
				System.out.println(sb.toString());
				return;
			}
			for (int i = 1; i <= m; i++) {
				if (visited[i]) {
					continue;
				}
				El target = elevators[i];
				for (int st = el.start; st <= n; st += el.step) {
					if ((st - target.start) % target.step == 0) {
						// 갈 수 있음
						visited[i] = true;
						Elev move = new Elev(i, next.dist + 1);
						move.history = new ArrayList<>(next.history);
						move.history.add(i);
						que.add(move);
						break;
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static class El {
		int start;
		int step;

		public El(int start, int step) {
			this.start = start;
			this.step = step;
		}
	}

	private static class Elev {
		int no;
		int dist;
		List<Integer> history = new ArrayList<>();

		public Elev(int no, int dist) {
			this.no = no;
			this.dist = dist;
			history.add(no);
		}
	}
}
