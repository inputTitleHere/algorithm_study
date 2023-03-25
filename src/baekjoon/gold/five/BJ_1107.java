package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1107 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 시작은 100
		int target = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];
		if (m != 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				broken[Integer.parseInt(stk.nextToken())] = true;
			}
		}
		// case -> 100에서 이동
		int min = Math.abs(target - 100);

		// case -> 번호 새로 입력
		Queue<Integer> que = new ArrayDeque<Integer>();
		int[] dist = new int[1000001];
		dist[target] = 1;
		que.add(target);
		while (!que.isEmpty()) {
			int next = que.poll();
//			System.out.println(next);
			if (isViable(next, broken)) {
				min = Math.min(min, dist[next] - 1 + getLength(next == 0 ? 1 : next)); // 1부터 시작 offset제거
				continue;
			}
			// que추가.
			if (next + 1 < dist.length && dist[next + 1] == 0) {
				que.add(next + 1);
				dist[next + 1] = dist[next] + 1;
			}
			if (next - 1 >= 0 && dist[next - 1] == 0) {
				que.add(next - 1);
				dist[next - 1] = dist[next] + 1;
			}
		}
		System.out.println(min);
	}

	static boolean isViable(int number, boolean[] broken) {
		if (number == 0 && broken[0]) {
			return false;
		}

		while (number > 0) {
			int last = number % 10;
			number /= 10;
			if (broken[last]) {
				return false;
			}
		}
		return true;
	}

	static int getLength(int number) {
		int cnt = 0;
		while (number > 0) {
			number /= 10;
			cnt++;
		}
		return cnt;
	}
}
