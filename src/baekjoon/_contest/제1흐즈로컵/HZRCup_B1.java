package baekjoon._contest.제1흐즈로컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HZRCup_B1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		// long으로 받기
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for (int i = 0; i < n; i++) {
			long next = Long.parseLong(stk.nextToken());
			if (next != 0L) {
				pq.add(next);
			}
		}

		while (pq.size() > 1) {
			long l1 = pq.poll();
			long l2 = pq.poll();

			if (l1 == l2) {
				pq.add(l1 + l2);
			} else {
				pq.add(l2);
			}
		}
		System.out.println(pq.poll());
	}
}
