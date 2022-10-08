package inflearn._5five;

import java.util.*;
public class Inf05_03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		// 큐로 제작
		List<Queue<Integer>> machine = new ArrayList<Queue<Integer>>();
		for(int i=0;i<n;i++) {
			machine.add(new LinkedList<Integer>());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				machine.get(j).offer(sc.nextInt());
			}
		}
		// 스택으로 저장
		Stack<Integer> stack = new Stack<Integer>();
		int counter = 0;
		// 해결
		int moves = sc.nextInt();
		for(int i=0;i<moves;i++) {
			int pos = sc.nextInt();
			// 레인 정해서
			Queue<Integer> lane = machine.get(pos-1);
			if(lane.isEmpty()) {
				// 비어있으면 아무것도 하지마.
				continue;
			}
			while(lane.peek()==0) { // 0 아닌게 나올때 까지 꺼내고
				lane.poll();
			}
			int doll = lane.poll(); // 상단의 것을 꺼냄.
			
			// 스택 확인
			if(stack.empty()) {
				stack.push(doll);
				continue;
			}
			if(stack.peek()==doll) { // 일치하면 꺼내기.
				stack.pop();
				// !!!! 인형은 두개씩 없어진다.
				counter+=2;
				continue;
			}
			stack.push(doll);
		}
		System.out.println(counter);
	}
}
