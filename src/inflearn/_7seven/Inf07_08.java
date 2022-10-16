package inflearn._7seven;

import java.util.*;
public class Inf07_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		int[] checked = new int[10001];
		
		int counter = 0;
		q.offer(s);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) { // 여기다 q.size()하면 실시간으로 변하네 ㅋㅋㅋ
				int curr = q.poll();
				if(checked[curr]==1) { // 확인한거면 스킵
					continue;
				}else checked[curr]=1;
				
				if(curr==e) {
					// 다음단계 확인중 찾음
					System.out.println(counter);
					return;
				}else if(curr<e) {
					q.offer(curr+1);
					q.offer(curr+5);					
				}else {
					q.offer(curr-1);					
				}
			}
			counter++;
		}
	}
}
