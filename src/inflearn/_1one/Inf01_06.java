package inflearn._1one;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Inf01_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		Set<Character> charSet = new HashSet<Character>();
		char[] input = sc.nextLine().toCharArray();
		for(char c : input) {
			if(charSet.contains(c)) {
				continue;
			}
			charSet.add(c);
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
