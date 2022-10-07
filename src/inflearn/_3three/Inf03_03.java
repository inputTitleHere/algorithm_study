package inflearn._3three;

import java.util.*;
public class Inf03_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int left = 0;
		int right = left+k-1;
		int curr = 0;
		// 초기값
		for(int i=0;i<k;i++) {
			curr+=arr[i];
		}
		int max=curr;
		while(right<n-1) {
			curr+=arr[++right]-arr[left++];
			if(max<curr) {
				max=curr;
			}
		}
		System.out.println(max);
	}
}
