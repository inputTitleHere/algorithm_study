package baekjoon.bronze.four;

import java.io.*;

public class BJ_10039 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0;i<5;i++) {
			int next = Integer.parseInt(br.readLine());
			if(next<40) {
				next=40;
			}
			sum+=next;
		}
		System.out.println(sum/5);
	}
}
