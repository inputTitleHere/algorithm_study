package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1541_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int currentNo = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int ptr = 0;
		while (ptr < s.length()) {
			char c = s.charAt(ptr++);
			if ('0' <= c && c <= '9') {
				currentNo *= 10;
				currentNo += (c - '0');
			} else {
				stack.push(stack.pop() + currentNo);
				currentNo = 0;
				if (c == '-') { // '-'이면 괄호 열기
					Stack<Integer> local = new Stack<>();
					local.push(0);
					char l;
					while (ptr < s.length() && (l = s.charAt(ptr)) != '-') {
						if (l == '+') {
							local.push(local.pop() + currentNo);
							currentNo = 0;
						} else {
							currentNo *= 10;
							currentNo += l - '0';
						}
						ptr++;
					}
					local.push(local.pop() + currentNo);
					currentNo=0;
					stack.push(stack.pop() - local.pop());
				}
			}
		}
		stack.push(stack.pop()+currentNo);
		System.out.println(stack.pop());
	}
}
