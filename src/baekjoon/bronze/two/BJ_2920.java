package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] input = new int[8];
		for(int i=0;i<8;i++) {
			input[i]=Integer.parseInt(stk.nextToken());
		}
		
		if(input[0]==1) {
			for(int i=0;i<7;i++) {
				if(input[i]+1 != input[i+1]) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
			return;
		}
		if(input[0]==8) {
			for(int i=0;i<7;i++) {
				if(input[i]-1 != input[i+1]) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			return;
		}
		
		System.out.println("mixed");
	}
}
