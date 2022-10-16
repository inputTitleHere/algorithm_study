package inflearn._7seven;

import java.util.*;
public class Inf07_04 {

	static int[] mem = null; // 메모이제이션! 동적계획!
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		mem = new int[n+1];
		mem[0]=mem[1]=mem[2]=1;
		
		
		for(int i=1;i<=n;i++) {
			System.out.print(fibo(i)+" ");
		}
		System.out.println();
		System.out.println("경과시간 : "+(System.currentTimeMillis()-start));
	}
	
	static int fibo(int n) {
		if(n==1) return 1;
		if(n==2) return 1;
		
		if(mem[n]==0) {
			mem[n]=fibo(n-2)+fibo(n-1);
		}
		return mem[n];

	}
	
}
