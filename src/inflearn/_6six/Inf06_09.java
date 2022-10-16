package inflearn._6six;

import java.util.*;
public class Inf06_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++) in[i]=sc.nextInt();
		
		int lt =Arrays.stream(in).max().getAsInt();
		int rt = Arrays.stream(in).sum();
		
		int ans = 0;
		while(lt<=rt) {
			// mid = cap
			int mid=(rt+lt)/2;
			if(count(in,mid)<=m) {
				ans=mid;
				rt=mid-1;
			}else {
				lt=mid+1;
			}
		}
		System.out.println(ans);
	}
	static int count(int[] arr, int mid) { // 핵심 -> 합을 구해서 크면 개수 +1. 최종 개수 반환. -> 개수가 넘으면 기준 크기 증가. 적거나 같으면 기준 크기를 줄여봄.
		int sum=0;
		int counter=1; // 시작은 1 최소 1조각이다.
		for(int i : arr) {
			if(sum+i>mid) {
				counter++;
				sum=i;
			}else {
				sum+=i;
			}
		}
		return counter;
	}
}
