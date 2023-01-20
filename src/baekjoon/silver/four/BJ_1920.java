package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BJ_1920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] narr = new int[n];
		int ptr = 0;
		while(stk.hasMoreTokens()) narr[ptr++]=Integer.parseInt(stk.nextToken());
		Arrays.sort(narr);
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(stk.hasMoreTokens()) {
			int next = Integer.parseInt(stk.nextToken());
			sb.append(find(next,narr)).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static int find(int n, int[] arr) {
		int lt=0,rt=arr.length, mid=(lt+rt)/2;
		while(rt>lt) {
			if(arr[mid]>n) {
				rt=mid;
				mid=(rt+lt)/2;
			}else if(arr[mid]<n) {
				lt=mid+1;
				mid=(lt+rt)/2;
			}else {
				return 1;
			}
		}
		return 0;
	}
}
