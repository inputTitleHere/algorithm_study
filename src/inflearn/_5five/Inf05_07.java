package inflearn._5five;

import java.util.*;
public class Inf05_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Character> req = new LinkedList<Character>();
		for(char c: sc.nextLine().toCharArray()) req.offer(c);		
		
		for(char c : sc.nextLine().toCharArray()) {
			if(req.peek()==c) {
				req.poll();
			}
			if(req.isEmpty())break;
		}
		
		System.out.println(req.isEmpty()?"YES":"NO");
		
		
	}
}
