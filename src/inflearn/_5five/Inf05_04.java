package inflearn._5five;

import java.util.*;
public class Inf05_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.nextLine().toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for(char c : in) {
			// 후위식은 절대 부호가 앞에 오지 않는다.
			if(stack.empty()) {
				stack.push(Character.getNumericValue(c)); 
				continue;
			}
			if('1'<=c && c<='9') {
				// getNumricValue와 같다.
				stack.push(c-'0');
			}else {
				int second = stack.pop();
				int first = stack.pop();
				switch (c){
				case '+':
					stack.push(first+second); break;
				case '-':
					stack.push(first-second); break;
				case '*':
					stack.push(first*second); break;
				case '/':
					stack.push(first/second); break;
				}
			}
		}
		System.out.println(stack.pop());
	}
}
