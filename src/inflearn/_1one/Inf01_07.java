package inflearn._1one;

import java.util.Scanner;

public class Inf01_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toLowerCase().toCharArray();
		boolean isPalindrom = true;
		for(int i=0;i<(input.length>>1);i++) {
			if(input[i]!=input[input.length-i-1]) {
				isPalindrom = false;
				break;
			}
		}
		System.out.println(isPalindrom?"YES":"NO");
	}
}
