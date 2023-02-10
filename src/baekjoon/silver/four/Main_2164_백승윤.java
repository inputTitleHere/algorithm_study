package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2164_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=1;i<=n;i++) {
			arr[i-1]=i;
		}
		int lt = 0;
		int rt = n;
		int last = -1;
		while(lt!=rt) {
			last = arr[lt%n];
			arr[lt++%n]=0;
			alter(arr,lt++,rt++,n);
		}
		System.out.println(last);
	}
	static void alter(int[] arr, int from, int to,int n) {
		int t = arr[from%n];
		arr[from%n] = arr[to%n];
		arr[to%n]=t;
	}
}
