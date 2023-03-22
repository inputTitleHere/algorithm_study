package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start = 666;
		while(n>0) {
			if(getSix(start++)>=3) {
				n--;
			}
		}
		System.out.println(--start);
	}
	
	static int getSix(int n) {
		int len=0;
		int max=0;
		while(n>0) {
			if(n%10==6) {
				len++;
				max = Math.max(len, max);
			}else {
				len=0;
			}
			n/=10;
		}
		return max;
	}
}
