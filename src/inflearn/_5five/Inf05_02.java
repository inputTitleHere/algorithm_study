package inflearn._5five;

import java.util.*;
public class Inf05_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.nextLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		// 괄호는 완벽히 짝이 맞는다고 생각.
		for(char c : in){
			if(c==')') {
				while(stack.pop()!='(');
				continue;
			}
			stack.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for(char c : stack) sb.append(c);
		System.out.println(sb.toString());
	}
}
