package baekjoon._contest.SCSC_2023;

import java.io.*;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		boolean pm = false;
		int start = 0;
		if (input.charAt(0) == '-') {
			pm=true;
			start = 1;
		}
		while (input.charAt(start) >= '0' && input.charAt(start) <= '9') {
			start++;
		}
		long left = Long.parseLong(input.substring(0, start), 8);
		char calc = input.charAt(start);
		if (input.charAt(start + 1) == '-') {
			pm^=true;
			start+=2;
		}else {
			start++;
		}
		long right = Long.parseLong(input.substring(start), 8);
		System.out.println(left);
		System.out.println(right);
		long res = 0L;
		try {
			switch (calc) {
			case '+':
				res = left + right;
				break;
			case '-':
				res = left - right;
				break;
			case '/':
				res = left / right;
				break;
			case '*':
				res = left * right;
				break;
			}
			System.out.println(res);
			if(res<0) {
				
			}
			
			String parsed = Long.toOctalString(res);
			if(pm) {
				System.out.println("-"+parsed);
			}
			else {
				System.out.println(parsed);
			}
		} catch (Exception e) {
			System.out.println("invalid");
		}
	}
}
