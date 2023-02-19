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
		Deque<Integer> deq = new ArrayDeque<Integer>();
		Deque<Integer> tmp = new ArrayDeque<Integer>();
		long pair = 0L;
		int max=0;
		int cnt=0;
		
		// 처음 넣기
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());
			while (!deq.isEmpty() && deq.peek() < next) {
				System.out.println(deq);
				System.out.println("pair = "+deq.peek() + " AND "+next);
				pair++;
				deq.pop();
			}
			if(max<next) {
//				System.out.println("CNT reset at "+next);
				pair+=cnt;
				cnt=0;
			}
			if(!deq.isEmpty() && deq.peek() == next) {
				max = next;
				while (!deq.isEmpty() && deq.peek() == next) {
//					System.out.println("--------------");
					System.out.println(deq);
					System.out.println("pair = "+deq.peek() + " AND "+next);
					deq.pop();
					cnt++;
					System.out.println(cnt);
					pair++;
				}
			}
			if(!deq.isEmpty()) {
				System.out.println(deq);
				System.out.println("pair = "+deq.peek() + " AND "+next);
				pair++;
			}
			deq.push(next);
		}
		System.out.println(pair);
	}
}
