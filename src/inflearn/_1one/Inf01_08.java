package inflearn._1one;

import java.util.Scanner;

public class Inf01_08 {
	public static boolean isAlphabet(char c) {
		if(c>='a'&&c<='z') {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toLowerCase().toCharArray();
		int left=0;
		int right=input.length-1;
		while(left<right) {
			if(isAlphabet(input[left])) {
				while(!isAlphabet(input[right])) {
					right--;
				}
				if(input[left]!=input[right]) {
					System.out.println("NO");
					return;
				}
				left++;
				right--;
			}else {
				left++;
			}
		}
		System.out.println("YES");
	}
}
