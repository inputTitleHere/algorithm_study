package baekjoon._contest.UNIST_DGIST_POSTECH_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int dalgu=0;
		int phonix=0;
		
		for(int i=0;i<n;i++) {
			char c= br.readLine().charAt(0);
			if(c=='D') {
				dalgu++;
			}else {
				phonix++;
			}
			if(Math.abs(dalgu-phonix)>=2) {
				break;
			}
		}
		System.out.printf("%d:%d",dalgu,phonix);
	}
}
