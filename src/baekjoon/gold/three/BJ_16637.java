package baekjoon.gold.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BJ_16637 {

	static int n;
	static int max = Integer.MIN_VALUE;
	static List<Character> expression;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		expression = new LinkedList<Character>();
		String s = br.readLine();
		for (int i = 0; i < n; i++) {
			expression.add(s.charAt(i));
		}
		generate(0, 0);
		System.out.println(max);
	}

	static void generate(int step, int offset) {
		if (step > n + offset - 3) {
//			System.out.println(expression);
			max = Math.max(max, calculate(expression));
			return;
		}

		// 넣기
		expression.add(step, '(');
		expression.add(step + 4, ')');
		generate(step + 6, offset + 2);
		// 안넣기
		expression.remove(step + 4);
		expression.remove(step);
		generate(step + 2, offset);
	}

	static int calculate(List<Character> expression) {
		Stack<String> stack = new Stack<>();

		int result = 0;
		for (char c : expression) {
//			System.out.println(stack);
			if ('0' <= c && c <= '9') {
				if (stack.isEmpty() || "(".equals(stack.peek())) {
					stack.push(Character.toString(c));
				} else {
					String op = stack.pop();
					int l = Integer.parseInt(stack.pop());
					int r = c - '0';
					stack.push(calc(l,r,op));
				}
			} else if (c == '+' || c == '*' || c == '-') {
				stack.push(Character.toString(c));
			} else if (c == '(') {
				stack.push("(");
			} else if (c == ')') {
				int r = Integer.parseInt(stack.pop());
				stack.pop(); // "(" 제거
				if(stack.isEmpty()) {
					stack.push(Integer.toString(r));
				}else {					
					String op = stack.pop();
					int l = Integer.parseInt(stack.pop());
					stack.push(calc(l,r,op));
				}
			}
		}// end for
		result = Integer.parseInt(stack.pop());
		return result;
	}

	static String calc(int l, int r, String op) {
		if ("+".equals(op)) {
			return Integer.toString(l + r);
		} else if ("-".equals(op)) {
			return Integer.toString(l - r);
		} else {
			return Integer.toString(l * r);
		}
	}
}
