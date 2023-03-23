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
		Set<Integer> set = new TreeSet<Integer>();
		Queue<Order> que = new ArrayDeque<>();
		
		for(int tc=0;tc<t;tc++) {
			set.clear();
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int target = Integer.parseInt(stk.nextToken());
			Order o = new Order(start, new ArrayList<>());
			que.add(o);
			System.out.println("========================");
			while(!que.isEmpty()) {
				Order prev = que.poll();
				System.out.println(prev.number);
				System.out.println(prev.order);
				if(prev.number==target) {
					StringBuilder sbb = new StringBuilder();
					for(char c : prev.order) {
						sbb.append(c);
					}
					sb.append(sbb.toString()).append("\n");
					break;
				}
				// D
				int nexti = (prev.number*2)%10000;
				if(!set.contains(nexti)) {
					que.add(new Order(nexti,prev.order,'D'));
					set.add(nexti);
				}
				// S
				nexti = (prev.number-1+10000)%10000;
				if(!set.contains(nexti)) {
					que.add(new Order(nexti,prev.order,'S'));
					set.add(nexti);
				}
				// L
				nexti = ((prev.number*10)/10000 + prev.number*10)%10000;
				if(!set.contains(nexti)) {
					que.add(new Order(nexti,prev.order,'L'));
					set.add(nexti);
				}
				// R
				nexti = ((prev.number%10)*1000+prev.number/10);
				if(!set.contains(nexti)) {
					que.add(new Order(nexti,prev.order,'R'));
					set.add(nexti);
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	private static class Order{
		int number;
		List<Character> order;
		public Order(int number, List<Character> ori, char next) {
			super();
			this.number = number;
			this.order = new ArrayList<Character>(ori);
			this.order.add(next);
		}
		
		public Order(int number, List<Character> l) {
			this.number=number;
			this.order = l;
		}
		
	}
	
}
