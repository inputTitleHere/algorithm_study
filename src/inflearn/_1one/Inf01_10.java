package inflearn._1one;

import java.util.Scanner;

public class Inf01_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] in = sc.nextLine().split(" ");
		char[] str = in[0].toCharArray();
		char t = in[1].charAt(0);
		// 그냥 왔다 갔다 하자.
		int curr = 999;
		int[] answer = new int[str.length];
		for(int i=0;i<str.length;i++) {
			if(str[i]==t) {
				curr=0;
				answer[i]=curr;
			}else {
				curr++;
				answer[i]=curr;
			}
		}
		curr=999;
		for(int i=str.length-1;i>=0;i--) {
			if(str[i]==t) {
				curr=0;
				continue;
			}else {
				curr++;
				if(answer[i]>curr) {
					answer[i]=curr;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
}
