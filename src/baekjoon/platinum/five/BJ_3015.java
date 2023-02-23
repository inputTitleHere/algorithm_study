package baekjoon.platinum.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_3015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Height> deq = new ArrayDeque<>();
		long pair=0L;
		
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());
			if(deq.isEmpty()) {
				deq.push(new Height(next, 1));
				continue;
			}
			// 기존의 키보다 큰 키가 들어오면 큰 키가 나올 때 까지 스택 비우기
			Height curr = new Height(next,1);
			while (!deq.isEmpty() && deq.peek().height <= next) {
				Height h = deq.pop();
				pair+=h.count;
				if(h.height==next) {
					curr.count+=h.count;
				}
			}
			// 스택 안비면 한쌍 더 가능
			if(!deq.isEmpty()) {
				pair++;
			}
			deq.push(curr);
		}
		System.out.println(pair);
	}
	private static class Height{
		int height;
		int count;
		public Height(int height, int count) {
			this.height = height;
			this.count = count;
		}
	}
}
