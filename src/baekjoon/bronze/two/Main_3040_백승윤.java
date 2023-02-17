package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarfs = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			dwarfs[i]=Integer.parseInt(br.readLine());
			sum+=dwarfs[i];
		}
		sum-=100;
		// 그냥 숫자 2개 찾으면된다. -> for 됨.
		CODE : for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(i==j) continue;
				if(dwarfs[i]+dwarfs[j]==sum) {
					dwarfs[i]=dwarfs[j]=0;
					break CODE;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++) {
			if(dwarfs[i]!=0) {
				sb.append(dwarfs[i]).append("\n");				
			}
		}
		System.out.println(sb.toString());
	}
}
