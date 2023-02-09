package baekjoon.gold.five;

import java.util.Scanner;

public class Main_2023_백승윤 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		boolean[] notPrime = new boolean[(int)Math.sqrt(Math.pow(10, n))+1];
		// 소수 빌드
		for(int i=2;i<notPrime.length;i++) {
			if(!notPrime[i]) {
				int k=i*2;
				while(k<notPrime.length) {
					notPrime[k]=true;
					k+=i;
				}
			}
		}
		// 2,3,5,7 -> 1은 소수 아님
		int[] t = {2,3,5,7};
		for(int i:t) {
			extend(i,1,notPrime);
		}
		System.out.println(sb.toString());
	}
	static void extend(int number, int step, boolean[] notPrime) {
		for(int i=2;i<=(int)Math.sqrt(number);i++) {
			if(!notPrime[i] && number%i==0) {
				return;
			}
		}
		if(step==n) {
			sb.append(number).append("\n");
			return;
		}
		
		for(int i=0;i<10;i++) {
			extend(number*10+i,step+1,notPrime);
		}
	}
}
