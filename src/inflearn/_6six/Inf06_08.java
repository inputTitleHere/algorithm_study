package inflearn._6six;

import java.util.*;
import java.io.*;
public class Inf06_08 {
	public static void main(String[] args) throws IOException {
		// 속도가 중요할 것 같다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split("\\s");
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		in = br.readLine().split("\\s");
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(in[i]);
		}
		Arrays.sort(num);
		
		search(0,n-1,m,num);
		
		
	}
	static void search(int start, int end, int m,int[] arr) {
		int mid = (end+start)/2;
		if(arr[mid]==m) {
			System.out.println(mid+1);
			return;
		}else if(arr[mid]>m) {
			search(start,mid,m,arr);
		}else { // arr[mid]<m
			search(mid,end,m,arr);
		}
	}
}
