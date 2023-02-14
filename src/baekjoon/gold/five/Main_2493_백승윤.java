package baekjoon.gold.five;

import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_2493_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(0).append(" "); // 처음은 무조건 빔.
		Deque<Point> deq = new LinkedList<Point>();
		deq.add(new Point(Integer.parseInt(stk.nextToken()),1)); // 처음 추가.
		for(int i=2;i<=n;i++) {
			int next = Integer.parseInt(stk.nextToken());
			if(deq.peekFirst().h < next) { // 키가 아예 큰게 온 경우
				// 싹 날려버려 맷
				
				deq = new LinkedList<>();
				deq.add(new Point(next,i));
				sb.append(0).append(" ");
			}else if(deq.peekLast().h > next) { // 아예 작으면
				sb.append(deq.peekLast().pos).append(" ");
				deq.addLast(new Point(next,i));
			}else {
				while(deq.peekLast().h<next) {
					deq.pollLast();
				}
				sb.append(deq.peekLast().pos).append(" ");
				deq.addLast(new Point(next, i));
			}
		}
		System.out.println(sb.toString());
	}
	private static class Point{
		int h; // height
		int pos;
		public Point(int h, int pos) {
			this.h = h;
			this.pos = pos;
		}
	}
}
