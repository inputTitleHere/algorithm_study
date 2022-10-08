package inflearn._5five;

import java.util.*;
public class Inf05_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// 우선순위큐라는 개념
		// Java에서 PriorityQueue라는 애를 제공한다. 얘는 heap의 tree구조인듯 하다.
		
		// 근데 pq는 동급 순위일때 순서유지가 되는지 모르겠다.
		// 링크드리스트로 써먹자.
		Queue<Patient> q = new LinkedList<Patient>();
		
		// 전체 숫자가 크지 않아서 링크드리스트로 그냥 완탐하겠다.
		// heap이라는 완벽이진트리를 사용한 방식이 있다고는 한다.
		// 근데 문제 조건에서 꺼내서 더 높은애가 뒤에 있으면 그냥 뒤로 날린다고 한다??
		// 예제 2번 보니까 우선순위큐 맞다. -> 아니다.
		
		// 밤 12시다. 귀찮으니까 완전 브루트포스 하겠다...
		
		for(int i=0;i<n;i++) {
			q.offer(new Patient(i, sc.nextInt()));
		}
		int counter = 0;
		BIG:while(!q.isEmpty()) {
			Patient p = q.poll();
			for(Patient pat : q) {
				if(pat.getPriority()>p.getPriority()) {
					q.offer(p);
					continue BIG;
				}
			}
			counter++;
			if(p.getNo()==m) {
				System.out.println(counter);
				break;
			}
		}
	}
}

class Patient{
	// 롬복 없다 ㅠ
	int no;
	int priority;
	
	public Patient(int no, int priority) {
		this.no = no;
		this.priority = priority;
	}
	public int getNo() {
		return no;
	}

	public int getPriority() {
		return priority;
	}
}