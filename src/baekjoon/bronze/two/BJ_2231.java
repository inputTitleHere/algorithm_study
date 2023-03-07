package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int len = Integer.toString(n).length();
		
		int result=0;
		
		for(int i = n-(9*len);i<=n;i++) {
			int tmp = i;
			int sum = i;
			while(tmp>0) {
				sum+=tmp%10;
				tmp/=10;
			}
			if(sum==n) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
