package inflearn._3three;

import java.util.*;
public class Inf03_04v2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int lp=0;
		int rp=0;
		int curr = 0;
		int counter=0;
		for(rp=0;rp<n;rp++) {
			curr+=arr[rp];
			if(curr==m) {
				counter++;
				continue;
			}
			while(curr>m) {
				curr-=arr[lp++];
				if(curr==m) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}
