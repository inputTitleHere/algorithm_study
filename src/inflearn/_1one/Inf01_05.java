package inflearn._1one;

import java.util.Scanner;

public class Inf01_05 {
	
	public static boolean check(char c){
		if('a'<=c && c<='z') {
			return true;
		}
		if('A'<=c && c<='Z') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		// 투포인터 써야겠다.
		int left = 0;
		int right = input.length-1;
		while(left<right) {
			if(check(input[left])) {
				while(!check(input[right])) {
					right--;
				}
				char t = input[left];
				input[left]=input[right];
				input[right]=t;
				left++;
				right--;
			}else {
				left++;
			}
		}
		System.out.println(String.valueOf(input));
	}
}
