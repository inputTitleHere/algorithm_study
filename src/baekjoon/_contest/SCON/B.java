package baekjoon._contest.SCON;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk;
		PriorityQueue<Member> byProblem = new PriorityQueue<>((l,r)->{
			return r.p-l.p;
		});
		PriorityQueue<Member> byYear = new PriorityQueue<>((l,r)->{
			return l.y-r.y;
		});
		for (int i = 0; i < 3; i++) {
			stk = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken()) % 100;
			String s = stk.nextToken();
			Member m = new Member(p, y, s);
			byProblem.add(m);
			byYear.add(m);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!byYear.isEmpty()) {
			Member next = byYear.poll();
			sb.append(next.y);
		}
		sb.append("\n");
		while(!byProblem.isEmpty()) {
			Member next = byProblem.poll();
			sb.append(next.s.charAt(0));
		}
		System.out.println(sb.toString());
		
	}
	private static class Member{
		int p;
		int y;
		String s;
		public Member(int p, int y, String s) {
			this.p = p;
			this.y = y;
			this.s = s;
		}
	}
}
