package inflearn._9nine;

import java.util.*;
public class Inf09_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			pq.offer(new Lecture(sc.nextInt(),sc.nextInt()));
		}
		PriorityQueue<Lecture> npq = new PriorityQueue<>((Lecture r, Lecture l)->{
			return l.m-r.m;
		});
		int maxDay = pq.peek().d;
		int money=0;
		
		for(int i=maxDay;i>0;i--) {
			while(!pq.isEmpty()) {
				if(pq.peek().d==i) {
					npq.offer(pq.poll());
				}else {
					break;
				}
			}
			if(!npq.isEmpty()) {
				money+=npq.poll().m;				
			}
		}
		System.out.println(money);
	}
}

class Lecture implements Comparable<Lecture>{
	int m; // money
	int d; // day
	public Lecture(int m, int d) {
		this.m=m; this.d=d;
	}
	@Override
	public int compareTo(Lecture l) {
		if(l.d==this.d) return l.m-this.m; // 큰게 앞 // this-comp : 오름차순 comp-this : 내림차순
		else return l.d-this.d;
	}
}