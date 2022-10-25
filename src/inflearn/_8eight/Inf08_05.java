package inflearn._8eight;

import java.util.*;
public class Inf08_05 {
	static int[] coin=null;
	static int min=9999; 
	static int n=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		coin = new int[n];
		for(int i=0;i<n;i++) coin[i]=sc.nextInt();
		Arrays.sort(coin);
		
		int money = sc.nextInt();
		
		// 해결부
		coiner(0,money,0);
		System.out.println(min);
	}
	static void coiner(int count, int money, int sum) {
		if(count>min)return;
		if(sum==money && count<min) {
			min=count;
			return;
		}
		for(int i=n-1;i>=0;i--) {
			int s = sum+coin[i];
			if(s>money) continue;
			coiner(count+1,money,s);
		}
	}
}
