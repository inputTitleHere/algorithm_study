package baekjoon.gold.four;

import java.io.*;
import java.util.PriorityQueue;

public class BJ_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		long sum = 0;

		while (pq.size() > 1) {
			int left = pq.poll();
			int right = pq.poll();
			int local = left + right;
			sum += local;
			pq.add(local);
		}
		System.out.println(sum);

	}
}
