package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1228_백승윤 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			MyList ml = new MyList();
			Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).forEach((i) -> ml.add(i));
			int change = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < change; i++) {
				String mode = stk.nextToken(); // 이 문제는 전부 insert임.
				int pos = Integer.parseInt(stk.nextToken());
				int count = Integer.parseInt(stk.nextToken());
				MyList tmp = new MyList();
				for (int j = 0; j < count; j++) {
					tmp.add(Integer.parseInt(stk.nextToken()));
				}
				ml.addListAt(tmp, pos);
			}
			sb.append(ml.printTen());
		}
		System.out.println(sb.toString());
	}

	
}

class MyNode {
	int data;
	MyNode next;
	public MyNode(int data, MyNode next) {
		this.data = data;
		this.next = next;
	}
}

class MyList {
	MyNode head; 
	MyNode tail;

	public MyList() {
		head = new MyNode(-1,null);
		tail = null;
	}
	
	void addListAt(MyList list, int pos) {
		MyNode tmp = this.head;
		for (int i = 0; i < pos; i++) { // insert 지점으로 이동
			tmp = tmp.next;
		}
		MyNode next = tmp.next;
		tmp.next = list.head.next;
		list.tail.next = next;
	}

	void add(int i) { // 마지막에 신규 원소 추가.
		if (tail == null) { // 첫 원소인 경우
			tail = new MyNode(i, null);
			head.next = tail;
		} else { // 첫 원소가 아니면 추가 & 꼬리 이동.
			tail.next = new MyNode(i, null);
			tail = tail.next;
		}
	}

	String printTen() {
		MyNode tmp = head.next;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++, tmp = tmp.next) { // 10개 출력
			sb.append(tmp.data).append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}
}
