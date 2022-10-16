package inflearn._6six;

import java.util.*;
public class Inf06_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		
		int i=0;
		for(i=0;i<n;i++) in[i]=sc.nextInt();
		
		// 버블정렬 -> 큰수 잡으면 버블처럼 올라옴.
		StringBuilder sb = new StringBuilder();
		int j=0;
		for(i=0;i<n-1;i++) {
			for(j=0;j<n-i-1;j++) {
				if(in[j]>in[j+1]) swap(j,j+1,in);
			}
		}
		for(i=0;i<n;i++) sb.append(in[i]).append(" ");
		
		System.out.println(sb.toString());
	}
	static void swap(int i, int j, int[] arr) {
		int t = arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
}
