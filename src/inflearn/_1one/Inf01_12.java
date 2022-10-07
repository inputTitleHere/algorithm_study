package inflearn._1one;

import java.util.Scanner;

public class Inf01_12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int count=Integer.parseInt(sc.nextLine());
		String input=sc.nextLine();
		for(int i=0;i<count;i++) {
			char[] letter = input.substring(0,7).toCharArray();
			input = input.substring(7);
			int exponent = 64; // 2의 6승(7자리째)
			int sum=0;
			for(char c : letter) {
				if(c=='#') {
					sum+=exponent;					
				}
				exponent>>=1; // 2씩 나눔(비트밀기)
			}
			sb.append((char)sum);
		}
		System.out.println(sb.toString());
	}
}
