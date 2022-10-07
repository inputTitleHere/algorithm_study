package programmers.kakao.recruitment2022;

import java.util.*;

public class Question_2 {
		
	public int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		while(n>0) {
			sb.append(n%k);
			n/=k;
		}
		StringTokenizer numbers = new StringTokenizer(sb.reverse().toString(),"0");
		while(numbers.hasMoreTokens()) {
			if(isPrime(Long.parseLong(numbers.nextToken()))) {
				counter++;
			}
		}
		return counter;
	}
	
	public boolean isPrime(long n) {
		if(n==1) {
			return false;
		}
		if(n==2) {
			return true;
		}
		for(long i=2;i<=(long)Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		new Question_2().solution(39, 3);
		
	}
}
