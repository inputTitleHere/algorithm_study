package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_9019 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Order> que = new ArrayDeque<>();
		
		for(int tc=0;tc<t;tc++) {
			boolean[] visited = new boolean[10000];
			que.clear();
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int target = Integer.parseInt(stk.nextToken());
			Order o = new Order(start);
			que.add(o);
			while(!que.isEmpty()) {
				Order prev = que.poll();
//				System.out.printf("n : %s order : %s\n",prev.number,prev.order);
				if(prev.number==target) {
					StringBuilder sbb = new StringBuilder();
					for(char c : prev.carr) {
						sbb.append(c);
					}
					sb.append(sbb.toString()).append("\n");
					break;
				}
				// D
				int nexti = (prev.number*2)%10000;
				if(!visited[nexti]) {
					que.add(new Order(nexti,prev.carr,'D'));
					visited[nexti]=true;
				}
				// S
				nexti = (prev.number+9999)%10000;
				if(!visited[nexti]) {
					que.add(new Order(nexti,prev.carr,'S'));
					visited[nexti]=true;
				}
				// L
				nexti = ((prev.number*10)/10000 + prev.number*10)%10000;
				if(!visited[nexti]) {
					que.add(new Order(nexti,prev.carr,'L'));
					visited[nexti]=true;
				}
				// R
				nexti = ((prev.number%10)*1000+prev.number/10);
				if(!visited[nexti]) {
					que.add(new Order(nexti,prev.carr,'R'));
					visited[nexti]=true;
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	private static class Order{
		int number;
		char[] carr;
		public Order(int number, char[] ori, char next) {
			super();
			this.number = number;
			this.carr = new char[ori.length+1];
			System.arraycopy(ori, 0, carr, 0, ori.length);
			carr[ori.length]=next;
		}
		
		public Order(int number) {
			this.number=number;
			this.carr = new char[0];
		}
	}
}
