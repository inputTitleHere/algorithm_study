package inflearn._2two;

import java.util.*;

public class Inf02_04 {
	
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		arr = new int[n];
		arr[0]=arr[1]=1;
		for(int i=2;i<n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString().trim());
	}	
}
