package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int t=0;t<n;t++) {
			stk = new StringTokenizer(br.readLine());
			String order = stk.nextToken();
			
			switch(order) {
			case"push":
				int next = Integer.parseInt(stk.nextToken());
				stack.push(next);
				break;
			case"pop":
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.pop()).append("\n");					
				}
				break;
			case"size":
				sb.append(stack.size()).append("\n");					
				break;				
			case"empty":
				sb.append(stack.isEmpty()?1:0).append("\n");
				break;
			case"top":
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack.peek()).append("\n");					
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
