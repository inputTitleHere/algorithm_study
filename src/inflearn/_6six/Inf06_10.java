package inflearn._6six;

import java.util.*;
public class Inf06_10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		int[] barn = new int[n];
		for(int i=0;i<n;i++) barn[i]=sc.nextInt();
		Arrays.sort(barn);
		int lt = 1;
		int rt = barn[n-1];
		int ans =0;
		while(lt<=rt) {
			int dist =(lt+rt)/2;
			if(count(barn,dist)>=c) {
				ans=dist;
				lt=dist+1;
			}else {
				rt=dist-1;
			}
		}
		System.out.println(ans);
		
		
	}
	static int count(int[] arr, int dist) {
		int counter = 1;
		int end = arr[0];
		for(int i=1;i<arr.length; i++) {
			if(arr[i]-end>=dist) {
				counter++;
				end=arr[i];
			}
		}
		return counter;
	}
}

