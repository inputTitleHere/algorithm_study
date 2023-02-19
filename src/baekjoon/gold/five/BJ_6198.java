package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_6198 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Long> stack = new ArrayDeque<>(n/2);
		long sum=0L;
		for(int i=0;i<n;i++) {
			long next=Long.parseLong(br.readLine());
			while(!stack.isEmpty() && stack.peek()<=next) {
				stack.pop();
			}
			stack.push(next);
			sum+=stack.size()-1;
		}
		System.out.println(sum);
	}
}
