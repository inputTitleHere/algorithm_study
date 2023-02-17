package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10773 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		int ptr = 0;
		for(int i=0;i<n;i++) {
			int next = Integer.parseInt(br.readLine());
			if(next==0) {
				ptr--;
				continue;
			}
			stack[ptr++] = next;
		}
		int sum=0;
		for(int i=0;i<ptr;i++) {
			sum+=stack[i];
		}
		System.out.println(sum);
	}
}
