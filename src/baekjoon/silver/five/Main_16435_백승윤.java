package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// java 11 : 136ms
public class Main_16435_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());
		
		int[] fruit = new int[n];
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			fruit[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(fruit);
		
		for(int i=0;i<n;i++) {
			if(fruit[i]<=l) {
				l++;
			}else {
				break;
			}
		}
		System.out.println(l);
	}
}
