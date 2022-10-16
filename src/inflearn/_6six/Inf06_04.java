package inflearn._6six;

import java.util.*;
public class Inf06_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// LRU -> 정처기에서 봤지?
		// 접근법 -> 배열? 큐?  캐시 [_ _ _ _ _]
		// 링크드리스트로 해보겠다. (어째피 크기 S <= 10임)
		int s = sc.nextInt(); 
		int n = sc.nextInt();
		int[] in = new int[n];
		int i=0;
		
		for(i=0;i<n;i++) in[i]=sc.nextInt();
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for(int k : in) {
			if(q.size()<s) {
				q.offer(k);
				continue;
			}
			int loc = q.indexOf(k);
			if(loc<0) {
				q.offer(k);
				q.pop();
				continue;
			}else {
				q.remove(loc);
				q.offer(k);
				continue;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(i=s-1;i>=0;i--) {
			sb.append(q.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
