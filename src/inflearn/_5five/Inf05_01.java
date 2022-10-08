package inflearn._5five;

import java.util.*;
public class Inf05_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.nextLine().toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		for(char c : in) {
			if(stack.empty()) {
				stack.add(c);
				continue;
			}
			if(c==')'&&stack.peek()=='(') {
				stack.pop();
				continue;
			}
			stack.add(c);
		}
		if(stack.size()>0) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}
	}
}
