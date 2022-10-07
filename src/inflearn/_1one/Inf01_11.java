package inflearn._1one;

import java.util.Scanner;

public class Inf01_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] input = sc.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		//K, KHSSSSSSSE		
		int counter=0;
		System.out.printf("currCount = %d\n",counter);
		char currChar=input[0]; // K(1)
		System.out.printf("currChar = %s\n",currChar);
		
		for(char c : input) {
			if(c==currChar) {
				counter++;
			}else {
				sb.append(currChar);
				if(counter!=1) {
					sb.append(counter);
				}
				currChar=c;
				counter=1;
			}
		}
		// 마지막 출력
		sb.append(currChar);
		if(counter!=1) {
			sb.append(counter);
		}
		System.out.println(sb.toString());
	}
}
