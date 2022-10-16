package inflearn._6six;

import java.util.*;
public class Inf06_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++) in[i]=sc.nextInt();
		
//		Arrays.sort(in);
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<n;i++) sb.append(in[i]).append(" ");
//		System.out.println(sb.toString());
		
		// 선택정렬로 풀어보자.
		// 선택정렬 -> 영역에서 제일 작은 거를 찾아서 앞으로 가져오는 것(선택해서 가져오기)
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int s = in[i];
			for(int j=i;j<n;j++) {
				if(in[j]<s) {
					s=in[j];
					int t = in[j];
					in[j]=in[i];
					in[i]=t;
				}
			}
			sb.append(in[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
