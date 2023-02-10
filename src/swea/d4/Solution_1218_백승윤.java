package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_백승윤 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br);
	}
	
	static void solve(BufferedReader br) throws IOException{
		// testcase = 10
		TC : for(int tc = 1; tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			int n = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			for(char c : br.readLine().toCharArray()) {
				// '()', '[]', '{}', '<>
				if(c=='(' || c=='[' || c=='{' || c=='<') {
					stack.push(c);
				}else {
					if(stack.isEmpty()) { // 스택이 빈 케이스
						sb.append(0).append("\n");
						continue TC;
					}
					char cc = stack.pop(); // 하나 꺼내서 짝 확인
					if(cc=='(') { // 얘만 1칸차이임
						if(cc+1!=c) {
							sb.append(0).append("\n");
							continue TC;					
						}
					}else {
						if(cc+2!=c) {
							sb.append(0).append("\n");
							continue TC;												
						}
					}
				}
			}
			if(!stack.isEmpty()) { // 다 끝났는데 뭔가 남은 경우
				sb.append(0).append("\n");										
			}else {
				sb.append(1).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
