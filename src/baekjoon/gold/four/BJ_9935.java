package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_9935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ori = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int last = bomb.length-1;
		
		Stack<Character> main = new Stack<>();
		Stack<Character> temp = new Stack<>();
		
		for(char cha : ori) {
			main.push(cha);
			if(cha==bomb[last]) {
				int ptr = last;
				while(ptr>-1 && !main.isEmpty() && main.peek()==bomb[ptr]) {
					temp.push(main.pop());
					ptr--;
				}
				if(temp.size()==bomb.length) {
					temp.clear();
				}else {
					while(!temp.isEmpty()) {
						main.push(temp.pop());
					}
				}
			}
		}
		
		if(main.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			for(char c : main) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
		
		
	}
}
