package inflearn._6six;

import java.util.*;
public class Inf06_06 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); // tc : 100이하
		int n = sc.nextInt();
		int[] in = new int[n];
		int i=0;
		int j=0;
		for(i=0;i<n;i++) in[i]=sc.nextInt();
		
		int[] cpy = Arrays.copyOf(in,n);
		// 정렬 안하려고 했는데 그냥 정렬 쓰고 비교하자. 어째피 100명 학생 이하다.
		Arrays.sort(in);
		
		StringBuilder sb = new StringBuilder();
		for(i=0;i<n;i++) {
			if(cpy[i]!=in[i])sb.append(i+1).append(" ");
		}
		System.out.println(sb.toString());
		
	}
}
