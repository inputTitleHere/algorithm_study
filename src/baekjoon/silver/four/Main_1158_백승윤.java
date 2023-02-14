package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1158_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		Circle circle = new Circle(); // 나만의 환형 링크드 리스트
		for(int i=2;i<=n;i++) {
			circle.add(i);
		}
		StringBuilder sb = new StringBuilder();
		String s = circle.josephus(k); // 요세프스 제거기
		
		sb.append("<").append(s.substring(0, s.length()-2)).append(">"); // 마지막 콤마 지우기
		System.out.println(sb.toString());
	}
	/**
	 * 더블 링크드 리스트.
	 *
	 */
	private static class Node{ // 나만의 노드
		int no;
		Node prev;
		Node next;
		public Node(int no) {
			this.no = no;
		}
		@Override
		public String toString() {
			return "Node [no=" + no;
		}
	}
	
	private static class Circle{
		int size; // 크기 추적용 size
		Node origin;
		public Circle() { // 요세프스 문제 특성상 무조건 1은 들어가기 때문에 기본 생성자에 1을 배치하는 코드로 작성.
			origin = new Node(1);
			origin.next=origin;
			origin.prev=origin; // 환형 더블 링크드 리스트
			size=1;
		}
		
		void add(int no) { // 추가하기
			Node n = new Node(no); // 신규 노드 생성
			// origin(시작점) 전에 집어 넣음
			n.prev = origin.prev;
			n.next = origin;
			origin.prev.next=n;  // Z(ori.prev) -> n - A(ori)
			origin.prev=n;
			size++;
		}
		Node remove(Node n) { // 노드 제거하기(더블 링크드 리스트)
			Node prev = n.prev;
			Node next = n.next;
			prev.next=next;
			next.prev=prev;
			n.next=null;
			n.prev=null;
			size--;
			return prev; // 삭제한 노드 전의 노드를 반환한다.
		}
		
		String josephus(int k) {
			StringBuilder sb = new StringBuilder();
			Node curr = origin.prev; 
			while(size>0) {
				int m = k%size; // 최종적으로 이동할 거리(한바퀴 내에서 움직일 수를 구함)
				for(int i=0;i<m;i++) {
					curr = curr.next; // 이동하기
				}
				sb.append(curr.no).append(", "); // 값 기록
				curr = remove(curr); // 삭제
			}
			return sb.toString();
		}
	}
}
