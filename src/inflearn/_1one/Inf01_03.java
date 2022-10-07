package inflearn._1one;

import java.util.Scanner;

public class Inf01_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		
		int maxLen = 0;
		String longest=null;
		for(String s : input) {
			if(s.length()>maxLen) {
				maxLen=s.length();
				longest=s;
			}
		}
		System.out.println(longest);
	}
}
