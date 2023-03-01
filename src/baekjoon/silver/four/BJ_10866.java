package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_10866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			Order o = Order.valueOf(stk.nextToken());	
			switch(o) {
			case push_front:
				deq.addFirst(Integer.parseInt(stk.nextToken()));
				break;
			case push_back:
				deq.addLast(Integer.parseInt(stk.nextToken()));
				break;
			case pop_front:
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deq.pollFirst()).append("\n");					
				}
				break;
			case pop_back:
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deq.pollLast()).append("\n");					
				}
				break;
			case size:
				sb.append(deq.size()).append("\n");
				break;
			case empty:
				if(deq.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case front:
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(deq.peekFirst()).append("\n");
				}
				break;
			case back:
				if(deq.isEmpty()) {
					sb.append(-1).append("\n");					
				}else {
					sb.append(deq.peekLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
	private static enum Order{
		push_front, push_back, pop_front, pop_back, size, empty, front, back
	}
}
