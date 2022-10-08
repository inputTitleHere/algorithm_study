package inflearn._5five;

import java.util.*;
public class Inf05_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		while(q.size()>1) {
			for(int i=0;i<k-1;i++) {
				q.offer(q.poll());
			}
			q.poll();
		}
		System.out.println(q.poll());
	}
}
