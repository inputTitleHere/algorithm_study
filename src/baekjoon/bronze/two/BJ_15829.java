package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15829 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(br.readLine());
		int r = 31;
		int m = 1234567891;
		char[] input = br.readLine().toCharArray();
		
		long sum=(long)(input[0]-'a'+1);
		long track = (long)r;
		
		for(int i=1;i<l;i++) {
			int next = input[i]-'a'+1;
			sum+=track*next;
			sum%=m;
			track*=r;
			track%=m;
		}
		System.out.println(sum);
	}
}
