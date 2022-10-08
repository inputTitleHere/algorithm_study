package inflearn._5five;

import java.util.*;
public class Inf05_05 {
	
	static Scanner sc = new Scanner(System.in);
	static int counter =0;
	static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) {
		char[] in = sc.nextLine().toCharArray();
		char prev=' ';
		for(char c : in) {
			if(c=='(') {
				stack.push(c);
				prev=c;
			}else if(prev=='('){
				stack.pop();
				prev=c;
				counter+=stack.size();
			}else {
				stack.pop();
				counter++;
			}
		}
		System.out.println(counter);
	}
}
