package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		MAIN : while (true) {
			stack.clear();
			String input = br.readLine();
			if (input.charAt(0) == '.') {
				break;
			}
			char[] carr = input.toCharArray();
			for (char c : carr) {
				if (c == '(' || c == '[') {
					stack.push(c);
					continue;
				}
				if (c == ')') {
					if(stack.isEmpty() || stack.peek()!='(') {
						sb.append("no\n");
						continue MAIN;
					}else {
						stack.pop();
					}
					continue;
				}
				
				if(c==']') {
					if(stack.isEmpty() || stack.peek()!='[') {
						sb.append("no\n");
						continue MAIN;
					}else {
						stack.pop();
					}
				}
			}// END for each char c in carr
			if(stack.isEmpty()) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		System.out.println(sb.toString());
	}
}
