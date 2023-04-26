package baekjoon.gold.two;

import java.io.*;
import java.util.*;

public class BJ_2696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		for (int t = 0; t < tcase; t++) {
			int m = Integer.parseInt(br.readLine());
			if(m%2==1) {
				sb.append((m+1)/2).append("\n");
			}
			// 큰게 먼저 나오게
			PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
			// 작은게 먼저 나오게
			PriorityQueue<Integer> bigger = new PriorityQueue<>();

			stk = new StringTokenizer(br.readLine());
			int mid = Integer.parseInt(stk.nextToken());
			sb.append(mid).append(" ");

			int step = 1;
			int counter=1;
			while (--m > 0) {
				if (step % 10 == 0) {
					stk = new StringTokenizer(br.readLine());
				}
				int next = Integer.parseInt(stk.nextToken());
				if (mid <= next) {
					bigger.add(next);
				} else {
					smaller.add(next);
				}

				if (step % 2 == 0) {
					
					while (bigger.size() > smaller.size()) {
						smaller.add(mid);
						mid = bigger.poll();
					}
					while (smaller.size() > bigger.size()) {
						bigger.add(mid);
						mid = smaller.poll();
					}
					
//					System.out.println("mid = "+mid);
//					System.out.println("smaller = "+smaller);
//					System.out.println("bigger = "+bigger);
					sb.append(mid).append(" ");
					if(++counter%10==0) {
						sb.append("\n");
					}
				}
				step++;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
