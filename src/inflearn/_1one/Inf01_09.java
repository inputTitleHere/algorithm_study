package inflearn._1one;

import java.util.Scanner;

public class Inf01_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c : input) {
			if(c>='0' && c<='9') {
				sb.append(c);
			}
		}
		System.out.println(Integer.parseInt(sb.toString()));
	}
}
